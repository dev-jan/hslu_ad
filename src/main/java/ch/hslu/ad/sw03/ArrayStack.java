package ch.hslu.ad.sw03;

import java.util.EmptyStackException;

/**
 * Represents an stack implementation (LIFO queue). Consider that this stack implementation has a predefined size
 * limit, which cannot be changed after creating an ArrayStack instance. This class was only made for educational
 * purpose and the correct functionality is not guaranteed. Maybe use another more stable stack implementation from
 * the java collectionn framework instead: @{@link java.util.LinkedList}.
 *
 * @param <E> type of payload data
 */
public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] stack;
    private int lastElementIndex = -1;

    /**
     * Create a new ArrayStack with the default size of 10
     */
    public ArrayStack() {
        stack = new Object[DEFAULT_SIZE];
    }

    /**
     * Create a new ArrayStack with a given size
     * @param size size of the stack
     */
    public ArrayStack(int size) {
        stack = new Object[size];
    }

    @Override
    public void push(E element) {
        if (lastElementIndex + 1 > stack.length) {
            throw new StackOverflowError("Stack is to small");
        }
        stack[++lastElementIndex] = element;
    }

    @Override
    public E pop() {
        if (lastElementIndex < 0) {
            throw new EmptyStackException();
        }
        E lastElement = (E)stack[lastElementIndex];
        stack[lastElementIndex--] = null;
        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return lastElementIndex < 0 ? true : false;
    }

    @Override
    public boolean isFull() {
        return lastElementIndex >= stack.length - 1 ? true : false;
    }

}
