package miron.generator.tools;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.resources.IFile;
import org.w3c.dom.Document;

import behaviortree.BTModel;
import miron.metamodel.datatypes.MironModel;

//TODO
public class MironXpathResolver {
	
	private MironModel mironModel;
	Document xmlDocument;
	
	public MironXpathResolver() {
		
	}
	
	public void createMapping(MironModel mironModel) {
	/*	
		String filepath = mironFile.getLocationURI().toString();
		
		
		
		FileInputStream fileIS = new FileInputStream(filepath);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(fileIS);
		
		
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "/Tutorials/Tutorial";
		nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
		*/
		
	}
	
	public void createMapping(BTModel btModel, Document xmlDocument) {
		
	}	
}
