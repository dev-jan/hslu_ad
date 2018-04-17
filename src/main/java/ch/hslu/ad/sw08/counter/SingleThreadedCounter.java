package ch.hslu.ad.sw08.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implements the Count interface as simple as possible (single threaded).
 */
public class SingleThreadedCounter implements Count {
    private static final Logger LOG = LogManager.getLogger(SingleThreadedCounter.class);
    private long value = 0;

    @Override
    public void addOne() {
        value++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            LOG.error("Sleep interrupted");
        }
    }

    @Override
    public long getCurrentValue() {
        return value;
    }

}
