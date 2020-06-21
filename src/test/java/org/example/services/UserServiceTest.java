package org.example.services;

import javafx.application.Application;
import org.apache.commons.io.FileUtils;
import org.example.exceptions.UsernameAlreadyExistsException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class UserServiceTest {

    @BeforeClass
    public static void setupClass() {
        FileSystemService.APPLICATION_FOLDER = "FTEST";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }

    @Before
    public void setUp() throws IOException {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
    }

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        UserService.loadUsersFromFile();
        assertTrue(Files.exists(UserService.USERS_PATH));
    }

/*@Test
public void testLoadUsersFromFile() throws Exception {
    UserService.loadUsersFromFile();
    assertNotNull(UserService.users);
    Assert.assertEquals(75, UserService.users.size());
}
@Test
public void testAddOneUser() throws Exception {
    UserService.loadUsersFromFile();
    UserService.addUser("rt40", "rt40", "400");
    assertNotNull(UserService.users);
    assertEquals(76, UserService.users.size());
}
@Test
public void testAddTwoUsers() throws Exception {
    UserService.loadUsersFromFile();
    UserService.addUser("rt41", "rt41", "401");
    UserService.addUser("rt42", "rt42", "402");
    assertNotNull(UserService.users);
    assertEquals(78, UserService.users.size());
}*/

    @Test(expected = UsernameAlreadyExistsException.class)
    public void testAddUserAlreadyExists() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("rt41", "rt41", "401");
        assertNotNull(UserService.users);
        UserService.checkUserDoesNotAlreadyExist("rt41");
    }

/*@Test
public void testAddOneUserIsPersisted() throws Exception {
    UserService.loadUsersFromFile();
    UserService.addUser("rt40", "rt40", "400");
    List<User> users = new ObjectMapper().readValue(UserService.USERS_PATH.toFile(), new TypeReference<List<User>>() {
    });
    assertNotNull(users);
    assertEquals(75, users.size());
}*/


}