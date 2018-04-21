package ch.hslu.ad.sw07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Generic bounded buffer
 * @param <T> Typ
 */
public class BoundedBuffer<T> {

    private static final Logger LOG = LogManager.getLogger(BoundedBuffer.class);
    private final Object[] data;
    private int head;
    private int tail;
    private int count;
    private int maxSize;

    public BoundedBuffer(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
        head = 0;
        tail = 0;
        count = 0;
    }

    /**
     * Saves the given element into the bounded buffer. If the buffer is full, the method waits
     * until a place is free.
     * @param elem element to add
     * @throws InterruptedException thrown if the thread gets interrupted
     */
    public synchronized <T> void put(final T elem) throws InterruptedException {
        LOG.debug("[BoundedBuffer] Element will be added");
        while (count == data.length) {
            LOG.warn("[BoundedBuffer] Wait until a place is free...");
            this.wait();
        }
        LOG.debug("[BoundedBuffer] Wait finished");

        count++;
        data[tail] = elem;

        tail = (tail + 1) % data.length;

        if (count == 1) {
            this.notifyAll();
        }
    }

    /**
     * Get an element from the buffer. If no element is there, it waits.
     * @return the element from the buffer
     * @throws InterruptedException if the waiting gets interrupted
     */
    public synchronized <T> T get() throws InterruptedException {
        //solange leer ist warte
        LOG.debug("Read element...");
        while (count == 0) {
            LOG.warn("Wait for element...");
            this.wait();
        }
        LOG.debug("Found element");

        count--;
        T obj = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        if (count == data.length - 1) {
            this.notifyAll();
        }
        LOG.debug("Element: " + obj.toString());
        return obj;
    }

    public synchronized boolean empty() {
        return (count == 0);
    }

    public synchronized boolean full() {
        return (count == maxSize);
    }

    public synchronized int size() {
        return count;
    }

    /**
     * Get the last element without removing it.
     * @param <T> Type of the element
     * @return the element
     * @throws InterruptedException
     */
    public synchronized <T> T back() throws InterruptedException {
        while (count == 0) {
            this.wait();
        }

        if (tail == 0) {
            T obj = (T) data[data.length - 1];
            return obj;
        } else {
            T obj = (T) data[tail-1];
            return obj;
        }
    }

    /**
     * Get the first element without removing it.
     * @param <T> Type of the element
     * @return the element
     * @throws InterruptedException
     */
    public synchronized <T> T front() throws InterruptedException {
        while (count == 0) {
            this.wait();
        }
        T obj = (T) data[head];
        return obj;
    }

}
