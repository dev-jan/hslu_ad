package ch.hslu.ad.sw04;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BinaryTreeNode<E extends Comparable> implements Comparable<E> {
    private E data;
    private BinaryTreeNode<E> leftNode;
    private BinaryTreeNode<E> rightNode;

    public BinaryTreeNode(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public void setLeftNode(BinaryTreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<E> getLeftNode() {
        return this.leftNode;
    }

    public void setRightNode(BinaryTreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode<E> getRightNode() {
        return this.rightNode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("data", data)
                .append("leftNode", leftNode)
                .append("rightNode", rightNode)
                .toString();
    }

    @Override
    public int compareTo(E o) {
        if (data != null) {
            return data.compareTo(o);
        }
        return -1;
    }
}
