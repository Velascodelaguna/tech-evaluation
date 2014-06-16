package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	private final static String xpathHeadings = "/PlayContent/Heading/text()";
	private final static String xpathInfo = "/PlayContent/Heading[@name=\"%s\"/info/text()";
	
    public static Map<String, List<String>> getContent(final String path){
	
    	Map<String, List<String>> content = new LinkedHashMap<String, List<String>>();
		List<String> headingList = new ArrayList<>();
		
		try {
			
			Document doc = DocumentBuilderFactory
				       .newInstance()
			               .newDocumentBuilder()
			               .parse(new File(path));
			
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList headings = (NodeList) xpath.evaluate(xpathHeadings, doc, XPathConstants.NODESET);
			
			for (int i = 0; i < headings.getLength(); i++) {
				headingList.add( getTextOnly(headings.item(i).toString() ));
			}
			
			for (String heading: headingList) {
				NodeList info = (NodeList) xpath.evaluate(String.format(xpathInfo, heading), doc, XPathConstants.NODESET);
				List<String> infoList = new ArrayList<String>();
				
				for (int i = 0; i < info.getLength(); i++) {
					infoList.add(getTextOnly(info.item(i).toString()));
				}
				
				content.put(heading, infoList);
			}
			
	
		} catch (SAXException | IOException | XPathExpressionException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return content;
	
    }
    
    private static String getTextOnly(final String text) {
		int colonIndex = text.indexOf(":") + 1;
		int lastIndex = text.lastIndexOf("]");
		return text.substring(colonIndex, lastIndex).trim();
    }
}
