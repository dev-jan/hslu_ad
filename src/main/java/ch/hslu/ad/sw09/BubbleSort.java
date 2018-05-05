package ch.hslu.ad.sw09;

/**
 * This class implements the "bubble sort" algorithm.
 *
 * Description from Wikipedia: https://en.wikipedia.org/wiki/Bubble_sort
 * More graphical description: https://www.geeksforgeeks.org/bubble-sort/
 *
 * Average/Worst case time complexity: O(n^2)
 * Best case: O(n)
 */
public class BubbleSort extends IntArraySort {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int currentPosition = 0; currentPosition < array.length - 1 - i;currentPosition++) {
                if (array[currentPosition] > array[currentPosition + 1]) {
                    swap(array, currentPosition, currentPosition + 1);
                }
            }
        }
    }
}
