package objects;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public enum TypeOS {

    IOS("iOS"), ANDROID("Android");

    private String name;

    /**
     * Default constructor.
     * 
     * @param s
     */
    TypeOS(String name) {

        this.name = name;
    }

    /**
     * @see Object#toString()
     * 
     */
    public String toString() {

        return name;
    }
}
