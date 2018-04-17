package ch.hslu.ad.sw08.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Implements the count interface with multi-threaded.
 */
public class MultiThreadedCounter implements Count {
    private static final Logger LOG = LogManager.getLogger(MultiThreadedCounter.class);
    private AtomicLong value = new AtomicLong(0);
    private long maxValue = 0;

    @Override
    public void addOne() {
        long v = value.get();
        if (v < maxValue || maxValue == 0) {
            value.compareAndSet(v, v + 1);
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            LOG.error("Sleep was interrupted");
        }
    }

    public void setMaximumNumber(long max) {
        this.maxValue = max;
    }

    public boolean isMaxReached() {
        if (value.get() >= maxValue) {
            return true;
        }
        return false;
    }

    @Override
    public long getCurrentValue() {
        return value.get();
    }

}
