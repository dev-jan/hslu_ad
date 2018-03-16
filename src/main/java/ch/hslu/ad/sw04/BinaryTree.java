package ch.hslu.ad.sw04;

/**
 * Represents a binary tree datastructure. This datastructure can store data to search them very fast.
 * Please consider using the java implementation of the binary tree: @{@link java.util.HashSet}.
 * @param <E> datatype of the payload
 */
public interface BinaryTree<E> extends Iterable<E> {
    /**
     * Add the given element to the tree.
     * @param element element to add
     */
    void add(E element);

    /**
     * Remove the given element from the list.
     * @param element element to remove
     */
    void remove(E element);

    /**
     * Search a given element and return it if it exists in the tree
     * @param element the element to search
     * @return the element or <code>null</code> if the element was not found.
     */
    E search(E element);
}
