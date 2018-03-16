package ch.hslu.ad.sw04;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Iterator;

/**
 * Simple implementation of a binary search tree. May not support all operations...
 * @author Jan Bucher
 * @param <E> type of the payload data.
 */
public class SimpleBinaryTree<E extends Comparable> implements BinaryTree<E> {
    private BinaryTreeNode<E> rootNode;

    @Override
    public void add(E element) {
        if (rootNode == null) {
            rootNode = new BinaryTreeNode<>(element);
        }
        else {
            boolean placeFound = false;
            BinaryTreeNode<E> currentNode = rootNode;
            while (!placeFound) {
                if (currentNode.compareTo(element) > 0) {
                    if (currentNode.getRightNode() != null) {
                        currentNode = currentNode.getRightNode();
                    }
                    else {
                        currentNode.setRightNode(new BinaryTreeNode<>(element));
                        placeFound = true;
                    }
                }
                else if (currentNode.compareTo(element) < 0) {
                    if (currentNode.getLeftNode() != null) {
                        currentNode = currentNode.getLeftNode();
                    }
                    else {
                        currentNode.setLeftNode(new BinaryTreeNode<>(element));
                        placeFound = true;
                    }
                }
                else {
                    // ignore duplicated elements for now...
                }
            }
        }
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public E search(E element) {
        boolean elementFound = false;
        BinaryTreeNode<E> currentNode = rootNode;
        while(!elementFound) {
            if (currentNode == null) {
                return null;
            }
            int compareNode = currentNode.compareTo(element);
            if (compareNode > 0) {
                currentNode = currentNode.getRightNode();
            }
            else if (compareNode < 0) {
                currentNode = currentNode.getLeftNode();
            }
            else if (element.equals(currentNode.getData())) {
                return currentNode.getData();
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public BinaryTreeNode<E> getRootNode() {
        return this.rootNode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rootNode", rootNode)
                .toString();
    }

}
