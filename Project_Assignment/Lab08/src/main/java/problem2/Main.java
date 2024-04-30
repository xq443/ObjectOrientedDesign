package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import problem3.Swimmer;

public class Main {
  public static void main(String[] args) {
    List<Swimmer> swimmers = new ArrayList<>();
    Swimmer a = new Swimmer("Cathy Qin", Arrays.asList(28.5, 20.2),
        Arrays.asList(27.6, 28.3, 28.5), Arrays.asList(28.5, 29.7, 30.1, 30.2, 28.5),
        Arrays.asList(27.6, 28.5, 29.1, 28.5));

    Swimmer b = new Swimmer("Cathrine Qin", Arrays.asList(28.5, 27.4, 29.1, 28.7, 29.9),
        Arrays.asList(27.6, 28.3, 28.5), Arrays.asList(28.5, 29.7, 30.1, 30.2, 28.5),
        Arrays.asList(21.6, 21.5, 21.1, 21.5));

    swimmers.add(a);
    swimmers.add(b);

    int comparisonResult = a.compareTo(b);
    if (comparisonResult < 0) { // a < b
      System.out.println(a.getName() + " average freestyle swimming time is better that " + b.getName());
    } else if (comparisonResult > 0) {
      System.out.println(b.getName() + " average freestyle swimming 50m time is better that " + a.getName());
    } else {
      System.out.println(a.getName() + " and " + b.getName() + "  average freestyle swimming are equal");
    }
  }

}
