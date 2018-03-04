package ch.hslu.sw02;

import ch.hslu.ad.sw02.Task;
import org.junit.Test;

/**
 * Unittest for @{@link ch.hslu.ad.sw02.Task}
 */
public class TaskTest {
    @Test
    public void test_main() throws InterruptedException {
        // only check that the main method run without exceptions
        Task.main(new String[]{});
    }

}
