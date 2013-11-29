package ui;

import java.util.GregorianCalendar;
import java.util.List;

import management.Stock;
import objects.MaterialQuantity;
import users.User;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

	private Parser	parser;
	private User	user;
	private Stock	stock;

	/**
     * 
     */
	public Terminal() {

		parser = new Parser();
	}

	/**
     * 
     */
	public void start(List<User> users, List<MaterialQuantity> mat) {
		stock = new Stock(mat);
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
		int quantity;
		List<MaterialQuantity> mat = stock.getMaterialStock();
		// Load the materials from the stock

		// Display the list
		System.out
				.println("Saisissez le numéro de l'objet que vous voulez emprunter.");
		for (int i = 0; i < mat.size(); i++) {
			System.out.println(i + ". " + mat.get(i).getMat().getName() + " ("
					+ mat.get(i).getMat().getDescription() + ") - "
					+ mat.get(i).getQuantity());
			i++;
		}
		reponse = parser.getInput().get(0);
		if (Integer.parseInt(reponse) < 0
				|| Integer.parseInt(reponse) > mat.size()) {
			// response incorrect, exception ??
			System.out.println("Incorrect. This number isn't correct.");
		}
		System.out.println("Enter the quantity you want :");
		quantity = Integer.parseInt(parser.getInput().get(0));
		if (quantity < 0
				|| quantity > mat.get(Integer.parseInt(reponse)).getQuantity()) {
			System.out.println("Incorrect");
			// incorrect, exception ?
		}

		System.out
				.println("Enter the first day you want to have it : (dd/mm/yyyy)");
		date1 = parser.getADate();
		System.out
				.println("Enter the last day you want to have it : (dd/mm/yyyy)");
		date2 = parser.getADate();
		if (date1.compareTo(date2) > 0) {
			System.out
					.println("La date de début est après la date de fin.\nInversion des 2.");
			GregorianCalendar date = date1;
			date1 = date2;
			date2 = date;
		}
		if (stock.isAvailable(mat.get(Integer.parseInt(reponse)), quantity,
				date1, date2)) {
			System.out.println("L'objet est disponible.");
			// faire la réservation (ajout à la liste des reservation
		} else {
			System.out
					.println("L'objet demandé n'est malheureusement pas disponible.");
			// indisponible -- retour au prompt
		}
	}
}
