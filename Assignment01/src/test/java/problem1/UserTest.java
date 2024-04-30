package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    private User testUser;
    private String expectedFirstName1;
    private String expectedLastName1;
    private String expectedPhoneNumber1;
    private String expectedEmailAddress1;

    private Credentials expectedCredentials1;

    private String expectedUsername1;
    private String expectedPasswordHash1;

    private String invalidPhoneNumber;


    @BeforeEach
    void setUp() {
        expectedFirstName1 = "Cathy";
        expectedLastName1 = "Qin";
        expectedEmailAddress1 = "xq443@nyu.edu";
        expectedPhoneNumber1 = "2001020211";
        expectedUsername1 = "cathyqin";
        expectedPasswordHash1 = "123456";
        expectedCredentials1 = new Credentials(expectedUsername1, expectedPasswordHash1);
        testUser = new User("Cathy", "Qin", "2001020211", "xq443@nyu.edu",
                new Credentials("cathyqin","123456"));
        Credentials testCredentials = new Credentials("cathyqin", "123456");
    }

    @Test
    void getFirstName() {
        assertEquals(expectedFirstName1, testUser.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals(expectedLastName1, testUser.getLastName());
    }

    @Test
    void getPhoneNumber() {

        assertEquals(expectedPhoneNumber1, testUser.getPhoneNumber());

        invalidPhoneNumber = "1002";
        try {
            new User(expectedFirstName1, expectedLastName1, invalidPhoneNumber, expectedEmailAddress1, expectedCredentials1);
        } catch (IllegalArgumentException exception) {
            assertEquals("Phone Number does not consist of ten characters", exception.getMessage());
        }
    }

    @Test
    void getEmailAddress() {
        assertEquals(expectedEmailAddress1, testUser.getEmailAddress());
    }

    @Test
    void getCredentials() {
        assertEquals(expectedCredentials1, testUser.getCredentials());
    }

    @Test
    void testEquals_SameObjects() {
        assertTrue(testUser.equals(testUser));
    }
    @Test
    void testEquals_NullComparison(){
        assertFalse(testUser.equals(null));
    }

    @Test
    void testEquals_DifferentDataType(){
        assertFalse(testUser.equals("String"));
    }

    @Test
    void testEquals_DifferentObjectDifferentFirstName(){
        User otherUser = new User("peter", expectedLastName1, expectedPhoneNumber1, expectedEmailAddress1, expectedCredentials1);
        assertFalse(testUser.equals(otherUser));
    }
    @Test
    void testEquals_DifferentObjectDifferentLastName() {
        User otherUser = new User(expectedFirstName1, "Doe", expectedPhoneNumber1, expectedEmailAddress1, expectedCredentials1);
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    void testEquals_DifferentObjectDifferentPhoneNumber() {
        User otherUser = new User(expectedFirstName1, expectedLastName1, "1010101010", expectedEmailAddress1, expectedCredentials1);
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    void testEquals_DifferentObjectDifferentEmailAddress() {
        User otherUser = new User(expectedFirstName1, expectedLastName1, expectedPhoneNumber1, "111@gmail.com", expectedCredentials1);
        assertFalse(testUser.equals(otherUser));
    }

    @Test
    void testEquals_DifferentObjectDifferentCredentials() {
        Credentials otherCredentials = new Credentials("username1", "password1");
        User otherUser = new User(expectedFirstName1, expectedLastName1, expectedPhoneNumber1, expectedEmailAddress1, otherCredentials);
        assertFalse(testUser.equals(otherUser));
    }
    @Test
    void testEquals_DifferentObjectSameFields() {
        User otherUser = new User(expectedFirstName1, expectedLastName1, expectedPhoneNumber1, expectedEmailAddress1, expectedCredentials1);
        assertTrue(testUser.equals(otherUser));
    }
    @Test
    void testHashCode() {
        int expHashCode = Objects.hash(expectedFirstName1, expectedLastName1, expectedPhoneNumber1, expectedEmailAddress1, expectedCredentials1);
        assertEquals(expHashCode, testUser.hashCode());
    }
}
