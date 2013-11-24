import data.Data;
import ui.Terminal;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Program {

    /**
     * @param args
     */
    public static void main(String[] args) {

        new Terminal().start(Data.loadUsersList());
    }

}
