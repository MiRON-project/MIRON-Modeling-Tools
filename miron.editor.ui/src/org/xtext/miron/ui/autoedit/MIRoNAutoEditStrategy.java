package org.xtext.miron.ui.autoedit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import behaviortree.Attribute;
import behaviortree.TreeNode;

public class MIRoNAutoEditStrategy implements IAutoEditStrategy {

	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		File file;
		
		if (command.text.equals("\n")) {	
			try {
				int line = document.getLineOfOffset(command.offset);
				int lineStart = document.getLineOffset(line);
				int lineLength = document.getLineLength(line);
	
				String xpathExpr = getXpathExpr(document.get(lineStart, lineLength));
		
				if(xpathExpr != null) {
					String btFilePath = getImportedMainBtPath(document);
					
					if(btFilePath == null) {
						command.text += "// No results. Main import not found";
					}
					else {
						if((file = new File(btFilePath)).exists()) {
							// If the path is absolute
							btFilePath = file.getAbsolutePath();
						}
						else {
							// If the path is relative
							btFilePath = getActiveFileFromEditor().toPath().resolveSibling(btFilePath).toString();
						}
					
						if((new File(btFilePath)).exists()) {
							MIRoNXpathResolver resolver = MIRoNXpathResolver.INSTANCE;
			
							List<EObject> results = resolver.evaluateXpath(btFilePath, xpathExpr);
							
							if(results.isEmpty()) {
								command.text += "// No results. Please check the XPath expression";
							}
							else {
								for(int i=0; i<results.size(); i++) {
									if(results.get(i) instanceof TreeNode) {
										command.text += "\tmain." + getTreeNodeAttribute((TreeNode)results.get(i), "name");
										command.text += (i != results.size()-1) ? ",\n" : "\n";
									}
									else if(results.get(i) instanceof Attribute) {
										command.text += "\tmain." + getTreeNodeAttribute((TreeNode)results.get(i).eContainer(), "name");
										command.text += "." + ((Attribute) results.get(i)).getName();
										command.text += (i != results.size()-1) ? ",\n" : "\n";
									}
								}
							}
						}
					}
				}
			} catch (BadLocationException e) {}
		}
	}
	
	private File getActiveFileFromEditor() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		IEditorInput input = editor.getEditorInput();
		IPath path = ((FileEditorInput)input).getPath();
		return path.toFile();
	}
	
	private String getXpathExpr(String line) {
		String result = null;		
		int xpathPos;
		
		if(((xpathPos = line.indexOf("in ")) != -1)
				|| ((xpathPos = line.indexOf("after")) != -1)
				|| ((xpathPos = line.indexOf("before")) != -1))
		{
			int startQuotePos = line.indexOf("\"", xpathPos);
			int endQuotePos = line.indexOf("\"", startQuotePos+1);
			
			if(startQuotePos != -1 && endQuotePos != -1) {
				result = line.substring(startQuotePos+1, endQuotePos);
			}
		}
		return result;
	}
	
	private String getImportedMainBtPath(IDocument document) {
		String line, result = null;
		int startQuotePos, endQuotePos;
		BufferedReader reader = new BufferedReader(new StringReader(document.get()));
		
		try {
			while( (line=reader.readLine()) != null ) {
				if(line.toLowerCase().matches("(\\s)*import(\\s)+(.)+as(\\s)+main$")) {
					startQuotePos = line.indexOf("\"");
					endQuotePos = line.lastIndexOf("\"");
					
					if(startQuotePos != -1 && endQuotePos != -1) {
						if(!(result = line.substring(startQuotePos+1, endQuotePos)).endsWith(".bt")) {
							result = null;
						}
					}
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private String getTreeNodeAttribute(TreeNode node, String attribute) {
		List<Attribute> atts = node.getAttributes();
		Attribute att = null;
		int i = 0;
		
		while(att==null && i<atts.size()) {
			if(atts.get(i).getName().equalsIgnoreCase(attribute)) {
				att = atts.get(i);
			}
			i++;
		}
		return att!=null ? att.getValue() : null;
	}
}
