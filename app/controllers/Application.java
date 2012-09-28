package controllers;

import java.util.*;

import play.mvc.*;
import play.data.*;
import play.*;

import views.html.*;

import models.*;

public class Application extends Controller {

    public static Result GO_HOME = redirect(
        routes.Application.list(0, "name", "asc", "")
    );

    public static Result index() {
        return GO_HOME;
    }

    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
                list.render(
                     OldBoy.page(page, 10, sortBy, order, filter),
                     sortBy, order, filter
                )
        );
    }

    // Display the 'edit form' of an existing OldBoy
    public static Result edit(Long id) {
        Form<OldBoy> oldBoyForm = form(OldBoy.class).fill(
            OldBoy.find.byId(id)
        );
        return ok(
          editForm.render(id, oldBoyForm)
        );
    }

    // Handle the 'edit form' submission
    public static Result update(Long id) {
        Form<OldBoy> oldBoyForm = form(OldBoy.class).bindFromRequest();
        if(oldBoyForm.hasErrors()) {
            return badRequest(editForm.render(id, oldBoyForm));
        }
        oldBoyForm.get().update(id);
        flash("success", "OldBoy " + oldBoyForm.get().name() + " has been updated");
        return GO_HOME;
    }

    // Display the 'new oldBoy form'
    public static Result create(){
        Form<OldBoy> filledForm = form(OldBoy.class);
            return ok(
                    createForm.render(filledForm)
            );
    }

    public static Result save() {
        Form<OldBoy> oldBoyForm = form(OldBoy.class).bindFromRequest();
        if(oldBoyForm.hasErrors()) {
            return badRequest(createForm.render(oldBoyForm));
        }
        oldBoyForm.get().save();
        flash("success", "OldBoy " + oldBoyForm.get().name() + " has been created");
        return GO_HOME;
    }

    public static Result delete(Long id){
        OldBoy.find.ref(id).delete();
        flash("success", "OldBoy has been deleted");
        return GO_HOME;
    }
}
            
