package ch.hslu.ad.sw03;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

public class RingBufferQueue<E> implements Queue<E> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int headPointer = -1;
    private int tailPointer = -1;
    private int numberOfElements = 0;

    public RingBufferQueue() {
        array = new Object[DEFAULT_SIZE];
    }

    public RingBufferQueue(int size) {
        array = new Object[size];
    }

    @Override
    public void add(E element) {
        if (headPointer + 1 > array.length - 1) {
            // rotate to the other end of the array
            if (tailPointer == 0) {
                // rotation is not possible, otherwise the head overruns the tail
                throw new BufferOverflowException();
            }
            headPointer = -1;
        }
        else {
            if (headPointer + 1 == tailPointer) {
                throw new BufferOverflowException();
            }
        }

        array[++headPointer] = element;
        numberOfElements++;
        if (tailPointer == -1) {
            tailPointer = 0;
        }
    }

    @Override
    public E poll() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (tailPointer >= array.length) {
            tailPointer = 0;
        }
        boolean isLastElement = false;
        if (tailPointer == headPointer) {
            isLastElement = true;
        }
        E returnElement = (E) array[tailPointer++];
        array[tailPointer - 1] = null;
        numberOfElements--;
        if (isLastElement) {
            tailPointer = -1;
            headPointer = -1;
        }
        return returnElement;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements < 1 ? true : false;
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
