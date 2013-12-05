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
 * Make it happened or not depend on the manager verification.
 * 
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

    private Parser parser;

    private User user;

    private Stock stock;

    private Manager manager;

    /**
     * Default constructor.
     * 
     * @author Dorian LIZARRALDE
     */
    public Terminal() {

        parser = new Parser();
    }

    /**
     * Start the application. The user has to identifie himself to make a
     * reservation.
     * 
     * @author Dorian LIZARRALDE
     */
    public void start(List<User> users, List<MaterialQuantity> mat) {

        // Keep the default stock for futur use.
        stock = new Stock(mat);

        // Create a manager who will certificate the reservations.
        manager = new Manager(stock);

        // Welcome
        welcome();

        // Wait for the user to identifie himself.
        while (!getUser(users)) {

            System.out.println("Sorry, we were unable to find you.");
        }

        // The user is now identified.
        System.out.println("You are now identified as " + user.toString());

        // The user can make a reservation.
        theApplication();
    }

    /**
     * 
     * @author fabien Pinel
     */
    public void theApplication() {
        System.out
                .println("Type your command. If you need help, you can use the command 'help'");

        while (!processCommand(parser.getInput())) {

        }

        System.out.println("Thank you for using our application. Good bye.");
    }

    /**
     * Display a welcome text and ask for the user to identifie himself.
     * 
     * @author Dorian LIZARRALDE
     */
    public void welcome() {

        System.out.println("Welcome to our reservation application.");

        System.out
                .println("What is your ID ? Type your name followed by your forname.");
    }

    /**
     * Get the ID of the user and try to find him on the users list. If the ID
     * is on this list, the user is now identified.
     * 
     * @author Dorian LIZARRALDE
     * @param users
     * @return
     */
    public boolean getUser(List<User> users) {

        // Get the ID of the user.
        List<String> words = parser.getInput();

        // The user has to give his name and forname.
        if (words.size() > 1) {

            // Try to find him on the users list.
            for (User user : users) {

                if (user.getName().equalsIgnoreCase(words.get(0))
                        && user.getForname().equalsIgnoreCase(words.get(1))) {

                    // The user has been found.
                    this.user = user;

                    return true;
                }
            }
        }

        // The user has not been found.
        return false;
    }

    /**
     * Execute the command associate the user input.
     * 
     * @author Dorian LIZARRALDE
     * @param words
     * @return
     */
    public boolean processCommand(List<String> words) {

        boolean wantToQuit = false;

        // The user has actually typed something.
        if (!words.isEmpty()) {

            switch (words.get(0)) {

            // The user want to reserve something.
            case "reserve":
                reserve();
                break;

            // The user want to display the help.
            case "help":
                help();
                break;

            // The user want to quit.
            case "quit":
                wantToQuit = true;
                break;
            }
        }

        return wantToQuit;
    }

    /**
     * Display an help text.
     * 
     * @author Dorian LIZARRALDE
     */
    public void help() {

        System.out
                .println("You can use our application to reserve a material.");

        System.out.println("Your command words are : reserve, help, quit");
    }

    /**
     * THis method ask the user to choose an object in the list and is played
     * again and again until the choice is Okay
     * 
     * @author Fabien Pinel
     * @return
     */
    public int chooseAnObject() {
        // Display the list
        System.out.println("Please write the number of the object you want: ");
        System.out.println(stock.toString());

        int rep = Integer.parseInt(parser.getInput().get(0));
        if (rep < 0 || rep > stock.getMaterialStock().size() - 1) {
            // response incorrect
            System.out.println("Incorrect. This number isn't correct.");
            this.chooseAnObject();
        }
        return rep;
    }

    /**
     * Ask for a quantity and play the method until the quantity is okay
     * 
     * @author Fabien Pinel
     * @param quantityAvailable
     * @return
     */
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
     * Ask for a date.
     * 
     * @author Fabien Pinel & Dorian LIZARRALDE
     * @return the date entered by the user
     */
    public GregorianCalendar askADate(String whichOne) {

        System.out.println(whichOne);

        return parser.getADate();
    }

    /**
     * Check if the dates given are okay
     * 
     * @author Fabien Pinel
     * @param date1
     * @param date2
     * @return
     */
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
     * Propose to the user to do a reservation.
     * 
     * @author fabien Pinel
     */
    public boolean reserve() {
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
            date1 = askADate("Enter the first day you want to have it : (dd/mm/yyyy)");
            date2 = askADate("Enter the last day you want to have it : (dd/mm/yyyy)");
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
            // faire la réservation (ajout à la liste des reservation)
        } else {
            System.out
                    .println("L'objet demandé n'est malheureusement pas disponible.");
            return false;
            // indisponible -- retour au prompt
        }
    }
}
