package data;

import java.util.ArrayList;
import java.util.List;

import objects.MaterialQuantity;
import objects.Phone;
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
		users.add(new Student("test", "test", "SI3 - 2013"));

		return users;
	}

	public static List<MaterialQuantity> loadMaterialList() {
		List<MaterialQuantity> mat = new ArrayList<MaterialQuantity>();
		mat.add(new MaterialQuantity(new Phone("HTC One",
				"this is an htc one.", "android"), 5));
		return mat;
	}
}
