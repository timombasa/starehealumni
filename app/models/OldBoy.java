package models;

import play.data.validation.Constraints.Required;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class OldBoy {

    @Id
    public Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private Long yearOfTheCharge;

    private String house;

    private String expertise;

    private String location;

    @Required
    private String contact;
    
    public static List<OldBoy> all() {
        return new ArrayList<OldBoy>();
    }

    public static void create(OldBoy oldBoy) {

    }
    
    public static void delete(Long id) {

    }
}
