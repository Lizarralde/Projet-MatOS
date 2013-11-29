package ui;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Parser {

	private Scanner	reader;

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

	public GregorianCalendar getADate() {
		String reponse = this.getInput().get(0);
		int year = Integer.parseInt(reponse.substring(6, reponse.length()));
		int month = Integer.parseInt(reponse.substring(3, 4));
		int day = Integer.parseInt(reponse.substring(0, 1));
		GregorianCalendar laDate = new GregorianCalendar(year, month, day);
		GregorianCalendar today = new GregorianCalendar();
		if (day < 1 || day > 31 || month < 10 || month > 12 || year < 0
				|| (laDate.compareTo(today) < 0)) {
			System.out.println("Date incorrect");
			return null;
		}
		return laDate;
	}
}
