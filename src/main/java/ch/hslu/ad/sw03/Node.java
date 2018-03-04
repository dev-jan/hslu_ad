package ch.hslu.ad.sw03;

/**
 * Represents a list node in a single linked list.
 * @param <E> Type of the dataobject, that the node holds for the list
 */
public class Node<E> {
    private E data;
    private Node nextNode;

    /**
     * Create a new list node with the given data as payload.
     * @param data object, that the list node holds
     */
    public Node(E data) {
        this.data = data;
    }

    /**
     * Return the payload data of the list node.
     * @return the payload or <code>null</code> if no data object is set on the listitem
     */
    public E getData() {
        return this.data;
    }

    /**
     * Return the next node in the list.
     * @return the next node or <code>null</code> if this node is the last node
     */
    public Node getNextNode() {
        return this.nextNode;
    }

    /**
     * Set the next node of the list.
     * @param nextNode next node or <code>null</code> if the current node is the last node
     */
    public void setNextNode(final Node nextNode) {
        this.nextNode = nextNode;
    }

}
