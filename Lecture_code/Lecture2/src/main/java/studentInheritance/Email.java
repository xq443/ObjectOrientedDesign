package studentInheritance;

public class Email {

  private String username;
  private String domain;

  public Email(String username, String domain) {
    this.username = username;
    this.domain = domain;
  }

  public String getUsername() {
    return username;
  }

  public String getDomain() {
    return domain;
  }

  @Override
  public String toString() {
    return "Email{" +
        "username='" + username + '\'' +
        ", domain='" + domain + '\'' +
        '}';
  }
}
