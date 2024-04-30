package iterating;

public class FibMain {
    public static void main(String[] args) {
        FibIterator startingSequence = new FibIterator();
        for (int i = 0; i <= 4; i++) {
            System.out.println(startingSequence.next());
        }
        FibIterator correctOne = new FibIterator(13, 21);
        for (int i = 0; i <= 4; i++) {
            System.out.println(correctOne.next());
        }
        FibIterator incorrectOne = new FibIterator(12, 13);
        for (int i = 0; i <= 4; i++) {
            System.out.println(incorrectOne.next());
        }
    }
}
