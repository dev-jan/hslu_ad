package ch.hslu.mepprepare;

import ch.hslu.ad.mepprepare.ForkJoinExample;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unittest for {@link ForkJoinExample}
 */
public class ForkJoinExampleTest {
    @Test
    public void test_GetMax_simpleList() throws ExecutionException, InterruptedException {
        // arrange
        List<Integer> values = new ArrayList<>(Arrays.asList(12, 1, 99, 45, 23, 89, 109, 22));

        // act
        int max = ForkJoinExample.getMax(values);

        // assert
        assertThat(max).isEqualTo(109);
    }

    @Test
    public void test_GetMax_oddList() throws ExecutionException, InterruptedException {
        // arrange
        List<Integer> values = new ArrayList<>(Arrays.asList(7, 1, 99, 45, 23, 89, 109));

        // act
        int max = ForkJoinExample.getMax(values);

        // assert
        assertThat(max).isEqualTo(109);
    }

    @Test
    public void test_GetMax_emptyList() throws ExecutionException, InterruptedException {
        // act
        int max = ForkJoinExample.getMax(Collections.EMPTY_LIST);

        // assert
        assertThat(max).isEqualTo(-1);
    }

    /**
     * Just to compare the own implementation with the java implementation.
     */
    @Test
    public void test_JavaImplementation_GetMax() {
        // arrange
        List<Integer> values = new ArrayList<>(Arrays.asList(12, 1, 99, 45, 23, 89, 109, 22));

        // act
        OptionalInt result = values.stream().mapToInt(i -> i).max();

        // assert
        assertThat(result.getAsInt()).isEqualTo(109);
    }

}
