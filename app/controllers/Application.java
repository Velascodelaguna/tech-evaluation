package controllers;

import play.mvc.*;
import play.*;
import views.html.*;

import java.util.*;
import java.util.Collections;

public class Application extends Controller {

    public static Result index() {
    	List<String> names = Arrays.asList("James", "Rob", "Anastasia", "Maria", "Allan", "Ravneet", "Harpreet");
    	Collections.sort(names);
        return ok(index.render("Welcome to the website of group 8", names));
    }

}
