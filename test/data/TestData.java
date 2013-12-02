package data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import users.User;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class TestData {

    @Test
    public void testLoadUsersList() {

        List<User> users = Data.loadUsersList();

        assertNotNull(users);
    }

    @Test
    public void testLoadMaterialList() {

    }
}
