package ch.hslu.sw02;

import ch.hslu.ad.sw02.Fibonacci;
import ch.hslu.ad.sw02.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FibonacciTest {
    private static final Logger LOG = LogManager.getLogger(Task.class);

    @Test
    public void test_fibonacciPerformance_compare() {
        int n = 45;
        LOG.info("Performance test of fibonacci index " + n);

        long starttime2 = System.currentTimeMillis();
        System.out.println(Fibonacci.fiboRec2(n));
        long endtime2 = System.currentTimeMillis();
        LOG.warn("Duration fiboRec2: " + (endtime2 - starttime2) / 1000f  + " sec");

        long starttime = System.currentTimeMillis();
        System.out.println(Fibonacci.fiboRec1(n));
        long endtime = System.currentTimeMillis();
        LOG.warn("Duration fiboRec1: " + (endtime - starttime) / 1000f  + " sec");

        long starttime3 = System.currentTimeMillis();
        System.out.println(Fibonacci.fiboIter(n));
        long endtime3 = System.currentTimeMillis();
        LOG.warn("Duration fiboIter: " + (endtime3 - starttime3) / 1000f  + " sec");
    }

    @Test
    public void test_fiboRec1_five() {
        // arrange
        int n = 5;

        // act
        int result = Fibonacci.fiboRec1(n);

        // assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test_fiboRec1_zero() {
        // arrange
        int n = 0;

        // act
        int result = Fibonacci.fiboRec1(n);

        // assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_fiboRec1_one() {
        // arrange
        int n = 1;

        // act
        int result = Fibonacci.fiboRec1(n);

        // assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void test_fiboRec2_five() {
        // arrange
        int n = 5;

        // act
        int result = Fibonacci.fiboRec2(n);

        // assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test_fiboRec2_zero() {
        // arrange
        int n = 0;

        // act
        int result = Fibonacci.fiboRec2(n);

        // assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_fiboRec2_one() {
        // arrange
        int n = 1;

        // act
        int result = Fibonacci.fiboRec2(n);

        // assert
        assertThat(result).isEqualTo(1);
    }
    @Test
    public void test_fiboIter_five() {
        // arrange
        int n = 5;

        // act
        int result = Fibonacci.fiboIter(n);

        // assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test_fiboIter_zero() {
        // arrange
        int n = 0;

        // act
        int result = Fibonacci.fiboIter(n);

        // assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_fiboIter_one() {
        // arrange
        int n = 1;

        // act
        int result = Fibonacci.fiboIter(n);

        // assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void test_fiboIter_six() {
        // arrange
        int n = 6;

        // act
        int result = Fibonacci.fiboIter(n);

        // assert
        assertThat(result).isEqualTo(8);
    }


    @Test
    public void test_fiboApproximation_five() {
        // arrange
        int n = 5;

        // act
        int result = Fibonacci.fiboApproximation(n);

        // assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test_fiboApproximation_zero() {
        // arrange
        int n = 0;

        // act
        int result = Fibonacci.fiboApproximation(n);

        // assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test_fiboApproximation_one() {
        // arrange
        int n = 1;

        // act
        int result = Fibonacci.fiboApproximation(n);

        // assert
        assertThat(result).isEqualTo(1);
    }


}
