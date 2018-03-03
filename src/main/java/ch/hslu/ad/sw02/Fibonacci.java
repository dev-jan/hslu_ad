package ch.hslu.ad.sw02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Integer> cache = new HashMap<>();

    /**
     * Return the n-th fibonacci number
     * @param n index of the fibonacci number
     * @return
     */
    public static int fiboRec1(final int n) {
        // recursion base
        if (n <= 1) {
            return n;
        }
        // recursion rule
        return fiboRec1(n-1) + fiboRec1(n-2);
    }

    /**
     * Return the n-th fibonacci number (with more speed than fiboRec1)
     * @param n index of the fibonacci number
     * @return
     */
    public static int fiboRec2(final int n) {
        if (cache.containsKey(Integer.valueOf(n))) {
            return cache.get(Integer.valueOf(n));
        }
        if (n <= 1) {
            cache.put(n, n);
            return n;
        }
        int result = fiboRec2(n-1) + fiboRec2(n-2);
        cache.put(n, result);
        return result;
    }

    public static int fiboIter(final int n) {
        if (n == 0) {
            return 0;
        }
        int nMinusOne = 1;
        int nMinusTwo = 0;
        for (int i = 1; i < n -1; i++) {
            int tmp = nMinusOne + nMinusTwo;
            nMinusTwo = nMinusOne;
            nMinusOne = tmp;
        }
        return nMinusOne + nMinusTwo;
    }

    public static int fiboApproximation(final int n) {
        double result = (1f / Math.sqrt(5)) * Math.pow((0.5*(1+Math.sqrt(5))), n);
        return (int)Math.round(result);
    }

}
