package ch.heg.ig.sda.datastructure;

/**
 * @author maximili.jeannere
 */
public interface List<E> {

    /**
     * Returns the number of elements stored in the list.
     *
     * @return Number of elements in the list.
     */
    int size(); // (optional public abstract)

    /**
     * Returns a boolean indicating whether the list is empty.
     *
     * @return True if the list is empty.
     */
    boolean isEmpty();

    /**
     * Returns the element at index i.
     *
     * @param i Index
     * @return Instance of element at index i
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with the given element and returns the replaced element.
     *
     * @param i       Index
     * @param element Instance of element.
     * @return The replaced element.
     */
    E set(int i, E element);

    /**
     * Inserts an element at index i, shifting subsequent elements by one index.
     *
     * @param i       Index where the element is added.
     * @param element Instance of element.
     */
    void add(int i, E element);

    /**
     * Adds an element to the end of the list.
     *
     * @param element Instance to add.
     */
    void add(E element);

    /**
     * Removes and returns the element at index i, shifting subsequent elements.
     *
     * @param i Index.
     * @return Instance of removed element.
     */
    E remove(int i);
}
