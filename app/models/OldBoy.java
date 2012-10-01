package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;


@Entity
public class OldBoy extends Model{

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    private String contact;

    @Constraints.Required
    private Long yearOfTheCharge;

    @Constraints.Required
    private String house;

    @Constraints.Required
    private String expertise;

    @Constraints.Required
    private String location;

    public String name() {
        return name;
    }

    // Generic query helper for entity OldBoy with id Long
    public static Finder<Long, OldBoy> find = new Finder(
      Long.class, OldBoy.class
    );

    // Return a page of an oldboy
    public static Page<OldBoy> page(int page, int pageSize, String sortBy, String order, String filter) {
        return find.where()
                   .ilike("name", "%" + filter + "%")
                   .orderBy(sortBy + " " + order)
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
