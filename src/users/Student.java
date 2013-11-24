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
     * @param year
     */
    public Student(String name, String forname, String year) {

        super(name, forname);

        this.year = year;
    }

    /**
     * 
     * @return
     */
    public String getYear() {

        return year;
    }

    /**
     * 
     * @param field
     */
    public void setYear(String year) {

        this.year = year;
    }
}
