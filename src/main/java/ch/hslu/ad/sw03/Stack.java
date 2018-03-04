package ch.hslu.ad.sw03;

/**
 * Represents a simple FILO stack. Only the "top" element of the stack can be returned. Before using this class,
 * consider using the standard java implementation of a stack @{@link java.util.Stack} as this interface is just
 * for educational purpose.
 *
 * @param <E> type of the payload
 */
public interface Stack<E> {
    /**
     * Put an element on the stack. The element will be put on top of the stack and can be returned with {@link #pop()}
     * @param element element to put onto the stack
     */
    void push(E element);

    /**
     * Return the top element of the stack (the element that was last inserted). The element get removed from the stack
     * while returning the element.
     * @return the element
     * @throws java.util.EmptyStackException if the stack is empty
     */
    E pop();

    /**
     * Check if the stack is empty.
     * @return <code>true</code> if the stack is empty, <code>false</code> otherwise
     */
    boolean isEmpty();

    /**
     * Check if the stack is full.
     * @return <code>true</code> if there is no more space left on the stack
     */
    boolean isFull();

}
