package ui;

import java.util.ArrayList;
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
}
