package ch.hslu.ad.sw03;

/**
 * Represents a FIFO queue. This Queue was only made for educational purposes, consider using @{@link java.util.Deque}
 * of the java collection framework instead.
 *
 * @param <E> Type of the payload data
 */
public interface Queue<E> {
    /**
     * Add a element to the queue at the last position.
     * @param element element to add
     * @throws java.nio.BufferOverflowException if the queue is not big enough
     */
    void add(final E element);

    /**
     * Return the first element of the queue and remove it from the queue.
     * @return the first element
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    E poll();

    /**
     * Return if the queue is currently empty or not.
     * @return <code>true</code> if the queue is empty (no elements in it), otherwise <code>false</code>
     */
    boolean isEmpty();
}
