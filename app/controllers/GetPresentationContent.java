package controllers;


import play.libs.F.Tuple;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetPresentationContent {

    private final static String xpathHeadings = "/PlayContent/Heading/@name";
    private final static String xpathInfo = "/PlayContent/Heading[@name=\"%s\"]/Info/text()";
    private final static String xpathTitle = "/PlayContent/Title/text()";
    private final static String quote = "\"";
    
    public static Tuple<String, Map<String, List<String>>> getContent(final String path){

        final Map<String, List<String>> content = new LinkedHashMap<String, List<String>>();
        final List<String> headingList = new ArrayList<>();
        String title = null;
        
        try {
//            final String serverPath = "/home/group14/tech-evaluation/" + path;
            final String serverPath = path;
            final Document doc = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new File(serverPath));

            XPath xpath = XPathFactory.newInstance().newXPath();
            
            final Node titleNode = (Node) xpath.evaluate(xpathTitle, doc, XPathConstants.NODE);
            title = getTextOnly( titleNode.toString() );
            
            final NodeList headings = (NodeList) xpath.evaluate(xpathHeadings, doc, XPathConstants.NODESET);

            for (int i = 0; i < headings.getLength(); i++) {
                headingList.add( getAttributeValue(headings.item(i).toString() ));
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

        return new Tuple<String, Map<String, List<String>>>(title, content);
    }

    private static String getTextOnly(final String text) {
        int colonIndex = text.indexOf(":") + 1;
        int lastSqBracketIndex = text.lastIndexOf("]");
        return text.substring(colonIndex, lastSqBracketIndex).trim();
    }
    
    private static String getAttributeValue(final String keyValPair) {
        int firstQuoteIndex = keyValPair.indexOf(quote);
        int lastQuoteIndex = keyValPair.lastIndexOf(quote);
        return keyValPair.substring(firstQuoteIndex+1, lastQuoteIndex).trim();
    }
}
