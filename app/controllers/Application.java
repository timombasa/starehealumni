package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result index() {
        return ok("Hello World");
    }


    public static Result oldboys(){
        return TODO;
    }

    public static Result newOldboy(){
        return TODO;
    }


    public static Result deleteOldboy(Long id){
        return TODO;
    }
}
            
