public class HelloWorld {

  private String greeting;

  public HelloWorld(String greeting) {
    this.greeting = greeting;
  }

  public String getGreeting() {
    return greeting;
  }

  public static void main(String[] args){
    HelloWorld myGreeting = new HelloWorld("Hello, thanks for listening!");
    System.out.println(myGreeting.getGreeting());
  }
}
