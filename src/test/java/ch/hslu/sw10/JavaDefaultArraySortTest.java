package ch.hslu.sw10;

import ch.hslu.ad.sw09.IntArraySort;
import ch.hslu.ad.sw10.JavaDefaultArraySort;
import ch.hslu.sw09.IntArraySortTest;
import com.google.common.base.Stopwatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;

public class JavaDefaultArraySortTest extends IntArraySortTest {
    private static final Logger LOG = LogManager.getLogger(JavaDefaultArraySortTest.class);

    @Test
    public void test_sort_randomArray_large() {
        // arrange
        int[] array = IntArraySort.cloneArray(IntArraySortTest.LARGE_RANDOM_DEMO_ARRAY);
        JavaDefaultArraySort javaDefaultArraySort = new JavaDefaultArraySort();
        LOG.debug("Before: " + Arrays.toString(array));
        Stopwatch sp = Stopwatch.createStarted();

        // act
        javaDefaultArraySort.sort(array);

        // assert
        LOG.debug("After: " + Arrays.toString(array));
        LOG.info("Time taken: " + sp.stop().toString());
        assertArrayOrder(array);
    }
}
