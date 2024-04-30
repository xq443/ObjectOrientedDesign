package inheritanceWithPrivateFields;

import java.util.Objects;

public class Client extends Person {
  private String clientID;

  public Client(String firstName, String lastName, String studentID) {
    super(firstName, lastName);
    this.clientID = studentID;
  }

  public String getClientID() {
    return clientID;
  }

  @Override
  public void printName(){
    System.out.println(this.getFirstName() + " " + super.getLastName() + "; " + this.clientID);
  }

  public void anotherPrintMethod(){
    super.printName();
    System.out.println(this.clientID);
  }

  public void anotherPrintMethod2(){
    this.printName();
    System.out.println(this.clientID);
  }

  public void printStuff(){
    System.out.println(this.getFirstName());
    System.out.println(super.getFirstName());
    System.out.println(super.getLastName());

    //public void printStuff(){
    //  System.out.println(this.firstName);
    //  System.out.println(super.firstName);
    //}

  }

  @Override
  public void printToConsole(){
    System.out.println(this.getFirstName() + super.getFirstName() + this.getLastName());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(clientID, client.clientID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), clientID);
  }
}
