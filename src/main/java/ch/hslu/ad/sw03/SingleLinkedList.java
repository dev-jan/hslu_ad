package ch.hslu.ad.sw03;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This list is a simple single linked list. All nodes of the list are linked only to the next node, but not to the
 * previous one. This makes this list slowly for many operations, but also simple to implement. This list does not
 * implement all methods of the @{@link List} interface correctly, so beware the behaviour before using this list
 * implementation! Consider using a well-tested list from the java.lang package like @{@link java.util.LinkedList}.
 *
 * @author Jan Bucher
 *
 * @see java.util.List
 * @param <E> Type of the objects that this list holds
 */
public class SingleLinkedList<E> implements List<E> {
    private Node<E> firstNode = null;

    @Override
    public boolean add(final E element) {
        if (firstNode == null) {
            firstNode = new Node<>(element);
        }
        else {
            // go to the last list item
            Node<E> node = firstNode;
            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }
            // append new node after last node
            node.setNextNode(new Node<>(element));
        }
        return true;
    }

    @Override
    public void add(final int index, final E element) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends E> c) {
        // adding at a special index is not jet possible -> just add at the end
        return addAll(c);
    }

    @Override
    public E set(final int index, final E element) {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(final Object o) {
        Node<E> preNode = null;
        Node<E> node = firstNode;
        while (node != null) {
            if (dataIsEqualWithObject(node, o)) {
                if (preNode != null) {
                    preNode.setNextNode(node.getNextNode());
                }
                else {
                    this.firstNode = node.getNextNode();
                }
                return true;
            }
            preNode = node;
            node = node.getNextNode();
        }
        return false;
    }

    @Override
    public E remove(final int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (Object e : c) {
            remove(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        // release the reference to the first node and let the Java GC do the rest
        firstNode = null;
    }

    @Override
    public int size() {
        int counter = 0;
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return counter;
    }

    @Override
    public E get(final int index) throws IndexOutOfBoundsException {
        Node<E> currentNode = firstNode;
        for (int i = 0; i < index;i++) {
            if (currentNode != null) {
                currentNode = currentNode.getNextNode();
            }
        }
        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return currentNode.getData();
    }

    /**
     * Returns the first list element and removes it from the list
     * @return the first element or <code>null</code> if the element not exists
     */
    public E popFirstElement() {
        if (firstNode == null) {
            return null;
        }
        Node<E> nodeToPop = firstNode;
        firstNode = firstNode.getNextNode();
        return nodeToPop.getData();
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(final Object o) {
        Node<E> currentNode = firstNode;
        while (currentNode != null) {
            if (dataIsEqualWithObject(currentNode, o)) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        // element not found in list
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new SingleLinkedListIterator<>(this.firstNode);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        Node<E> currentNode = firstNode;
        int i = 0;
        while (currentNode != null) {
            array[i++] = currentNode.getData();
            currentNode = currentNode.getNextNode();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Node<E> currentNode = firstNode;
        int i = 0;
        while (currentNode != null) {
            a[i++] = (T) currentNode.getData();
            currentNode = currentNode.getNextNode();
        }
        return a;
    }

    @Override
    public int indexOf(final Object o) {
        Node<E> currentNode = firstNode;
        int i = 0;
        while (currentNode != null) {
            if (dataIsEqualWithObject(currentNode, o)) {
                return i;
            }
            currentNode = currentNode.getNextNode();
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(final Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(final int fromIndex, final int toIndex) {
        throw new UnsupportedOperationException();
    }

    private boolean dataIsEqualWithObject(final Node currentNode, final Object o) {
        if (currentNode.getData() != null && currentNode.getData().equals(o) ||
                currentNode.getData() == null && o == null) {
            return true;
        }
        return false;
    }

}
