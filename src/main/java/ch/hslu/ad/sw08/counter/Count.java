package ch.hslu.ad.sw08.counter;

/**
 * Represents a counter to count a number up.
 */
public interface Count {
    /**
     * Add one to the count object
     */
    void addOne();

    /**
     * Get the current value of the counter
     * @return the current value
     */
    long getCurrentValue();

}
