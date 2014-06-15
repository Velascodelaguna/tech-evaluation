package controllers;

import play.mvc.*;
import play.*;
import views.html.*;

import java.util.*;




public class Application extends Controller {

    public static Result index() {
    	List<String> names = Arrays.asList("James", "Rob", "Anastasia", "Maria", "Allan", "Ravneet", "Harpreet");
    	Collections.sort(names);
        return ok(index.render("Welcome to the Website of Group 14!", names));
    }

    public static Result cons()  {
	final String filePath = "app/models/cons.xml";
	final String xpathHeadings = "/PlayContent/Heading[@name]/text()";
	List<String> headingList = GetPresentationContent.getHeadings(xpathHeadings, filePath);
	
    	return ok(presentationpage.render(headingList));
    }
    

    // public static Result architecture() {

    // }

}
