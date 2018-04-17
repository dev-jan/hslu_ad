package ch.hslu.sw08;

import ch.hslu.ad.sw08.counter.MultiThreadedCounter;
import ch.hslu.ad.sw08.counter.SingleThreadedCounter;
import com.google.common.base.Stopwatch;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterTest {
    private static final Logger LOG = LogManager.getLogger(PrimeNumberTest.class);
    private static final int MAX_NUMBER = 500;

    @Test
    public void test_singleThreadedCounter() {
        // arrange
        SingleThreadedCounter counter = new SingleThreadedCounter();
        Stopwatch stopwatch = Stopwatch.createStarted();

        // act
        for (long i = 0;i < MAX_NUMBER;i++) {
            counter.addOne();
        }

        // assert
        LOG.info("Single threaded time: " + DurationFormatUtils.formatDurationHMS(stopwatch.stop().elapsed().toMillis()));
        assertThat(counter.getCurrentValue()).isEqualTo(MAX_NUMBER);
    }

    @Test
    public void test_multiThreadedCounter() throws Exception {
        // arrange
        final MultiThreadedCounter counter = new MultiThreadedCounter();
        counter.setMaximumNumber(MAX_NUMBER);
        Stopwatch stopwatch = Stopwatch.createStarted();
        int numberOfThreads = 2;

        // act
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads;i++) {
            executorService.execute(() -> {
                while (!counter.isMaxReached()) {
                    counter.addOne();
                }
            });
        }

        // assert
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        LOG.info("Multi threaded time: " + DurationFormatUtils.formatDurationHMS(stopwatch.stop().elapsed().toMillis()));
        assertThat(counter.getCurrentValue()).isEqualTo(MAX_NUMBER);
    }
}
