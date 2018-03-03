package ch.hslu.sw02;

import ch.hslu.ad.sw02.ColorFiller;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class ColorFillerTest {
    @Test
    public void test_Color_notequals() {
        // arrange
        ColorFiller.Color color1 = new ColorFiller.Color();
        ColorFiller.Color color2 = new ColorFiller.Color("-");

        // act & assert
        assertThat(color1).isNotEqualTo(color2);
    }

    @Test
    public void test_Color_equals() {
        // arrange
        ColorFiller.Color color1 = new ColorFiller.Color();
        ColorFiller.Color color2 = new ColorFiller.Color("O");

        // act & assert
        assertThat(color1).isEqualTo(color2);
    }
}
