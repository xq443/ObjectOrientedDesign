package functional_programming.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StartingStreams {

    public static void main(String[] args){

        int total = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Total sum of ints 1-10:" + total);

        int total2 = IntStream.rangeClosed(1, 10).map(x -> x*2).sum();
        System.out.println("Total sum of even numbers 0-20, map:" + total2);

        int total3 = IntStream.rangeClosed(0, 20).filter(x -> x%2==0).sum();
        System.out.println("Total sum of even numbers 0-20, filter:" + total3);

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.2);
        doubles.add(-2.3);
        doubles.add(4.5);
        doubles.add(1.0);

       long count = doubles.stream().count();
       System.out.println(count);

       doubles.add(1.0);
       doubles.add(4.5);
       doubles.add(4.5);
       System.out.println(doubles);

       List<Double> noDuplicatesList = doubles.stream().distinct().collect(Collectors.toList());
       System.out.println("No duplicates" + noDuplicatesList);

       String noDuplicatesString = (String) doubles.stream().distinct()
                                                    .map(x -> x.toString()).collect(Collectors.joining("|"));
        System.out.println(noDuplicatesString);

       Stream<String> myStream= Stream.of("Some", "what", "small", "example");
       String result = myStream.collect(Collectors.joining("-"));
       System.out.println(result);



    }


}
