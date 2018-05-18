package ch.hslu.sw13;

import ch.hslu.ad.sw13.KmpSearch;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unittests for @{@link ch.hslu.ad.sw13.KmpSearch}
 */
public class KmpSearchTest {
    @Test
    public void test_search_containsPattern() {
        // arrange
        String text = "blablaabcblabla";
        String searchFor = "abc";

        // act
        int index = KmpSearch.search(text, searchFor);

        // assert
        assertThat(index).isEqualTo(6);
    }

    @Test
    public void test_search_notContainsPattern() {
        // arrange
        String text = "blablaabbccblabla";
        String searchFor = "abc";

        // act
        int index = KmpSearch.search(text, searchFor);

        // assert
        assertThat(index).isEqualTo(-1);
    }

    @Test
    public void test_search_onlyPattern() {
        // arrange
        String text = "abc";
        String searchFor = "abc";

        // act
        int index = KmpSearch.search(text, searchFor);

        // assert
        assertThat(index).isEqualTo(0);
    }

    @Test
    public void test_search_nearHit() {
        // arrange
        String text = "axaaxabxabbxabababxaaaaaaabbbbbbb";
        String searchFor = "abc";

        // act
        int index = KmpSearch.search(text, searchFor);

        // assert
        assertThat(index).isEqualTo(-1);
    }

    @Test
    public void test_search_Ananas() {
        // arrange
        String text = "ANblablaANANASbla";
        String searchFor = "ANANAS";

        // act
        int index = KmpSearch.search(text, searchFor);

        // assert
        assertThat(index).isEqualTo(8);
    }

}
