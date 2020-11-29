package miron.generator.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import behaviortree.Action;
import behaviortree.BTModel;
import behaviortree.BehaviorTree;
import behaviortree.BehaviorTreeFactory;
import behaviortree.ControlNode;
import behaviortree.Import;
import behaviortree.Parallel;
import behaviortree.Repeat;
import behaviortree.Sequence;
import behaviortree.Attribute;
import behaviortree.SetBlackboard;
import behaviortree.SubtreePlus;
import behaviortree.Switch;
import behaviortree.TreeNode;
import miron.metamodel.datatypes.BehaviorTreeEnumType;
import miron.metamodel.datatypes.BehaviorTreeLiteral;
import miron.metamodel.datatypes.MironModel;
import miron.metamodel.kernel.BtBinding;
import miron.metamodel.kernel.InsertionTypeEnum;
import miron.metamodel.kernel.VariationPoint;
import roqme.metamodel.datatypes.ContainedDeclaration;
import roqme.metamodel.datatypes.DataType;
import roqme.metamodel.datatypes.DataTypeDeclaration;
import roqme.metamodel.datatypes.EnumLiteral;
import roqme.metamodel.datatypes.EnumType;
import roqme.metamodel.datatypes.NumericType;
import roqme.metamodel.datatypes.ReferencedDeclaration;
import roqme.metamodel.datatypes.TypedVariable;

public class MironBtWeaver {
	
	private final Logger LOG = new Logger();//LoggerFactory.getLogger(MironBtWeaver.class);
	
	private HashMap<String, String> blackboardDefaultValues;
	private ArrayList<String> importList;
	private Sequence attInitSequence;
	
	public MironBtWeaver() {
		blackboardDefaultValues = new HashMap<>();
		importList = new ArrayList<>();
		attInitSequence = null;
	}
	
	public BTModel process(MironModel mironModel) {
		BTModel outputBt = null;
		VariationPoint varpoint = null;
		
		for(TypedVariable var : mironModel.getVariables()) {
			if(var instanceof VariationPoint){
				varpoint = (VariationPoint) var;
				weaveVarpoint(varpoint);
				
				if(outputBt == null 
						&& varpoint.getBinding() instanceof BtBinding) 
				{
					outputBt = (BTModel) getContainerTree(
							((BtBinding)varpoint.getBinding()).getTargets().get(0)).eContainer();
				}
			}
		}
		
		if(outputBt != null) {
			for(String uri : importList) {
				outputBt.getImports().add(createImport(uri));
			}
		}
		return outputBt;
	}
	
	private void weaveVarpoint(VariationPoint vp) {
		DataType dataType = getDataType(vp);
		
		if(vp.getBinding() != null 
				&& vp.getBinding() instanceof BtBinding) 
		{
			EList<EObject> targets = ((BtBinding) vp.getBinding()).getTargets();
			
			if(dataType instanceof NumericType) {
				for(EObject eobj : targets) {
					if(eobj instanceof Attribute) {
						weaveVpAsAttribute((Attribute) eobj, vp);
					}
				}
			} else if(dataType instanceof EnumType) {
				for(EObject eobj : targets) {
					if(eobj instanceof TreeNode) {
						weaveVpAsSubtree((TreeNode) eobj, vp);
					}
				}	
			} else {
				LOG.error("Target belongs to an unsupported data type (" 
					+ dataType.getClass().getName() + ")");
			}
		}
	}
	
	private void weaveVpAsSubtree(TreeNode target, VariationPoint vp) {
		BehaviorTreeFactory btFactory = BehaviorTreeFactory.eINSTANCE;
		InsertionTypeEnum insertionType = ((BtBinding)vp.getBinding()).getInsertionType();
		EObject parent = target.eContainer();
		EList<TreeNode> nodes = null;
		Switch sw;
		Parallel parallel;
		Repeat repeat;
		Action action;
		int index;
		
		if(parent instanceof ControlNode) {
			nodes = ((ControlNode) parent).getNodes();
		}
		else if(parent instanceof BehaviorTree) {
			nodes = ((BehaviorTree) parent).getNodes();
		}
		else {
			LOG.error("Inappropriate element container for target (" 
					+ target.toString() + ")");
		}
			
		if(nodes != null) {
			action = btFactory.createAction();
			action.getAttributes().add(createAttribute("ID", "VariantAction"));
			action.getAttributes().add(createAttribute("value", "{" + vp.getName() + "_sel}"));

			repeat = btFactory.createRepeat();
			repeat.getAttributes().add(createAttribute("num_cycles", "-1"));
			repeat.setNode(action);
			
			sw = createSwitchVarpoint(vp);
			
			parallel = btFactory.createParallel();
			parallel.getAttributes().add(createAttribute("failure_threshold", "1"));
			parallel.getAttributes().add(createAttribute("success_threshold", "1"));
			parallel.getNodes().add(repeat);
			parallel.getNodes().add(sw);
			
			index = nodes.indexOf(target);
				
			if(index >= 0) {
				if(insertionType == InsertionTypeEnum.BEFORE) {
					nodes.add(index, parallel);
				}
				else if(insertionType == InsertionTypeEnum.AFTER) {
					if (index + 2 < nodes.size()) {
						nodes.add(index + 1, parallel);
					} else {
						nodes.add(parallel);
					}
				}
				else if(insertionType == InsertionTypeEnum.IN) {
					nodes.add(index, parallel);
					sw.getNodes().add(target); // Removes the node from the original list and adds it to sw
				}
				else {
					LOG.error("Unsupported insertion type (" 
							+ insertionType.getName() + ")");
				}
			}
			else {
				LOG.error("Target node not found");
			}
		}
	}
	
