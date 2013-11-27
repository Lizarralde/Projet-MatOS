package data;

import java.util.ArrayList;
import java.util.List;

import objects.Material;
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

		return users;
	}

	public static List<Material> loadMaterialList() {
		List<Material> mat = new ArrayList<Material>();
		mat.add(new Phone("HTC One", "this is an htc one.", "android"));
		return mat;
	}
}
