package ch.hslu.sw13;

import ch.hslu.ad.sw13.QuickSearch;
import com.google.common.io.CharStreams;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unittest for @{@link QuickSearch}
 */
public class QuickSearchTest {
    @Test
    public void test_quickSearch_bigFile() throws IOException {
        // arrange
        String text = CharStreams.toString(new InputStreamReader(QuickSearchTest.class.getResourceAsStream("/bigTextFile.txt")));
        String searchFor = "NEEDLE_TO_SEARCH";

        // act
        int index = QuickSearch.quickSearch(text, searchFor);

        // assert
        assertThat(index).isEqualTo(103589);
    }

    @Test
    public void test_quickSearchOptimalDismatch_bigFIle() throws IOException {
        // arrange
        String text = CharStreams.toString(new InputStreamReader(QuickSearchTest.class.getResourceAsStream("/bigTextFile.txt")));
        String searchFor = "NEEDLE_TO_SEARCH";

        // act
        int index = QuickSearch.quickSearchOptimalDismatch(text, searchFor);

        // assert
        assertThat(index).isEqualTo(103589);
    }

}
