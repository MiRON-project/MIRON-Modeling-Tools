package org.xtext.miron.ui.autoedit;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.inject.Injector;

import behaviortree.Attribute;
import behaviortree.BTModel;
import behaviortree.BehaviorTree;
import behaviortree.TreeNode;
import miron.editor.ui.internal.EditorActivator;


public class MIRoNXpathResolver {
	
	public static final MIRoNXpathResolver INSTANCE = new MIRoNXpathResolver();

	private final Injector INJECTOR = EditorActivator.getInstance().getInjector(
			EditorActivator.ORG_XTEXT_MIRON_MIRON);
	
	private final String BT_FILE_EXT = "bt";
	
	
	public List<EObject> evaluateXpath(String btFilePath, String expression) {
		List<EObject> result = new ArrayList<>();

		if(btFilePath.endsWith(BT_FILE_EXT)) {
			XtextResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);
			Resource btResource = resourceSet.getResource(URI.createFileURI(btFilePath), true);
			result = evaluateXpath(btResource, expression);
		}
		return result;
	}
	
	public List<EObject> evaluateXpath(Resource btResource, String expression) {
		ArrayList<EObject> result = new ArrayList<>();
		String btFilePath = btResource.getURI().toString();
		if(btFilePath.startsWith("file:")) {
			btFilePath = btFilePath.substring("file:".length());
		}
		
		try {
			if(btResource.getContents().get(0) instanceof BTModel) {

				BTModel btModel = (BTModel) btResource.getContents().get(0);
			
				FileInputStream fileIS = new FileInputStream(btFilePath);
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
				Document xmlDocument = builder.parse(fileIS);
				
				XPath xPath = XPathFactory.newInstance().newXPath();
				NodeList nodes = (NodeList) xPath.compile(expression)
						.evaluate(xmlDocument, XPathConstants.NODESET);
				EObject eobj;
				
				for(int j=0; j<nodes.getLength(); j++) {
					eobj = getEObjectFromNode(nodes.item(j), btModel);
					if(eobj != null) {
						result.add(eobj);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private EObject getEObjectFromNode(Node node, BTModel root) {
		
		EObject result = null;
		
		if(node instanceof Attr) {
			Attr attrNode = (Attr) node;
			EObject eobj = getEObjectFromIndexes(root, 
					getIndexesFromNode(attrNode.getOwnerElement()));
			
			if(eobj instanceof TreeNode) {
				EList<Attribute> attrs = ((TreeNode) eobj).getAttributes();
				boolean found = false;
				int i = 0;
				
				while(!found && i<attrs.size()) {
					if(found = attrs.get(i).getName().equalsIgnoreCase(attrNode.getNodeName())) {
						result = attrs.get(i);
					}
					i++;
				}
			}
		}
		else {
			result = getEObjectFromIndexes(root, getIndexesFromNode(node));
		}
		return result;
	}
	
	private List<Integer> getIndexesFromNode(Node node) {
		ArrayList<Integer> result = new ArrayList<>();
		getIndexesFromNode(node, result);
		return result;
	}
	
	private void getIndexesFromNode(Node node, List<Integer> indexes) {
		Node auxNode, parent = node.getParentNode();
		NodeList children;
		boolean found = false;
		int i=0, idx=0;
		
		if(parent != null) {
			children = parent.getChildNodes();
			while(!found && i<children.getLength()) {
				auxNode = children.item(i);
				if(found = auxNode.isSameNode(node)) {
					indexes.add(idx);
				}
				if(auxNode.getNodeType() == Node.ELEMENT_NODE) {
					idx++;
				}
				i++;
			}
			getIndexesFromNode(parent, indexes);
		}
	}
	
	private EObject getEObjectFromIndexes(EObject root, List<Integer> indexes) {
		EObject result = root;
		EList<EObject> children;
		int j, idx, i=indexes.size()-2;
		boolean found=true;
		
		while(found && i>=0) {
			children = result.eContents();
			j = 0; idx = 0; 
			found = false;
			
			while(!found && j<children.size()) {
				if(children.get(j) instanceof TreeNode
						|| children.get(j) instanceof BTModel
						|| children.get(j) instanceof BehaviorTree) {	
					if(idx == indexes.get(i)) {
						result = children.get(j);
						found = true;
					}
					idx++;
				}
				j++;
			}
			i--;
		}
		return found ? result : null;
	}
}
