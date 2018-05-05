package ch.hslu.ad.sw09;

import java.util.Arrays;

/**
 * Abstract class for sorting integer arrays. This class must be implemented by concrete sort algorithms and provide
 * some standard functions that are useful for sorting arrays.
 */
public abstract class IntArraySort {
    /**
     * Sort the given array by its natural order.
     * @param array the array to sort
     */
    public abstract void sort(int[] array);

    /**
     * Return a copy of the given array
     * @param source given array to copy
     * @return a copy of the given array
     */
    public static int[] cloneArray(int[] source) {
        return Arrays.copyOf(source, source.length);
    }

}
