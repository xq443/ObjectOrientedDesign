package airlinerbad;

import java.util.Scanner;

public class UserInteractor {

  private String firstName;
  private String lastName;

  public void interact(){
    Scanner userInfo = new Scanner(System.in);
    System.out.println("Hi, please tell me your first name!");

    firstName = userInfo.nextLine();

    if(firstName != null)
      System.out.println("Hi " + firstName + " ! Please tell me your last name.");
    lastName = userInfo.nextLine();
  }

}
