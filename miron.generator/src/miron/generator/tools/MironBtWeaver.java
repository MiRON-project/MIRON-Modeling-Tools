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
import behaviortree.Condition;
import behaviortree.ControlNode;
import behaviortree.Fallback;
import behaviortree.Import;
import behaviortree.Attribute;
import behaviortree.Sequence;
import behaviortree.SetBlackboard;
import behaviortree.SubTreeWrapper;
import behaviortree.Subtree;
import behaviortree.Switch;
import behaviortree.TreeNode;
import miron.metamodel.datatypes.BehaviorTreeLiteral;
import miron.metamodel.datatypes.MironModel;
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

	private final Logger LOG = new Logger();// LoggerFactory.getLogger(MironBtWeaver.class);

	private HashMap<String, String> blackboardDefaultValues;
	private ArrayList<String> importList;
	private Logger log;

	public MironBtWeaver() {
		blackboardDefaultValues = new HashMap<>();
		importList = new ArrayList<>();
	}

	public BTModel process(MironModel mironModel) {
		BTModel outputBt = null;
		VariationPoint varpoint = null;

		for (TypedVariable var : mironModel.getVariables()) {
			if (var instanceof VariationPoint) {
				varpoint = (VariationPoint) var;
				weaveVarpoint(varpoint);
			}
		}

		if (varpoint != null) {
			outputBt = (BTModel) getContainerTree(varpoint.getBinding().getTargets().get(0)).eContainer();

			for (String uri : importList) {
				outputBt.getImports().add(createImport(uri));
			}
		}
		return outputBt;
	}

	private void weaveVarpoint(VariationPoint vp) {
		DataType dataType = getDataType(vp);
		EList<EObject> targets = vp.getBinding().getTargets();

		if (dataType instanceof EnumType) {
			for (EObject eobj : targets) {
				System.out.println("Objeto: " + eobj);
				if (eobj instanceof TreeNode) {
					weaveVpAsSubtree((TreeNode) eobj, vp);
				}
			}
		} else if (dataType instanceof NumericType) {
			for (EObject eobj : targets) {
				System.out.println("Objeto: " + eobj);
				if (eobj instanceof Attribute) {
					weaveVpAsAttribute((Attribute) eobj, vp);
				}
			}
		} else {
			LOG.error("Target belongs to an unsupported data type (" + dataType.getClass().getName() + ")");
		}
	}

	private void weaveVpAsSubtree(TreeNode target, VariationPoint vp) {
		BehaviorTreeFactory btFactory = BehaviorTreeFactory.eINSTANCE;
		InsertionTypeEnum insertionType = vp.getBinding().getInsertionType();
		EObject parent = target.eContainer();
		EList<TreeNode> nodes = null;
		Switch sw;
		int index;

		if (parent instanceof ControlNode) {
			nodes = ((ControlNode) parent).getNodes();
		} else if (parent instanceof BehaviorTree) {
			nodes = ((BehaviorTree) parent).getNodes();
		} else {
			LOG.error("Inappropriate element container for target (" + target.toString() + ")");
		}

		if (nodes != null) {

			sw = createSwitchVarpoint(vp);

			Action act_reqMiron = btFactory.createAction();
			act_reqMiron.getAttributes().add(createAttribute("ID", "RequestMiron"));
			act_reqMiron.getAttributes().add(createAttribute("output", "{" + vp.getName() + "_sel}"));

			index = nodes.indexOf(target);

			if (index >= 0) {
				if (insertionType == InsertionTypeEnum.BEFORE) {
					nodes.add(index, act_reqMiron);
					nodes.add(index + 1, sw);
				} else if (insertionType == InsertionTypeEnum.AFTER) {
					if (index + 2 < nodes.size()) {
						nodes.add(index + 1, act_reqMiron);
						nodes.add(index + 2, sw);
					} else {
						nodes.add(act_reqMiron);
						nodes.add(sw);
					}
				} else if (insertionType == InsertionTypeEnum.IN) {
					nodes.add(index, act_reqMiron);
					sw.getNodes().add(nodes.get(nodes.indexOf(target)));
					nodes.add(index + 1, sw);
					nodes.remove(index + 2);
				} else {
					LOG.error("Unsupported insertion type (" + insertionType.getName() + ")");
				}
			} else {
				LOG.error("Target node not found");
			}
		}
	}

	private void weaveVpAsAttribute(Attribute target, VariationPoint vp) {
		InsertionTypeEnum insertionType = vp.getBinding().getInsertionType();

		if (insertionType == InsertionTypeEnum.IN) {
			String value = blackboardDefaultValues.get(vp.getName());
			if (value != null && value.equalsIgnoreCase(target.getValue())) {
				LOG.warn("More than one default value for " + vp.getName());
			} else {
				blackboardDefaultValues.put(vp.getName(), target.getValue());
				target.setValue("{" + vp.getName() + "}");
			}
		} else {
			LOG.error("Unsupported insertion type for a numeric target");
		}
	}

	private Switch createSwitchVarpoint(VariationPoint vp) {
		BehaviorTreeFactory btFactory = BehaviorTreeFactory.eINSTANCE;

		// Iterating variants
		List<BehaviorTreeLiteral> enumLiterals = getVariants(vp);
		Switch sw = btFactory.createSwitch();
		sw.getAttributes().add(createAttribute("variable", "{" + vp.getName() + "_sel" + "}"));
		// TreeNode tree_node = BehaviorTreeFactory.eINSTANCE.cr;
		SubTreeWrapper sub_variant;

		int index = 0;
		System.out.println("Bucle literales");

		for (BehaviorTreeLiteral literal : enumLiterals) {

			sub_variant = btFactory.createSubTreeWrapper();
			sub_variant.setBehaviortree(literal.getReference());
			addImport(literal.getReference());
			System.out.println(sub_variant.getBehaviortree().getAttributes());
			for (Attribute attb : sub_variant.getBehaviortree().getAttributes()) {
				if (attb.getName().toUpperCase().equals("ID")) {
					sw.getAttributes().add(createAttribute("case_" + (index + 1), attb.getValue()));
				}
			}
			sw.getNodes().add(sub_variant);
			index++;

		}
		// Optionality
		if (vp.getBinding().getInsertionType() == InsertionTypeEnum.BEFORE
				|| vp.getBinding().getInsertionType() == InsertionTypeEnum.AFTER) {
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

	private SetBlackboard createSetBlackboard(String key, String value) {
		SetBlackboard sb = BehaviorTreeFactory.eINSTANCE.createSetBlackboard();
		sb.getAttributes().add(createAttribute("output_key", key ));
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
		if (!importList.contains(uri)) {
			importList.add(uri);
		}
	}

	private BehaviorTree getContainerTree(EObject object) {
		EObject eobj = object;

		while (!(eobj instanceof BehaviorTree) && eobj != null) {
			eobj = eobj.eContainer();
		}
		return (BehaviorTree) eobj;
	}

	private ControlNode getContainerControlNode(EObject object) {
		EObject eobj = object;

		while (!(eobj instanceof ControlNode) && eobj != null) {
			eobj = eobj.eContainer();
		}
		return (ControlNode) eobj;
	}

	private DataType getDataType(VariationPoint vp) {
		DataType dataType = null;
		DataTypeDeclaration typeDeclaration = vp.getDeclaration();

		if (typeDeclaration instanceof ContainedDeclaration) {
			dataType = (((ContainedDeclaration) typeDeclaration).getType());
		} else if (typeDeclaration instanceof ReferencedDeclaration) {
			dataType = (((ReferencedDeclaration) typeDeclaration).getType().getDataType());
		}
		return dataType;
	}

	private List<BehaviorTreeLiteral> getVariants(VariationPoint vp) {

		List<BehaviorTreeLiteral> result = new ArrayList<>();
		EList<EnumLiteral> literals;
		DataTypeDeclaration typeDeclaration = vp.getDeclaration();
		DataType dataType = null;

		if (typeDeclaration instanceof ContainedDeclaration) {
			dataType = ((ContainedDeclaration) typeDeclaration).getType();
		} else if (typeDeclaration instanceof ReferencedDeclaration) {
			dataType = ((ReferencedDeclaration) typeDeclaration).getType().getDataType();
		}

		if (dataType instanceof EnumType) {
			literals = ((EnumType) dataType).getLiterals();

			for (EnumLiteral lit : literals) {
				if (lit instanceof BehaviorTreeLiteral) {
					result.add((BehaviorTreeLiteral) lit);
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
