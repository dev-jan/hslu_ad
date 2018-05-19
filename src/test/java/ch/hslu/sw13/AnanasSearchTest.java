package ch.hslu.sw13;

import ch.hslu.ad.sw13.AnanasSearch;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unittests for @{@link ch.hslu.ad.sw13.AnanasSearch}
 */
public class AnanasSearchTest {
    @Test
    public void test_stateSearch_containsPattern() {
        // arrange
        String text = "blablaANANASblabla";

        // act
        int index = AnanasSearch.stateSearch(text);

        // assert
        assertThat(index).isEqualTo(6);
    }

    @Test
    public void test_stateSearch_notContainsPattern() {
        // arrange
        String text = "testtest";

        // act
        int index = AnanasSearch.stateSearch(text);

        // assert
        assertThat(index).isEqualTo(-1);
    }

    @Test
    public void test_stateSearch_onlyPattern() {
        // arrange
        String text = "ANANAS";

        // act
        int index = AnanasSearch.stateSearch(text);

        // assert
        assertThat(index).isEqualTo(0);
    }

    @Test
    public void test_stateSearch_lowerCaseAnanas() {
        // arrange
        String text = "blaAnanasBla";

        // act
        int index = AnanasSearch.stateSearch(text);

        // assert
        assertThat(index).isEqualTo(-1);
    }

    @Test
    public void test_stateSearch_nearHit() {
        // arrange
        String text = "ABAAAAANNANBANAAANABANANBANANABANANANBANANAANBANANAS";

        // act
        int index = AnanasSearch.stateSearch(text);

        // assert
        assertThat(index).isEqualTo(46);
    }

}
