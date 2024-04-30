package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CredentialsTest {
    private Credentials testCredentials;
    private String expectedUsername;
    private String expectedPasswordhash;


    @BeforeEach
    void setUp() {
        testCredentials = new Credentials("cathyqin", "123456");
        expectedUsername = "cathyqin";
        expectedPasswordhash = "123456";
    }

    @Test
    void getUsername() {
        assertEquals(expectedUsername, testCredentials.getUsername());
    }

    @Test
    void getPasswordHash() {
        assertEquals(expectedPasswordhash, testCredentials.getPasswordHash());
    }


    @Test
    void testEquals_SameObjects() {
        assertTrue(testCredentials.equals(testCredentials));
    }
    @Test
    void testEquals_NullComparison(){
        assertFalse(testCredentials.equals(null));
    }

    @Test
    void testEquals_DifferentDataType(){
        assertFalse(testCredentials.equals("String"));
    }

    @Test
    void testEquals_DifferentObjectDifferentPassword(){
        Credentials otherCredentials = new Credentials(expectedUsername, "000");
        assertFalse(testCredentials.equals(otherCredentials));
    }
    @Test
    void testEquals_DifferentObjectDifferentUserName(){
        Credentials otherCredentials = new Credentials("maria", expectedPasswordhash);
        assertFalse(testCredentials.equals(otherCredentials));
    }
    @Test
    void testEquals_DifferentObjectSameFields(){
        Credentials otherCredentials = new Credentials(expectedUsername, expectedPasswordhash);
        assertTrue(testCredentials.equals(otherCredentials));
    }

    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash(expectedUsername, expectedPasswordhash);
        assertEquals(expectedHashCode, testCredentials.hashCode());
    }
}