package ch.hslu.ad.sw13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Search for texts with the famous KMP algorithm.
 */
public class KmpSearch {
    private static final Logger LOG = LogManager.getLogger(KmpSearch.class);
    private final static int NOT_FOUND = -1;

    /**
     * Search for a given pattern in a given text.
     * @param text the text to search in
     * @param searchFor the text to search for
     * @return first index of the searchFor in the text or -1 if the pattern was not found
     */
    public static int search(final String text, final String searchFor) {
        final int n = text.length();
        final int m = searchFor.length();
        int i = 0;
        int j = 0;

        int[] next = initNext(searchFor);
        LOG.debug("Search for " + searchFor + " with nextArray: " + Arrays.toString(next));
        do {
            if ((j == -1) || (text.charAt(i) == searchFor.charAt(j))) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        } while ((j < m) && (i < n));

        if (j == m) {
            return i - m;
        }
        return NOT_FOUND;
    }

    /**
     * Create a pattern for searching with the KMP search
     * @param searchtext the string to search for
     * @return the search pattern used for the KMP search
     */
    private static int[] initNext(final String searchtext) {
        final int m = searchtext.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        do {
            if ((j == -1) || (searchtext.charAt(i) == searchtext.charAt(j))) {
                i++;
                j++;
                next[i] = j;
            }
            else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }
}
