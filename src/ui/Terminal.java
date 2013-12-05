package ui;

import java.util.GregorianCalendar;
import java.util.List;

import management.Reservation;
import management.Stock;
import objects.MaterialQuantity;
import users.Manager;
import users.User;

/**
 * Headquarter of the application. Identifie the user. Retrieve his reservation.
 * Make it
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

	private Parser	parser;

	private User	user;

	private Stock	stock;

	private Manager	manager;

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

		manager = new Manager(stock);

		welcome();

		if (getUser(users)) {

			System.out.println("You are now identified as " + user.getName()
					+ " " + user.getForname());
			theApplication();
		} else {

			System.out.println("Sorry, we were unable to find you.");
			this.start(users, mat);
			// System.out.println("The application will close.");
		}
	}

	public void theApplication() {
		System.out
				.println("Type your command. If you need help, you can use the command 'help'");

		while (!processCommand(parser.getInput())) {

		}

		System.out.println("Thank you for using our application. Good bye.");
	}

	/**
     * 
     */
	private void welcome() {

		System.out.println("Welcome to our reservation application.");
		System.out
				.println("What is your ID ? Type your name followed by your forname.");
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

		System.out.println("You can use our application to reserve an object.");
		System.out.println("Your command words are : reserve, help, quit");
	}

	public int chooseAnObject() {
		// Display the list
		System.out.println("Please write the number of the object you want: ");
		System.out.println("" + stock.toString());

		int rep = Integer.parseInt(parser.getInput().get(0));
		if (rep < 0 || rep > stock.getMaterialStock().size() - 1) {
			// response incorrect
			System.out.println("Incorrect. This number isn't correct.");
			this.chooseAnObject();
		}
		return rep;
	}

	public int enterAQuantity(int quantityAvailable) {
		int quant;
		System.out.println("Enter the quantity you want :");
		quant = Integer.parseInt(parser.getInput().get(0));
		if (quant < 0 || quant > quantityAvailable) {
			System.out.println("Incorrect. Please enter a correct number. ");
			// incorrect
			this.enterAQuantity(quantityAvailable);
		}
		return quant;
	}

	/**
	 * Ask for a begin date for the emprunt
	 * 
	 * @return
	 */
	public GregorianCalendar askABeginDate() {
		System.out
				.println("Enter the first day you want to have it : (dd/mm/yyyy)");
		return parser.getADate();
	}

	/**
	 * Ask for an end date of the emprunt
	 * 
	 * @return
	 */
	public GregorianCalendar askAnEndDate() {
		System.out
				.println("Enter the last day you want to have it : (dd/mm/yyyy)");
		return parser.getADate();
	}

	public boolean checkTheDates(GregorianCalendar date1,
			GregorianCalendar date2) {
		/*
		 * En implémentant un GregorianCalendar il est initialisé à la date
		 * courante
		 */
		GregorianCalendar dateDuJour = new GregorianCalendar();
		if (date1.compareTo(dateDuJour) < 0 || date2.compareTo(dateDuJour) < 0) {
			System.out
					.println("Une des 2 dates se situe avant la date courante. Ce qui pose problème.");
			return false;
		}
		if (date1.compareTo(date2) > 0) {
			System.out.println("La date de début est après la date de fin.");
			return false;
		}
		return true;
	}

	/**
     * 
     */
	private boolean reserve() {
		int reponse;
		GregorianCalendar date1 = null;
		GregorianCalendar date2 = null;
		int quantity;
		boolean dateOk = false;
		List<MaterialQuantity> mat = stock.getMaterialStock();

		// Load the materials from the stock
		reponse = this.chooseAnObject();
		quantity = this.enterAQuantity(mat.get(reponse).getQuantity());
		while (!dateOk) {
			date1 = askABeginDate();
			date2 = askAnEndDate();
			dateOk = this.checkTheDates(date1, date2);
		}

		if (manager.isAvailable(mat.get(reponse), quantity, date1, date2)) {
			System.out.println("L'objet est disponible.");
			MaterialQuantity monObjetAReserver = new MaterialQuantity(mat.get(
					reponse).getMat(), quantity);
			Reservation res = manager.doReserve(user, monObjetAReserver, date1,
					date2);
			if (res == null) {
				System.out.println("La réservation a échouée.");
				return false;
			} else {
				stock.getReservList().add(res);
				System.out
						.println("Reservation effectuée.\nAffichage de la reservation :\n"
								+ res.toString());
				return true;

			}
			// faire la réservation (ajout à la liste des reservation
		} else {
			System.out
					.println("L'objet demandé n'est malheureusement pas disponible.");
			return false;
			// indisponible -- retour au prompt
		}
	}
}
