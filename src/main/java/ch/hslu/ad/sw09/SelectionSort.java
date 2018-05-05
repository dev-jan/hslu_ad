package ch.hslu.ad.sw09;

import org.apache.commons.lang.ArrayUtils;

/**
 * This class implements the simple "selection sort" algorithm.
 *
 * Description from Wikipedia: https://en.wikipedia.org/wiki/Selection_sort
 * More graphical description: https://www.geeksforgeeks.org/selection-sort/
 *
 * Time complexity: O(n^2)
 * (for best case, worst case and average case)
 */
public class SelectionSort extends IntArraySort {
    @Override
    public void sort(int[] array) {
        for (int currentPosition = 0; currentPosition < array.length -1; currentPosition++) {
            // find minimum value in unsorted array part
            int minimumPosition = currentPosition;
            for (int i = currentPosition + 1; i < array.length; i++) {
                if (array[i] < array[minimumPosition]) {
                    minimumPosition = i;
                }
            }
            // swap the minimum element with the first element
            swap(array, minimumPosition, currentPosition);
        }
    }

}
