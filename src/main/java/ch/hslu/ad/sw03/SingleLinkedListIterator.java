package ch.hslu.ad.sw03;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator implementation for @{@link SingleLinkedList}.
 *
 * @param <E> Type of the payload of the list
 */
public class SingleLinkedListIterator<E> implements Iterator<E> {
    private Node<E> nextNode = null;

    /**
     * Create a new SingleLinkedListIterator with a given starting node.
     * @param firstNode the first node to iterate throw
     */
    public SingleLinkedListIterator(final Node firstNode) {
        this.setNextNode(firstNode);
    }

    @Override
    public boolean hasNext() {
        if (nextNode != null) {
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if (hasNext()) {
            Node<E> tmp = nextNode;
            nextNode = nextNode.getNextNode();
            return tmp.getData();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    private void setNextNode(final Node nextNode) {
        this.nextNode = nextNode;
    }
}
