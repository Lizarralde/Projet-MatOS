package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import objects.Camera;
import objects.Casque;
import objects.MaterialQuantity;
import objects.Phone;
import objects.Tablet;
import objects.TypeOS;
import users.Student;
import users.Teacher;
import users.User;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Data {

    public static List<User> loadUsersList() {

        XStream xstream = new XStream(new DomDriver());

        List<User> users = null;

        try {

            FileInputStream in = new FileInputStream("USERS_LIST.xml");

            users = (ArrayList<User>) xstream.fromXML(in);

            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return users;
    }

    public static void storeUserList() {

        List<User> users = new ArrayList<User>();

        users.add(new Student("LIZARRALDE", "Dorian", "SI3 - 2013"));
        users.add(new Student("PINEL", "Fabien", "SI3 - 2013"));
        users.add(new Student("SIMOND", "Hugo", "SI3 - 2013"));
        users.add(new Student("BENNI", "Benjamin", "SI3 - 2013"));
        users.add(new Student("SALMERON", "Quentin", "SI3 - 2013"));
        users.add(new Student("LECA", "Pierre", "SI3 - 2013"));
        users.add(new Teacher("SARMIENTO", "Sergio", "Communication"));

        XStream xstream = new XStream(new DomDriver());

        try {

            FileOutputStream out = new FileOutputStream("USERS_LIST.xml");

            xstream.toXML(users, out);

            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static List<MaterialQuantity> loadMaterialList() {

        XStream xstream = new XStream(new DomDriver());

        List<MaterialQuantity> materials = null;

        try {

            FileInputStream in = new FileInputStream("MATERIALS_LIST.xml");

            materials = (ArrayList<MaterialQuantity>) xstream.fromXML(in);

            in.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return materials;
    }

    public static void storeMaterialList() {

        List<MaterialQuantity> materials = new ArrayList<MaterialQuantity>();

        materials.add(new MaterialQuantity(new Phone("HTC One",
                "Description of the HTC One", TypeOS.ANDROID), 5));
        materials.add(new MaterialQuantity(new Casque("Dr Dre",
                "Description of the Dr Dre", 1, 3), 24));
        materials.add(new MaterialQuantity(new Camera("Nokia 850",
                "Description of the Nokia 850", 1, 2), 2));
        materials.add(new MaterialQuantity(new Tablet("iPad",
                "Description of the HTC One", TypeOS.IOS), 5));

        XStream xstream = new XStream(new DomDriver());

        try {

            FileOutputStream out = new FileOutputStream("MATERIALS_LIST.xml");

            xstream.toXML(materials, out);

            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        storeUserList();
        storeMaterialList();
    }
}