	private void weaveVpAsAttribute(Attribute target, VariationPoint vp) {
		InsertionTypeEnum insertionType = ((BtBinding)vp.getBinding()).getInsertionType();
		
		if(insertionType == InsertionTypeEnum.IN) {
			String value = blackboardDefaultValues.get(vp.getName());
			if(value != null && value.equalsIgnoreCase(target.getValue())) {
				LOG.warn("More than one default value for " + vp.getName()); 
			}
			else {
				blackboardDefaultValues.put(vp.getName(), target.getValue());
				
				if(attInitSequence == null) {
					BehaviorTreeFactory btFactory = BehaviorTreeFactory.eINSTANCE;
					BehaviorTree root = getContainerTree(target);
					attInitSequence = btFactory.createSequence();
					attInitSequence.getNodes().addAll(root.getNodes());
					root.getNodes().add(attInitSequence);
				}
				//attInitSequence.getNodes().add(0, 
				//		createSetBlackboard(vp.getName(), target.getValue()));
				target.setValue("{" + vp.getName() + "}");
			}
		}
		else {
			LOG.error("Unsupported insertion type for a numeric target");
		}
	}
	
	private Switch createSwitchVarpoint(VariationPoint vp) {
		BehaviorTreeFactory btFactory = BehaviorTreeFactory.eINSTANCE;

		// Iterating variants
		List<BehaviorTreeLiteral> enumLiterals = getVariants(vp);
		Switch sw = btFactory.createSwitch();
		sw.getAttributes().add(createAttribute("variable", "{" + vp.getName() + "_sel" + "}"));
		SubtreePlus subtreeVariant;
		
		int index = 0;

		for (BehaviorTreeLiteral literal : enumLiterals) {
			if(!literal.isPreset()) {
				subtreeVariant = btFactory.createSubtreePlus();
				subtreeVariant.setBehaviortree(literal.getReference());
				addImport(literal.getReference());
	
				sw.getAttributes().add(createAttribute("case_" + (index + 1), literal.getName()));
				sw.getNodes().add(subtreeVariant);
				
				index++;
			}
		}
		// Optionality
		if (((BtBinding)vp.getBinding()).getInsertionType() == InsertionTypeEnum.BEFORE
				|| ((BtBinding)vp.getBinding()).getInsertionType() == InsertionTypeEnum.AFTER) {
			// ... <AlwaysSuccess/>
			sw.getNodes().add(btFactory.createAlwaysSuccess());
		}
		return sw;
	}
	
	private Attribute createAttribute(String name, String value) {
		Attribute attr = BehaviorTreeFactory.eINSTANCE.createAttribute();
		attr.setName(name);
		attr.setValue(value);
		return attr;
	}
	
	@SuppressWarnings("unused")
	private SetBlackboard createSetBlackboard(String key, String value) {
		SetBlackboard sb = BehaviorTreeFactory.eINSTANCE.createSetBlackboard();
		sb.getAttributes().add(createAttribute("output_key", "{" + key + "}"));
		sb.getAttributes().add(createAttribute("value", value));
		return sb;
	}

	private Import createImport(String uri) {
		Import res = BehaviorTreeFactory.eINSTANCE.createImport();
		res.setImportURI(uri);
		return res;
	}
	
	private void addImport(BehaviorTree bt) {
		String uri = bt.eResource().getURI().toString();
		if(!importList.contains(uri)) {
			importList.add(uri);
		}
	}
	
	private BehaviorTree getContainerTree(EObject object) {
		EObject eobj = object;
		
		while(!(eobj instanceof BehaviorTree) && eobj != null) {
			eobj = eobj.eContainer();
		}
		return (BehaviorTree) eobj;
	}
	
	private DataType getDataType(VariationPoint vp) {
		DataType dataType = null;
		DataTypeDeclaration typeDeclaration = vp.getDeclaration();
		
		if(typeDeclaration instanceof ContainedDeclaration) {
			dataType = (((ContainedDeclaration) typeDeclaration).getType());
		}
		else if(typeDeclaration instanceof ReferencedDeclaration) {
			dataType = (((ReferencedDeclaration) typeDeclaration).getType().getDataType());
		}
		return dataType;
	}
	
	private List<BehaviorTreeLiteral> getVariants(VariationPoint vp) {
		
		List<BehaviorTreeLiteral> result = new ArrayList<>();
		EList<BehaviorTreeLiteral> literals;
		DataTypeDeclaration typeDeclaration = vp.getDeclaration();
		DataType dataType = null;
		
		if(typeDeclaration instanceof ContainedDeclaration) {
			dataType = ((ContainedDeclaration) typeDeclaration).getType();
		}
		else if(typeDeclaration instanceof ReferencedDeclaration) {
			dataType = ((ReferencedDeclaration) typeDeclaration).getType().getDataType();
		}
		
		if(dataType instanceof BehaviorTreeEnumType) {
			literals = ((BehaviorTreeEnumType) dataType).getLiterals();

			for(EnumLiteral lit : literals) {
				if(lit instanceof BehaviorTreeLiteral) {
					result.add((BehaviorTreeLiteral)lit);
				}
			}
		}
		return result;
	}
	
	public class Logger {
		public void error(String msj) {
			System.out.println("Error: " + msj);
		}
		public void warn(String msj) {
			System.out.println("Warn: " + msj);
		}
	}
}
