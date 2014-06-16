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
    	Map<String, List<String>> consContent = GetPresentationContent.getContent(filePath);
    	
    	List<String> headingList = new ArrayList<String>();
    	headingList.addAll(consContent.keySet());
    	
    	return ok( presentationpage.render("Title goes here", consContent) );
    }
    

    // public static Result architecture() {

    // }

}
