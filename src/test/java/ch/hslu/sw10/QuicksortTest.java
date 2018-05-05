package ch.hslu.sw10;

import ch.hslu.ad.sw09.IntArraySort;
import ch.hslu.ad.sw10.Quicksort;
import ch.hslu.sw09.BubbleSortTest;
import ch.hslu.sw09.IntArraySortTest;
import com.google.common.base.Stopwatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for @{@link Quicksort}
 */
public class QuicksortTest extends IntArraySortTest {
    private static final Logger LOG = LogManager.getLogger(BubbleSortTest.class);

    @Test
    public void test_sort_randomArray_small() {
        // arrange
        int[] array = IntArraySort.cloneArray(IntArraySortTest.SMALL_RANDOM_DEMO_ARRAY);
        Quicksort quicksort = new Quicksort();
        LOG.debug("Before: " + Arrays.toString(array));
        Stopwatch sp = Stopwatch.createStarted();

        // act
        quicksort.sort(array);

        // assert
        LOG.debug("After: " + Arrays.toString(array));
        LOG.info("Time taken: " + sp.stop().toString());
        assertArrayOrder(array);
    }

    @Test
    public void test_sort_randomArray_large() {
        // arrange
        int[] array = IntArraySort.cloneArray(IntArraySortTest.LARGE_RANDOM_DEMO_ARRAY);
        Quicksort quicksort = new Quicksort();
        LOG.debug("Before: " + Arrays.toString(array));
        Stopwatch sp = Stopwatch.createStarted();

        // act
        quicksort.sort(array);

        // assert
        LOG.debug("After: " + Arrays.toString(array));
        LOG.info("Time taken: " + sp.stop().toString());
        assertArrayOrder(array);
    }

    @Test
    public void test_sort_presortedArray() {
        // arrange
        int[] array = IntArraySort.cloneArray(IntArraySortTest.LARGE_PRESORTED_DEMO_ARRAY);
        Quicksort quicksort = new Quicksort();
        LOG.debug("Before: " + Arrays.toString(array));
        Stopwatch sp = Stopwatch.createStarted();

        // act
        quicksort.sort(array);

        // assert
        LOG.debug("After: " + Arrays.toString(array));
        LOG.info("Time taken: " + sp.stop().toString());
        assertArrayOrder(array);
    }

    @Test
    public void test_sort_reversedArray() {
        // arrange
        int[] array = IntArraySort.cloneArray(IntArraySortTest.LARGE_REVERSED_DEMO_ARRAY);
        Quicksort quicksort = new Quicksort();
        LOG.debug("Before: " + Arrays.toString(array));
        Stopwatch sp = Stopwatch.createStarted();

        // act
        quicksort.sort(array);

        // assert
        LOG.debug("After: " + Arrays.toString(array));
        LOG.info("Time taken: " + sp.stop().toString());
        assertArrayOrder(array);
    }

}
