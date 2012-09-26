package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class OldBoy extends Model{

    @Id
    public Long id;

    private String contact;

    private String firstName;

    private String middleName;

    private String lastName;

    private Long yearOfTheCharge;

    private String house;

    private String expertise;

    private String location;

    public static Finder<Long, OldBoy> find = new Finder(
      Long.class, OldBoy.class
    );
    
    public static List<OldBoy> all() {
        return find.all();
    }

    public static void create(OldBoy oldBoy) {
        oldBoy.save();
    }
    
    public static void delete(Long id) {
        find.ref(id).delete();
    }
}
