package ch.hslu.sw08;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockingQueueTest {
    @Test
    public void test_putAndGet_fillQueue() throws Exception {
        // arrange
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        String element1 = "1";
        String element2 = "2";

        // act
        blockingQueue.put(element1);
        blockingQueue.put(element2);
        String returningElement1 = blockingQueue.poll();
        String returningElement2 = blockingQueue.poll();
        assertThat(returningElement1).isEqualTo(element1);
        assertThat(returningElement2).isEqualTo(element2);
    }

}
