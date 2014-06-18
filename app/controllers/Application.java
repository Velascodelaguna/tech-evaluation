package controllers;


import play.mvc.*;
import views.html.*;
import play.libs.F.Tuple;

import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Application extends Controller {

    public static Result index() {
    	List<String> names = Arrays.asList("James", "Rob", "Anastasia", "Maria", "Allan", "Ravneet", "Harpreet");
    	Collections.sort(names);
        return ok( intro.render(names) );
    }

    public static Result cons()  {
    	final String filePath = "app/models/cons.xml";
    	return showPresentation(filePath);
    }
    
    public static Result pros()  {
        final String filePath = "app/models/pros.xml";
        return showPresentation(filePath);
    }    
    
    public static Result features()  {
        final String filePath = "app/models/features.xml";
        return showPresentation(filePath);
    } 
    
    public static Result about()  {
        final String filePath = "app/models/whatisplay.xml";
        return showPresentation(filePath);
    } 
    
    public static Result background()  {
        final String filePath = "app/models/background.xml";
        return showPresentation(filePath);
    } 

    public static Result architecture() {
        final String filePath = "app/models/architecture.xml";
        return showImagePresentation(filePath);
    }
    
    public static Result actions() {
        final String filePath = "app/models/actions.xml";
        Tuple<String, Map<String, List<String>>> content = GetPresentationContent.getContent(filePath);
        return ok( actionspage.render(content) ) ;
        
    }
    
    public static Result views() {
        final String filePath = "app/models/architecture.xml";
        Tuple<String, Map<String, List<String>>> content = GetPresentationContent.getContent(filePath);
        return  ok( views.render(content) ) ;
    }
    
    public static Result routes() {
        final String filePath = "app/models/routes.xml";
        Tuple<String, Map<String, List<String>>> content = GetPresentationContent.getContent(filePath);
        return  ok( routespage.render(content) ) ;
    }
    
    public static Result dir() {
        final String filePath = "app/models/directory.xml";
        return showImagePresentation(filePath);
    }

    public static Result questions() {
        return ok ( questions.render() );
    }
    
    private static Result showPresentation(final String filePath) {
        Tuple<String, Map<String, List<String>>> content = GetPresentationContent.getContent(filePath);
        return ok ( presentationpage.render( content ) );
    }
    
    private static Result showImagePresentation(final String filePath) {
        Tuple<String, Map<String, List<String>>> content = GetPresentationContent.getContent(filePath);
        return ok ( image.render( content ) );
    }
    


}
