package ch.hslu.sw03;

import ch.hslu.ad.sw03.Queue;
import ch.hslu.ad.sw03.RingBufferQueue;
import org.junit.Test;

import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

/**
 * Unittests for @{@link ch.hslu.ad.sw03.RingBufferQueue}
 */
public class RingBufferQueueTest {
    @Test
    public void test_add_oneElement() {
        // arrange
        Queue<String> queue = new RingBufferQueue<>();

        // act
        queue.add("Test");

        // assert
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.poll()).isEqualTo("Test");
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    public void test_add_multipleElements() {
        // arrange
        Queue<String> queue = new RingBufferQueue<>();

        // act
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");

        // assert
        assertThat(queue.poll()).isEqualTo("Test1");
        assertThat(queue.poll()).isEqualTo("Test2");
        assertThat(queue.poll()).isEqualTo("Test3");
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test(expected = BufferOverflowException.class)
    public void test_add_fullQueue() {
        // arrange
        Queue<String> queue = new RingBufferQueue<>(2);
        queue.add("1");
        queue.add("2");

        // act
        queue.add("3");
    }

    @Test
    public void test_add_moreThanBufferSize() {
        // arrange
        Queue<String> queue = new RingBufferQueue<>( 4);
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");
        queue.add("Test4");

        // act
        String firstElement = queue.poll();
        queue.add("Test5");

        // assert
        assertThat(firstElement).isEqualTo("Test1");
        assertThat(queue.poll()).isEqualTo("Test2");
        assertThat(queue.poll()).isEqualTo("Test3");
        assertThat(queue.poll()).isEqualTo("Test4");
        assertThat(queue.poll()).isEqualTo("Test5");
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_poll_withEmptyQueue() {
        // arrange
        Queue<String> queue = new RingBufferQueue<>();

        // act
        queue.poll();
    }


}
