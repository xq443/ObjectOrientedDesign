package functional_programming.lambdas;

/**
 * Created by therapon on 7/6/16.
 */
public interface Function <T,R> {

    /**
     * Apply this funtction to {@code input} and return the result.
     *
     * @param input fucntion's input
     * @return return the result of applying this function to input.
     */
    R apply(T input);

}
