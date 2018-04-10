package ch.hslu.ad.sw08.primenumber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/**
 * Generate some random big numbers and check if the numbers are prime. All calls are done in a single thread.
 */
public class SequentialPrimenumberGenerator {
    private static final Logger LOG = LogManager.getLogger(SequentialPrimenumberGenerator.class);

    public void generatePrimes(int numberOfPrimes, File outputFile) throws IOException {
        for (int n = 1;n <= numberOfPrimes;) {
            BigInteger number = new BigInteger(1024, new Random());
            if (number.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info("#" + n + " Prime found: " + number.toString());
                writePrimeToFile(outputFile, number);
                n++;
            }
        }
    }

    private void writePrimeToFile(File outputFile, BigInteger number) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
        writer.write(number.toString());
        writer.newLine();
        writer.flush();
    }
}
