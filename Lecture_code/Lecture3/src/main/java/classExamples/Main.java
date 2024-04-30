package classExamples;

public class Main {

    private String hello;
    private static final String CONS_STRING = "I am a constant";

    public static void main(String[] args) {
        System.out.println(CONS_STRING);
        //System.out.println(this.hello); //This will not compile because static methods only
        // work with static elements of a class

        System.out.println(Math.round(2.3));

    }
}
