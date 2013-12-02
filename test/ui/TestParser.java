package ui;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class TestParser {

    static Parser parser = new Parser();

    @BeforeClass
    public static void setReader() {

        try {

            parser.setReader(new FileInputStream("TEST_PARSER"));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        
        System.out.close();
    }

    @Test
    public void testGetInput() {

        List<String> words = parser.getInput();
        
        assertNotNull(words);
        assertTrue(words.isEmpty());
        
        words = parser.getInput();
        
        assertTrue(words.size() == 2);
        
        assertEquals("LIZARRALDE", words.get(0));
        assertEquals("Dorian", words.get(1));
    }
    
    @Test
    public void testGetADate() {
        
        GregorianCalendar calendar = parser.getADate();
        
        assertNull(calendar);
        
        calendar = parser.getADate();
        
        assertNull(calendar);
        
        calendar = parser.getADate();
        
        assertEquals(2013, calendar.get(GregorianCalendar.YEAR));
        assertEquals(11, calendar.get(GregorianCalendar.MONTH));
        assertEquals(29, calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
