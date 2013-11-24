package data;

import java.util.ArrayList;
import java.util.List;

import users.Student;
import users.User;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Data {

    public static List<User> loadUsersList() {

        List<User> users = new ArrayList<User>();

        users.add(new Student("LIZARRALDE", "Dorian", "SI3 - 2013"));

        return users;
    }
}
