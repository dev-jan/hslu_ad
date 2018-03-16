package ch.hslu.sw04;

import ch.hslu.ad.sw04.SimpleBinaryTree;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleBinaryTreeTest {
    @Test
    public void test_add_oneElement() {
        // arrange
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();

        // act
        tree.add("1");

        // assert
        assertThat(tree.getRootNode().getData()).isEqualTo("1");
        assertThat(tree.getRootNode().getLeftNode()).isNull();
        assertThat(tree.getRootNode().getRightNode()).isNull();
    }

    @Test
    public void test_add_multipleElements() {
        // arrange
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();

        // act
        tree.add("A");
        tree.add("B");
        tree.add("C");
        tree.add("D");

        // assert
        assertThat(tree.getRootNode().getData()).isEqualTo("A");
    }

    @Test
    public void test_search_inEmptyTree() {
        // arrange
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();

        // act
        String result = tree.search("A");

        // assert
        assertThat(result).isNull();
    }

    @Test
    public void test_search_existingElement() {
        // arrange
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();
        tree.add("A");
        tree.add("B");
        tree.add("C");
        tree.add("D");
        tree.add("E");

        // act
        String result = tree.search("C");

        // assert
        assertThat(result).isEqualTo("C");
    }

    @Test
    public void test_search_rootElement() {
        // arrange
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();
        tree.add("A");
        tree.add("B");
        tree.add("C");
        tree.add("D");
        tree.add("E");

        // act
        String result = tree.search("A");

        // assert
        assertThat(result).isEqualTo("A");
    }

    @Test
    public void test_search_nonExistingElement() {
        // arrange
        SimpleBinaryTree<String> tree = new SimpleBinaryTree<>();
        tree.add("A");
        tree.add("B");
        tree.add("C");
        tree.add("D");
        tree.add("E");

        // act
        String result = tree.search("ZZ");

        // assert
        assertThat(result).isNull();
    }

}
