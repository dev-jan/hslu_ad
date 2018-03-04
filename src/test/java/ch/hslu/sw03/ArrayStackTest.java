package ch.hslu.sw03;

import ch.hslu.ad.sw03.ArrayStack;
import ch.hslu.ad.sw03.Stack;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Unittest for @{@link ch.hslu.ad.sw03.ArrayStack}
 */
public class ArrayStackTest {
    @Test
    public void test_emptyStack() {
        // arrange
        Stack<String> stack = new ArrayStack<>();

        // assert
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void test_push_oneElement() {
        // arrange
        Stack<String> stack = new ArrayStack<>(1);

        // act
        stack.push("Hallo");

        // assert
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.isFull()).isTrue();
    }

    @Test
    public void test_push_multiple() {
        // arrange
        Stack<String> stack = new ArrayStack<>(5);

        // act
        stack.push("Hallo");
        stack.push("2");

        // assert
        assertThat(stack.isFull()).isFalse();
    }

    @Test
    public void test_pop_multipleElements() {
        // arrange
        Stack<String> stack = new ArrayStack<>();
        stack.push("Hallo1");
        stack.push("Test2");
        stack.push("Test3");

        // act
        String element1 = stack.pop();
        String element2 = stack.pop();
        String element3 = stack.pop();

        // assert
        assertThat(element1).isEqualTo("Test3");
        assertThat(element2).isEqualTo("Test2");
        assertThat(element3).isEqualTo("Hallo1");
        assertThat(stack.isEmpty()).isTrue();
    }
}
