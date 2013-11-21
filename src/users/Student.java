package users;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Student extends User {

    private String year;

    /**
     * 
     * @param name
     * @param forname
     * @param field
     */
    public Student(String name, String forname, String field) {

        super(name, forname);

        this.year = field;
    }

    /**
     * 
     * @return
     */
    public String getField() {

        return year;
    }

    /**
     * 
     * @param field
     */
    public void setField(String field) {

        this.year = field;
    }
}
