package ch.hslu.sw03;

import ch.hslu.ad.sw03.StackDemo;
import org.junit.Test;

/**
 * Unittest for @{@link ch.hslu.ad.sw03.StackDemo}
 */
public class StackDemoTest {
    @Test
    public void test_main() {
        // only check that the method not throws exceptions
        StackDemo.main(new String[]{});
    }
}
