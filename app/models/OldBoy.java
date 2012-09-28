package models;

import com.avaje.ebean.Page;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Entity
public class OldBoy extends Model{

    @Id
    public Long id;

    @Constraints.Required
    private String name;

    private String contact;

    private Long yearOfTheCharge;

    private String house;

    private String expertise;

    // @ManyToOne
    private String location;

    public String name() {
        return name;
    }

    public static Finder<Long, OldBoy> find = new Finder(
      Long.class, OldBoy.class
    );

    // Return a page of an oldboy
    public static Page<OldBoy> page(int page, int pageSize, String sortBy, String order, String filter) {
        return find.where()
                   .ilike("name", "%" + filter + "%")
                   .orderBy(sortBy + " " + order)
                   .fetch("company")
                   .findPagingList(pageSize)
                   .getPage(page);
    }

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
