package org.xtext.behaviortree.naming;

import java.util.Iterator;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import behaviortree.BehaviorTree;
import behaviortree.Subtree;
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
	
	public QualifiedName qualifiedName(Subtree node) {
		return QualifiedName.create(getAttributeValue(node, "name"));
	}

	public QualifiedName qualifiedName(TreeNode node) {
		return QualifiedName.create(getAttributeValue(node, "name"));
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
