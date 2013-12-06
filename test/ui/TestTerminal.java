package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.BeforeClass;

/**
 * Test the Terminal Class
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class TestTerminal {

    static Terminal terminal;

    @BeforeClass
    public static void setReader() {

        terminal = new Terminal();

        try {

            terminal.getParser().setReader(
                    new FileInputStream("./data/TEST_TERMINAL.txt"));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
    
    @Test
    
}
