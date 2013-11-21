package users;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class User {

    private String name;
    private String forname;

    /**
     * 
     * @param name
     * @param forname
     */
    public User(String name, String forname) {

        this.name = name;
        this.forname = forname;
    }

    /**
     * 
     * @return
     */
    public String getName() {

        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * 
     * @return
     */
    public String getForname() {

        return forname;
    }

    /**
     * 
     * @param forname
     */
    public void setForname(String forname) {

        this.forname = forname;
    }
}
