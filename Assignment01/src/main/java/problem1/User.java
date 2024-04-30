/**
 * The User class represents a user entity with basic information and credentials.
 * This class ensures that the user's phone number is of the correct length.
 */
package problem1;

import java.util.Objects;

public class User {
    static final int phoneNumberLength = 10;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private Credentials credentials;

    /**
     * Constructs a new User with the specified information and credentials.
     *
     * @param firstName     The first name of the user.
     * @param lastName      The last name of the user.
     * @param phoneNumber   The phone number of the user (must be of the correct length).
     * @param emailAddress  The email address of the user.
     * @param credentials   The credentials (username and password) of the user.
     *
     * @throws IllegalArgumentException If the phone number does not consist of ten characters.
     */
    public User(String firstName, String lastName, String phoneNumber, String emailAddress,
        Credentials credentials) {
        if (phoneNumber.length() != phoneNumberLength) {
            throw new IllegalArgumentException("Phone Number does not consist of ten characters");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.credentials = credentials;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets the credentials (username and password) of the user.
     *
     * @return The credentials of the user.
     */
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName,
            user.lastName) && Objects.equals(phoneNumber, user.phoneNumber)
            && Objects.equals(emailAddress, user.emailAddress) && Objects.equals(
            credentials, user.credentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, emailAddress, credentials);
    }
}
