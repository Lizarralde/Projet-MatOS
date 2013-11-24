package ui;

import java.util.List;

import users.User;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Terminal {

    private Parser parser;
    private User user;

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

    }
}
