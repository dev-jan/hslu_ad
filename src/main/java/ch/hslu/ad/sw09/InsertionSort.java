package ch.hslu.ad.sw09;

/**
 * This class implements the simple "insertion sort" algorithm.
 *
 * Description from Wikipedia: https://en.wikipedia.org/wiki/Insertion_sort
 * More graphical description: https://www.geeksforgeeks.org/insertion-sort/
 *
 * Average time complexity: O(n^2)
 * Best case: O(n) -> pre-sorted array
 */
public class InsertionSort extends IntArraySort {

    @Override
    public void sort(int[] array) {
        int temp;
        int searchPosition;
        for (int currentPosition = 1;currentPosition < array.length;currentPosition++) {
            temp = array[currentPosition];
            searchPosition = currentPosition;
            while((searchPosition > 0) && (array[searchPosition - 1] > temp)) {
                array[searchPosition] = array[searchPosition - 1];
                searchPosition--;
            }
            array[searchPosition] = temp;
        }
    }

}
