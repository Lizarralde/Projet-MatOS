package ui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

    private Scanner reader;

    /**
     * 
     */
    public Parser() {

        reader = new Scanner(System.in);
    }

    /**
     * 
     * @param inputStream
     */
    public void setReader(InputStream inputStream) {

        reader = new Scanner(inputStream);
    }

    /**
     * 
     * @return
     */
    public List<String> getInput() {

        List<String> words = new ArrayList<String>();

        String inputLine;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);

        while (tokenizer.hasNext()) {

            words.add(tokenizer.next());
        }

        tokenizer.close();

        return words;
    }

    public GregorianCalendar getADate() {

        List<String> words = getInput();

        if (!words.isEmpty()) {

            String str[] = words.get(0).split("/");

            if (str.length < 3) {

                return null;
            }

            int year = Integer.parseInt(str[2]);

            int month = Integer.parseInt(str[1]);

            int day = Integer.parseInt(str[0]);

            return new GregorianCalendar(year, month - 1, day);
        }

        return null;
    }
}
