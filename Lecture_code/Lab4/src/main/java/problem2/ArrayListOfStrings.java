package problem2;

public class ArrayListOfStrings implements ListOfStrings{
    private static final int NUM_SLOTS = 10;
    private String[] items;
    private int size;

    /**
     * Constructor for a ListOfStrings.
     */
    public ArrayListOfStrings() {
        this.items = new String[NUM_SLOTS];
        this.size = 0;
    }

    /**
     * Creates an empty list.
     * @return An empty list.
     */
    public static ListOfStrings createEmpty() {
        return new ArrayListOfStrings();
    }


    @Override
    public Boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Integer size() {
        return this.size;
    }

    /**
     * Add an item to the list.
     *
     * @param item The item to add.
     */
    public void add(String item) {
        if (!this.inSizeRange())
            this.resize();
        this.items[this.size] = item;
        this.size++;
    }

    /**
     * Helper function that checks if there is room in the items array to add a new item to the list.
     *
     * @return true if there is space available, false otherwise
     */
    private boolean inSizeRange() {

        return (this.size + 1 <= this.items.length);
    }

    /**
     * Increase the size of the data array. This involves creating a temporary new array, adding the
     * existing data to the new array, then setting the data array to the new array.
     */
    private void resize() {
        int newSize = this.size + NUM_SLOTS;
        String[] newItems = new String[newSize];
        this.copyItems(this.items, newItems);
        this.items = newItems;
    }

    /**
     * Helper function used by add and insert methods. Copies the items from one array to another.
     * @param from The array to copy from.
     * @param to The array to copy to.
     * @param fromStart The index in the "from" array to start copying from.
     * @param fromEnd The index in the "from" array to end at (exclusive).
     * @param toStart The index in the "to" array to start copying to.
     */
    private void copyItems(String[] from, String[] to, int fromStart,
                           int fromEnd, int toStart) {
        if (toStart >= 0) {
            for (int i = fromStart; i < fromEnd; i++) {
                to[toStart] = from[i];
                toStart++;
            }
        }
    }

    /**
     * Shortcut version of the helper method above. Will copy the entirety of the "from" array to the "to" array.
     * @param from The array to copy from.
     * @param to The array to copy to.
     */
    private void copyItems(String[] from, String[] to) {

        this.copyItems(from, to, 0, from.length, 0);
    }

    @Override
    public Boolean contains(String elem) {
        for (int i = 0; i < this.items.length; i++){
            if(this.items[i].equals(elem))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean containsAll(ListOfStrings sublist) {
        return null;
    }

    @Override
    public ListOfStrings filterLargerThan(Integer cuttoffSize) {
        ArrayListOfStrings resultingList = new ArrayListOfStrings();
        for (int i = 0; i < this.items.length; i++){
            if(this.items[i].length() >= cuttoffSize)
                resultingList.add(this.items[i]);
        }
        return resultingList;
    }

    @Override
    public Boolean hasDuplicates() {
        return null;
    }

    @Override
    public ListOfStrings removeDuplicates() {
        return null;
    }
}
