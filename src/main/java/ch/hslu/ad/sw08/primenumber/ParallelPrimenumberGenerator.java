package ch.hslu.ad.sw08.primenumber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generate some random big numbers and check if the numbers are prime. The generation is done multithreaded.
 */
public class ParallelPrimenumberGenerator {
    private static final Logger LOG = LogManager.getLogger(ParallelPrimenumberGenerator.class);
    private static final int NUMBER_OF_THREADS = 10;

    /**
     * Generate a given number of very big prime numbers and write it to the given file.
     * @param numberOfPrimes number of prime numbers to generate
     * @param outputFile the output file to put the numbers in
     * @throws IOException
     * @throws InterruptedException
     */
    public void generatePrimes(int numberOfPrimes, File outputFile) throws IOException, InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        final AtomicInteger counter = new AtomicInteger(numberOfPrimes);
        final BlockingQueue<BigInteger> outputQueue = new LinkedBlockingDeque<>();

        for (int i = 0;i < NUMBER_OF_THREADS;i++) {
            LOG.debug("Start thread #" + i);
            executor.execute(() -> {
                int c;
                while ((c = counter.getAndDecrement()) > 0) {
                    boolean threadFoundPrime = false;
                    while (!threadFoundPrime) {
                        BigInteger number = new BigInteger(1024, new Random());
                        if (number.isProbablePrime(Integer.MAX_VALUE)) {
                            LOG.info("#" + c + " Prime found: " + number.toString());
                            outputQueue.add(number);
                            threadFoundPrime = true;
                        }
                    }
                }
            });
        }

        executor.execute(() -> {
            AtomicInteger outputCounter = new AtomicInteger(numberOfPrimes);
            while (outputCounter.getAndDecrement() > 0) {
                try {
                    BigInteger number = outputQueue.take();
                    writePrimeToFile(outputFile, number);
                } catch (InterruptedException e) {
                    LOG.error("File output interrupted!", e);
                } catch (IOException e) {
                    LOG.error("IO Exception :(", e);
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.SECONDS);
    }

    private void writePrimeToFile(File outputFile, BigInteger number) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
        writer.write(number.toString());
        writer.newLine();
        writer.flush();
    }

}
