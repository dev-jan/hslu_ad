package ch.hslu.sw08;

import ch.hslu.ad.sw08.primenumber.ParallelPrimenumberGenerator;
import ch.hslu.ad.sw08.primenumber.SequentialPrimenumberGenerator;
import org.apache.commons.lang.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumberTest {
    private static final Logger LOG = LogManager.getLogger(PrimeNumberTest.class);

    @Test
    public void test_sequentialPrimenumberGenerator() throws IOException {
        StopWatch sw = new StopWatch();
        sw.start();
        // arrange
        int i = 10;
        SequentialPrimenumberGenerator generator = new SequentialPrimenumberGenerator();
        File outputFile = File.createTempFile("test_sequentialPrimes", ".txt");

        // act
        generator.generatePrimes(i, outputFile);
        sw.stop();
        LOG.info("Time: " + sw.getTime());
        LOG.info("Outputfile: " + outputFile.getAbsolutePath());

        // assert
        assertThat(outputFile.exists()).isTrue();
        BufferedReader br = new BufferedReader(new FileReader(outputFile));
        int numberOfLines = 0;
        while ((br.readLine()) != null) {
            numberOfLines++;
        }
        assertThat(numberOfLines).isEqualTo(i);
    }

    @Test
    public void test_parallelPrimenumberGenerator() throws IOException, InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        // arrange
        int i = 10;
        ParallelPrimenumberGenerator generator = new ParallelPrimenumberGenerator();
        File outputFile = File.createTempFile("test_parallelPrimes", ".txt");

        // act
        generator.generatePrimes(i, outputFile);
        sw.stop();
        LOG.info("Time: " + sw.getTime());
        LOG.info("Outputfile: " + outputFile.getAbsolutePath());

        // assert
        assertThat(outputFile.exists()).isTrue();
        BufferedReader br = new BufferedReader(new FileReader(outputFile));
        int numberOfLines = 0;
        while ((br.readLine()) != null) {
            numberOfLines++;
        }
        assertThat(numberOfLines).isEqualTo(i);
    }

}
