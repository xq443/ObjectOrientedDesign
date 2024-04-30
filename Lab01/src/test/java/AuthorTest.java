import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AuthorTest {
    private Author expectedAuthor;
    private Name expectedName;
    private Email expectedEmail;
    private Address expectedAddress;
    private Author testAuthor;


    @BeforeEach
    void setUp() {
        // Initialize test data
        expectedName = new Name("Cathy", "Qin");
        expectedEmail = new Email("cathy.qin", "example.com");
        expectedAddress = new Address("225 Terry Ave", "Seattle", "County", "98109", "WA");
        // Create an Author instance for testing
        expectedAuthor = new Author(expectedName, expectedEmail, expectedAddress);
        testAuthor = new Author(new Name("Cathy", "Qin"), new Email("cathy.qin", "example.com"), new Address("225 Terry Ave", "Seattle", "County", "98109", "WA"));

    }

    @Test
    void getName() {
        assertEquals(expectedName.getFirstName(), testAuthor.getName().getFirstName());
        assertEquals(expectedName.getLastName(), testAuthor.getName().getLastName());
    }

    @Test
    void getEmail() {
        assertEquals(expectedEmail.getUser(), testAuthor.getEmail().getUser());
        assertEquals(expectedEmail.getDomain(), testAuthor.getEmail().getDomain());
    }

    @Test
    void getAddress() {
        assertEquals(expectedAddress.getStreet(), testAuthor.getAddress().getStreet());
        assertEquals(expectedAddress.getCity(), testAuthor.getAddress().getCity());
        assertEquals(expectedAddress.getCounty(), testAuthor.getAddress().getCounty());
        assertEquals(expectedAddress.getState(), testAuthor.getAddress().getState());
        assertEquals(expectedAddress.getZipcode(), testAuthor.getAddress().getZipcode());
    }

    @Test
    void testToString() {
        assertEquals(expectedAuthor.toString(), testAuthor.toString());
    }

    @Test
    void testEquals() {
        // Test not equal objects
        assertNotEquals(expectedAuthor, testAuthor);

        // Test not equal objects
        Author differentAuthor = new Author(new Name("John", "Doe"), new Email("john.doe", "example.com"), new Address("123 Main St", "City", "County", "12345", "CA"));
        assertNotEquals(expectedAuthor, differentAuthor);
    }

    @Test
    void testHashCode() {
        // Test not equal hash codes for equal objects
        assertNotEquals(expectedAuthor.hashCode(), testAuthor.hashCode());

        // Test not equal hash codes for not equal objects
        Author differentAuthor = new Author(new Name("John", "Doe"), new Email("john.doe", "example.com"), new Address("123 Main St", "City", "County", "12345", "CA"));
        assertNotEquals(expectedAuthor.hashCode(), differentAuthor.hashCode());
    }
}