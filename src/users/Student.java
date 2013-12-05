package users;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Student extends User {

    private String year;

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     * @param name
     *            Name of the student.
     * @param forname
     *            Forname of the student.
     * @param year
     *            Year of the student.
     */
    public Student(String name, String forname, String year) {

        super(name, forname);

        this.year = year;
    }

    /**
     * Return the year of the student.
     * 
     * @author Dorian LIZARRALDE
     * @return
     */
    public String getYear() {

        return year;
    }

    /**
     * Set the year of the student.
     * 
     * @author Dorian LIZARRALDE
     * @param year
     */
    public void setYear(String year) {

        this.year = year;
    }
}
