package ch.heg.ig.sda.datastructure;

/**
 * @author maximili.jeannere
 * ArrayList containing instances of type E with fixed size.
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements; // Array to store elements
    private int size = 0; // Number of elements

    // Constructors

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor with given capacity.
     *
     * @param capacity Capacity of the array
     */
    public ArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return elements[i];
    }

    @Override
    public E set(int i, E element) {
        checkIndex(i, size);
        E temp = elements[i];
        elements[i] = element;
        return temp;
    }

    @Override
    public void add(int i, E element) {

        // Check index validity
        // An ArrayList stores contiguous elements, this method prevents insertion at too distant index
        this.checkIndex(i, this.size + 1);

        // Check if the array has space left
        this.checkCapacity();

        for (int j = this.size - 1; j >= i; j--) { // Shift elements to the right, starting from the rightmost element.
            this.elements[j + 1] = this.elements[j];
        }

        this.elements[i] = element; // Free space for the new element

        this.size++;

    }

    @Override
    public void add(E element) {
        this.add(size, element);
    }

    @Override
    public E remove(int i) {
        checkIndex(i, size);

        E temp = elements[i];

        for (int j = i; j < size - 1; j++) { // Shift elements to the left to fill the gap
            elements[j] = elements[j + 1];
        }

        elements[this.size - 1] = null; // candidate for garbage collector
        this.size--;

        return temp;
    }

    // Utilities

    /**
     * Checks if the given index is in the range [0, n].
     * IndexOutOfBoundsException is thrown to signal an invalid index argument.
     */
    protected void checkIndex(int i, int n) {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    /**
     * Checks if the array has available space.
     * IllegalStateException signals that a method has been invoked at an illegal or inappropriate time.
     */
    protected void checkCapacity() {
        if (this.size() == elements.length)
            throw new IllegalStateException("Array is full");
    }

}