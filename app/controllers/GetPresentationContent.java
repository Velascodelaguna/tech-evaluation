package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetPresentationContent {
    public static List<String> getHeadings(final String xpathExpr, final String path){
	
	List<String> headingList = new ArrayList<>();
	
	try {
		
		Document doc = DocumentBuilderFactory
			       .newInstance()
		               .newDocumentBuilder()
		               .parse(new File(path));
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList headings = (NodeList) xpath.evaluate(xpathExpr, doc, XPathConstants.NODESET);
		
		for (int i = 0; i < headings.getLength(); i++) {
			headingList.add( getTextOnly(headings.item(i).toString() ));
		}
		

	} catch (SAXException | IOException | XPathExpressionException | ParserConfigurationException e) {
		e.printStackTrace();
	}
	
	return headingList;
	
    }
    
    private static String getTextOnly(final String text) {
	int colonIndex = text.indexOf(":") + 1;
	int lastIndex = text.lastIndexOf("]");
	return text.substring(colonIndex, lastIndex).trim();
    }

}
