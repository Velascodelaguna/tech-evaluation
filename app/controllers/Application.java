package controllers;

import play.mvc.*;
import play.*;
import views.html.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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


public class Application extends Controller {

    public static Result index() {
    	List<String> names = Arrays.asList("James", "Rob", "Anastasia", "Maria", "Allan", "Ravneet", "Harpreet");
    	Collections.sort(names);
        return ok(index.render("Welcome to the Website of Group 14!", names));
    }

    public static Result cons()  {


    	List<String> headingList = new ArrayList<>();    
    	try {
    		
    		Document doc = DocumentBuilderFactory
    			       .newInstance()
    		               .newDocumentBuilder()
    		               .parse(new File("app/models/cons.xml"));
    		
    		XPath xpath = XPathFactory.newInstance().newXPath();
    		String getHeadings = "/PlayContent/Heading/text()";
    		NodeList headings = (NodeList) xpath.evaluate(getHeadings, doc, XPathConstants.NODESET);
    		
    		for (int i = 0; i < headings.getLength(); i++) {
    			headingList.add(headings.item(i).toString());
    		}

    	} catch (SAXException | IOException | XPathExpressionException | ParserConfigurationException e) {
    		e.printStackTrace();
    	}

    	headingList.add("PUT STUFF HERE");


    	return ok(presentationpage.render(headingList));
    }

    // public static Result architecture() {

    // }

}
