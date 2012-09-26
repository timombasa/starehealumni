package controllers;

import models.OldBoy;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    static Form<OldBoy> oldBoyForm = form(OldBoy.class);

    public static Result index() {
        return redirect(routes.Application.oldBoys());
    }

    public static Result oldBoys(){
        return ok(
          views.html.index.render(OldBoy.all(), oldBoyForm)
        );
    }

    public static Result newOldBoy(){
        return TODO;
    }


    public static Result deleteOldBoy(Long id){
        return TODO;
    }
}
            
