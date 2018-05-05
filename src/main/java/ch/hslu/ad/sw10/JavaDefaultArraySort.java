package ch.hslu.ad.sw10;

import ch.hslu.ad.sw09.IntArraySort;

import java.util.Arrays;

/**
 * This class uses the default java array sort algorithm.
 *
 * Java 6 (and earlier) uses QuickSort to sort an array.
 * Java 7 (and later) uses TimSort (a hybrid between MergeSort and InsertionSort).
 */
public class JavaDefaultArraySort extends IntArraySort {
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
