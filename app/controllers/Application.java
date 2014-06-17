package controllers;

import play.mvc.*;
import play.*;
import views.html.*;

import java.util.*;




public class Application extends Controller {

    public static Result index() {
    	List<String> names = Arrays.asList("James", "Rob", "Anastasia", "Maria", "Allan", "Ravneet", "Harpreet");
    	Collections.sort(names);
        return ok( intro.render(names) );
    }

    public static Result cons()  {
    	final String filePath = "app/models/cons.xml";
    	Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
    	    	
    	return ok( presentationpage.render("Disadvantages of Play", content) );
    }
    
    public static Result pros()  {
        final String filePath = "app/models/pros.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
                
        return ok( presentationpage.render("Advantages of Play", content) );
    }    
    
    public static Result features()  {
        final String filePath = "app/models/features.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
                
        return ok( presentationpage.render("Features of Play", content) );
    } 
    
    public static Result about()  {
        final String filePath = "app/models/whatisplay.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
                
        return ok( presentationpage.render("What is Play?", content) );
    } 
    
    public static Result background()  {
        final String filePath = "app/models/background.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
                
        return ok( presentationpage.render("Background Information", content) );
    } 

    public static Result architecture() {
        final String filePath = "app/models/architecture.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
        
        return ok( image.render("Architecture of Play", content) );
    }
    
    public static Result actions() {
        final String filePath = "app/models/architecture.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
        
        return ok( presentationpage.render("Architecture of Play", content) );
    }
    
    public static Result views() {
        final String filePath = "app/models/architecture.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
        
        return ok( presentationpage.render("Architecture of Play", content) );
    }
    
    public static Result routes() {
        final String filePath = "app/models/architecture.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
        
        return ok( presentationpage.render("Architecture of Play", content) );
    }
    
    public static Result dir() {
        final String filePath = "app/models/architecture.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
        
        return ok( presentationpage.render("Architecture of Play", content) );
    }
    
    public static Result questions() {
        final String filePath = "app/models/architecture.xml";
        Map<String, List<String>> content = GetPresentationContent.getContent(filePath);
        
        return ok( presentationpage.render("Architecture of Play", content) );
    }

}
