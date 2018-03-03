package ch.hslu.ad.sw03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedListIterator<E> implements Iterator<E> {
    private Node<E> nextNode = null;

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

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}