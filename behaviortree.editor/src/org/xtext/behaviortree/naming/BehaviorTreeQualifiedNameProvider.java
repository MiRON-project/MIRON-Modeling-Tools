package org.xtext.behaviortree.naming;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import behaviortree.BehaviorTree;
import behaviortree.Attribute;
import behaviortree.TreeNode;


public class BehaviorTreeQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	public QualifiedName qualifiedName(BehaviorTree bt) {
		String result = null;
		Attribute attr;
		Iterator<Attribute> it = bt.getAttributes().iterator();
		
		while(result == null && it.hasNext()) {
			attr = it.next();
			if(attr.getName().equalsIgnoreCase("ID")) {
				result = attr.getValue();
			}
		}
		return QualifiedName.create(result);
	}

	public QualifiedName qualifiedName(TreeNode node) {
		String attrValue = getAttributeValue(node, "ID");
		if(attrValue == null) {
			attrValue = getAttributeValue(node, "name");
		}
		return QualifiedName.create(attrValue);
	}
	
	private String getAttributeValue(TreeNode node, String attrName) {
		String result = null;
		Attribute attr;
		Iterator<Attribute> it = node.getAttributes().iterator();
		
		while(result == null && it.hasNext()) {
			attr = it.next();
			if(attr.getName().equalsIgnoreCase(attrName)) {
				result = attr.getValue();
			}
		}
		return result;
	}
}
