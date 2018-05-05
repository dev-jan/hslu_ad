package ch.hslu.ad.sw10;

import ch.hslu.ad.sw09.IntArraySort;

/**
 * This class implements the "HeapSort" algorithm.
 *
 * Description from Wikipedia: https://en.wikipedia.org/wiki/Heapsort
 * More graphical description: https://www.geeksforgeeks.org/heap-sort/
 *
 * Average Case: O(n * log(n))
 */
public class HeapSort extends IntArraySort {
    @Override
    public void sort(int[] array) {
        // build heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // extract elements one-by-one from heap
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0,i);
            heapify(array, i, 0);
        }
    }

    /**
     * Heapify a subtree rooted with a given index and a given heap size
     * @param array the array
     * @param size size of the heap
     * @param index index of the root node
     */
    private void heapify(int[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }

        if (right < size && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(array, largest, index);
            heapify(array, size, largest);
        }
    }

}
