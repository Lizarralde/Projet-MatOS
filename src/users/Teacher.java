package users;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Teacher extends User {

    private String field;

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     * @param name
     *            Name of the teacher.
     * @param forname
     *            Forname of the teacher.
     * @param field
     *            Field of the teacher.
     */
    public Teacher(String name, String forname, String field) {

        super(name, forname);

        this.field = field;
    }

    /**
     * Return the field of the teacher.
     * 
     * @author Dorian LIZARRALDE
     * @return
     */
    public String getField() {

        return field;
    }

    /**
     * Set the field of the teacher.
     * 
     * @author Dorian LIZARRALDE
     * @param field
     */
    public void setField(String field) {

        this.field = field;
    }
}
