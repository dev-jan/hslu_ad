package ch.hslu.ad.sw02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Task class for excercise 2
 */
public class Task {
    private static final Logger LOG = LogManager.getLogger(Task.class);

    private static int runs = 0;

    public static void main(String[] args) throws InterruptedException {
        long starttime = System.currentTimeMillis();
        task(10);
        long endtime = System.currentTimeMillis();
        LOG.warn("RUNS: " + runs);
        LOG.warn("Duration: " + (endtime - starttime) / 1000f + " sec");
    }

    public static void task(final int n) throws InterruptedException {
        task1();task1();task1();task1();
        for (int i = 0; i < n; i++) {
            task2();task2();task2();
            for (int j = 0; j < n; j++) {
                task3();task3();
            }
        }
    }

    public static void task1() throws InterruptedException {
        LOG.info("task1()");
        runs++;
        Thread.sleep(5);
    }

    public static void task2() throws InterruptedException {
        LOG.info("task2()");
        runs++;
        Thread.sleep(5);
    }

    public static void task3() throws InterruptedException {
        LOG.info("task3()");
        runs++;
        Thread.sleep(5);
    }
}
