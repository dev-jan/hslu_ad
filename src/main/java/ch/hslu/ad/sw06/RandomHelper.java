package ch.hslu.ad.sw06;

import java.awt.*;

/**
 * Helper for random values used by the bubble GUI
 */
public class RandomHelper {
    private static final int COLOR_MIN = 0;
    private static final int COLOR_MAX = 255;

    /**
     * All methods are static, so the instantiation is not necessary
     */
    private RandomHelper() {}

    /**
     * Create a new random number between the given min/max value
     * @param min minimum value
     * @param max maximum value
     * @return the random number
     */
    public static int nextRandom(int min, int max) {
        return (int)(Math.random() * max + min);
    }

    /**
     * Create a new random color
     * @return the random color
     */
    public static Color nextRandomColor() {
        return new Color(nextRandom(COLOR_MIN, COLOR_MAX), nextRandom(COLOR_MIN, COLOR_MAX), nextRandom(COLOR_MIN, COLOR_MAX));
    }
}
