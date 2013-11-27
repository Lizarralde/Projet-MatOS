package ui;

import java.util.GregorianCalendar;
import java.util.List;

import management.Stock;
import objects.Material;
import users.User;
import data.Data;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

	private Parser			parser;
	private User			user;
	private Stock			stock;
	private List<Material>	mat;

	/**
     * 
     */
	public Terminal() {

		parser = new Parser();
	}

	/**
     * 
     */
	public void start(List<User> users) {

		welcome();

		if (getUser(users)) {

			System.out.println("You are now identified as " + user.getName()
					+ " " + user.getForname());

			while (!processCommand(parser.getInput())) {

			}

			System.out
					.println("Thank you for using our application. Good bye.");
		} else {

			System.out.println("We were unable to find you.");
			System.out.println("The application will close.");
		}
	}

	/**
     * 
     */
	private void welcome() {

		System.out.println("Welcome to our reservation application");
		System.out.println("Do you have an ID ?");
	}

	/**
	 * 
	 * @param users
	 * @return
	 */
	private boolean getUser(List<User> users) {

		List<String> words = parser.getInput();

		if (words.size() > 1) {

			for (User user : users) {

				if (user.getName().equalsIgnoreCase(words.get(0))
						&& user.getForname().equalsIgnoreCase(words.get(1))) {

					this.user = user;

					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 
	 * @param words
	 * @return
	 */
	private boolean processCommand(List<String> words) {

		boolean wantToQuit = false;

		if (!words.isEmpty()) {

			switch (words.get(0)) {

			case "reserve":
				reserve();
				break;

			case "help":
				help();
				break;

			case "quit":
				wantToQuit = true;
				break;
			}
		}

		return wantToQuit;
	}

	/**
     * 
     */
	private void help() {

		System.out.println("You can use our application to reserv an object.");
		System.out.println("Your command words are : reserve, help, quit");
	}

	/**
     * 
     */
	private void reserve() {
		String reponse;
		GregorianCalendar date1;
		GregorianCalendar date2;
		// Load the materials
		mat = Data.loadMaterialList();
		// Display the list
		System.out
				.println("Saisissez le numéro de l'objet que vous voulez emprunter.");
		for (int i = 0; i < mat.size(); i++) {
			System.out.println(i + ". " + mat.get(i).getName() + " ("
					+ mat.get(i).getDescription() + ")");
		}
		reponse = parser.getInput().get(0);
		if (Integer.parseInt(reponse) < 0
				|| Integer.parseInt(reponse) > mat.size()) {
			// reponse incorrect, exception ??
		}
		System.out
				.println("Enter the first day you want to have it : (dd/mm/yyyy)");
		date1 = parser.getADate();
		System.out
				.println("Enter the last day you want to have it : (dd/mm/yyyy)");
		date2 = parser.getADate();

		if (stock.isAvailable(mat.get(Integer.parseInt(reponse)), date1, date2)) {
			// faire la réservation (ajout à la liste des reservation
		} else {
			// indisponible
		}
	}
}
