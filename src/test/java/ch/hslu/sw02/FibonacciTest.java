package ch.hslu.sw02;

import ch.hslu.ad.sw02.Fibonacci;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FibonacciTest {
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

}
