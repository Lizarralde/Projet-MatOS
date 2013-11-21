package users;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Teacher extends User {

    private String field;

    /**
     * 
     * @param name
     * @param forname
     * @param field
     */
    public Teacher(String name, String forname, String field) {

        super(name, forname);

        this.field = field;
    }

    /**
     * 
     * @return
     */
    public String getField() {

        return field;
    }

    /**
     * 
     * @param field
     */
    public void setField(String field) {

        this.field = field;
    }
}
