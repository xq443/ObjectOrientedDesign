import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    private Name testName;
    private String expectedFirstName;
    private String expectedLastName;

    @BeforeEach
    void setUp() {
        testName = new Name("Cathy", "Qin");
        expectedFirstName = "Cathy";
        expectedLastName = "Qin";
    }

    @Test
    void getFirstName() {

        assertEquals(expectedFirstName, testName.getFirstName());
    }

    @Test
    void getLastName() {

        assertEquals(expectedLastName, testName.getLastName());
    }

    @Test
    void testToString() {
        String expectedRet = "Name{" +
                "firstName='" + "Cathy" + '\'' +
                ", lastName='" + "Qin" + '\'' +
                '}';
        assertEquals(expectedRet, testName.toString());
    }
}