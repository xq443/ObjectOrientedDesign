import java.util.Objects;

/**
 * Represents an Author with their details--name, email and physical address *
 * @author CathyQin
 *
 */
public class Author {
    private Name name;
    private Email email;
    private Address address; //"225 Terry Ave N, Suite #103, Seattle, WA,98109"
    /**
     * Creates a new author given the author's name, email and address as strings. *
     * @param name the author's name
     * @param email the author's email address
     * @param address the authors physical address
     */
    public Author(Name name, Email email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
    /**
     * @return the name
     */
    public Name getName() {

        return this.name;
    }
    /**
     * @return the email */
    public Email getEmail() {

        return this.email;
    }
    /**
     * @return the address */
    public Address getAddress() {

        return this.address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name=" + name +
                ", email=" + email +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(email, author.email) && Objects.equals(address, author.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, address);
    }
}