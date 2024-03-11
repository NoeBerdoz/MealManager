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
     * @return Instance of Person at index i
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with an instance of Person and returns the replaced element.
     *
     * @param i       Index
     * @param element Instance of Person.
     * @return The replaced element.
     */
    E set(int i, E element);

    /**
     * Inserts an element of type Person at index i, shifting subsequent elements by one index.
     *
     * @param i       Index where the person is added.
     * @param element Instance of Person.
     */
    void add(int i, E element);

    /**
     * Adds an element to the end of the list.
     *
     * @param element Instance of Person to add.
     */
    void add(E element);

    /**
     * Removes and returns the element at index i, shifting subsequent elements.
     *
     * @param i Index.
     * @return Instance of removed person.
     */
    E remove(int i);
}
