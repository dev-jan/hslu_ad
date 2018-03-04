package ch.hslu.ad.sw02;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains various static methods to create fibonacci numbers by different algorithms.
 */
public class Fibonacci {
    private static Map<Integer, Integer> cache = new HashMap<>();

    /**
     * Private constructor to prevent creating instances of this class.
     */
    private Fibonacci() {
        // this class must not be instantiated
    }

    /**
     * Return the n-th fibonacci number
     * @param n index of the fibonacci number
     * @return the fibonacci number
     */
    public static int fiboRec1(final int n) {
        // recursion base
        if (n <= 1) {
            return n;
        }
        // recursion rule
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    /**
     * Return the n-th fibonacci number (with more speed than fiboRec1)
     * @param n index of the fibonacci number
     * @return the fibonacci number
     */
    public static int fiboRec2(final int n) {
        if (cache.containsKey(Integer.valueOf(n))) {
            return cache.get(Integer.valueOf(n));
        }
        if (n <= 1) {
            cache.put(n, n);
            return n;
        }
        int result = fiboRec2(n - 1) + fiboRec2(n - 2);
        cache.put(n, result);
        return result;
    }

    /**
     * Return the n-th fibonacci number by using an iterative algorithm.
     * @param n index of the fibonacci number
     * @return the fibonacci number
     */
    public static int fiboIter(final int n) {
        if (n == 0) {
            return 0;
        }
        int nMinusOne = 1;
        int nMinusTwo = 0;
        for (int i = 1; i < n - 1; i++) {
            int tmp = nMinusOne + nMinusTwo;
            nMinusTwo = nMinusOne;
            nMinusOne = tmp;
        }
        return nMinusOne + nMinusTwo;
    }

    /**
     * Return the n-th fibonacci number by using an mathematic approximation. The result is maybe wrong or not exact.
     * @param n index of the fibonacci number
     * @return the fibonacci number
     */
    public static int fiboApproximation(final int n) {
        double result = (1f / Math.sqrt(5)) * Math.pow(0.5 * (1 + Math.sqrt(5)), n);
        return (int)Math.round(result);
    }

}
