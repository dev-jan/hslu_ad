package ch.hslu.ad.sw10;

import ch.hslu.ad.sw09.IntArraySort;

/**
 * This class implements the "quicksort" algorithm.
 *
 * Description from Wikipedia: https://en.wikipedia.org/wiki/Quicksort
 * More graphical description: https://www.geeksforgeeks.org/quick-sort/
 *
 * Average/Best case: O(n * log(n))
 * Worst case: O(n^2)
 */
public class Quicksort extends IntArraySort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        int up = left;
        int down = right - 1;
        int partitionElement = array[right];
        boolean allChecked = false;
        while (!allChecked) {
            while (array[up] < partitionElement) {
                up++;
            }
            while ((array[down] >= partitionElement) && (down > up)) {
                down--;
            }
            if (down > up) {
                swap(array, up, down);
                up++;
                down++;
            }
            else {
                allChecked = true;
            }
        }
        swap(array, up, right);
        if (left < (up - 1)) {
            sort(array, left, (up - 1));
        }
        if ((up + 1) < right) {
            sort(array, (up + 1), right);
        }
    }

}
