package ch.hslu.ad.sw03;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

/**
 * This implementation of the @{@link Queue} interface works internally with a array that will be used as a ring
 * buffer.
 *
 * @author Jan Bucher
 * @param <E> Type of the payload
 */
public class RingBufferQueue<E> implements Queue<E> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int headPointer = -1;
    private int tailPointer = -1;
    private int numberOfElements = 0;

    /**
     * Instantiate a new queue with the default size of 10
     */
    public RingBufferQueue() {
        array = new Object[DEFAULT_SIZE];
    }

    /**
     * Instantiate a new queue with a given size
     * @param size the size of the new queue
     */
    public RingBufferQueue(int size) {
        array = new Object[size];
    }

    @Override
    public void add(final E element) {
        if (isFull()) {
            throw new BufferOverflowException();
        }
        if (headPointer + 1 > array.length - 1) {
            // rotate to the other end of the array
            headPointer = -1;
        }

        array[++headPointer] = element;
        numberOfElements++;
        if (tailPointer == -1) {
            tailPointer = 0;
        }
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (tailPointer >= array.length) {
            tailPointer = 0;
        }
        E returnElement = (E) array[tailPointer++];
        array[tailPointer - 1] = null;
        numberOfElements--;
        return returnElement;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements < 1;
    }

    private boolean isFull() {
        return numberOfElements >= array.length;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("array", array)
                .append("headPointer", headPointer)
                .append("tailPointer", tailPointer)
                .append("numberOfElements", numberOfElements)
                .toString();
    }
}
