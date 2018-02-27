package ch.hslu.ad.sw02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static final Logger LOG = LogManager.getLogger(Task.class);
    private static Map<Integer, Integer> cache = new HashMap<>();

    /**
     * Performance measurement of the different implementations
     * @param args
     */
    public static void main(String[] args) {
        int n = 45;
        LOG.info("Performance test of fibonacci index " + n);

        long starttime2 = System.currentTimeMillis();
        System.out.println(fiboRec2(n));
        long endtime2 = System.currentTimeMillis();
        LOG.warn("Duration fiboRec2: " + (endtime2 - starttime2) / 1000f  + " sec");

        long starttime = System.currentTimeMillis();
        System.out.println(fiboRec1(n));
        long endtime = System.currentTimeMillis();
        LOG.warn("Duration fiboRec1: " + (endtime - starttime) / 1000f  + " sec");

        long starttime3 = System.currentTimeMillis();
        System.out.println(fiboIter(n));
        long endtime3 = System.currentTimeMillis();
        LOG.warn("Duration fiboIter: " + (endtime3 - starttime3) / 1000f  + " sec");

    }

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

}
