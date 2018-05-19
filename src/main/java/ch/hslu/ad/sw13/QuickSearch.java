package ch.hslu.ad.sw13;

import java.util.*;

/**
 * Search for texts with the quicksearch algorithm.
 */
public class QuickSearch {
    private final static int NOT_FOUND = -1;

    /**
     * Search for a given text in a given text
     * @param text text to search in
     * @param searchFor text to search for
     * @return the first index of the found text or -1 if the text was not found
     */
    public static int quickSearch(final String text, final String searchFor) {
        final int n = text.length();
        final int m = searchFor.length();
        final int range = 256; // ASCII range - ignore UTF-8 for now...
        final int[] shift = new int[range];

        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        for (int i = 0; i < m; i++) {
            shift[searchFor.charAt(i)] = m - i;
        }

        int i = 0;
        int j = 0;
        do {
            if (text.charAt(i + j) == searchFor.charAt(j)) {
                j++;
            }
            else {
                if ((i + m) < n) {
                    i += shift[text.charAt(i + m)];
                    j = 0;
                }
                else {
                    break;
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i;
        }
        else {
            return NOT_FOUND;
        }
    }

    /**
     * Use optimal dismatch with quicksearch
     * @param text text to search in
     * @param searchFor text to search for
     * @return first index of the found text or -1 if the text was not found
     */
    public static int quickSearchOptimalDismatch(final String text, final String searchFor) {
        final int n = text.length();
        final int m = searchFor.length();

        Set<Character> alphabetSet = determineAlphabet(text);
        Character[] alphabet = alphabetSet.toArray(new Character[alphabetSet.size()]);
        char first = alphabet[0];
        char last = alphabet[alphabet.length - 1];
        Map<Character, Integer> shift = buildShiftMap(first, last, searchFor);

        // search
        int i = 0;
        int j = 0;
        do {
            if (text.charAt(i + j) == searchFor.charAt(j)) {
                j++;
            } else {
                if (i + m < n) {
                    i += shift.get(text.charAt(i + m));
                    j = 0;
                } else {
                    break;
                }
            }
        } while (j < m && i + m <= n);

        if (j == m) {
            return i; // pattern found, starting at i
        } else {
            return NOT_FOUND;
        }
    }


    private static Set<Character> determineAlphabet(String text) {
        if (text == null || text.length() == 0) {
            return Collections.emptySet();
        }

        Set<Character> alphabet = new TreeSet<>();
        for (char c : text.toCharArray()) {
            alphabet.add(c);
        }
        return alphabet;
    }

    private static Map<Character, Integer> buildShiftMap(char from, char to, String searchFor) {
        if (from >= to) {
            return Collections.emptyMap();
        }

        Map<Character, Integer> shiftMap = new TreeMap<>();
        int m = searchFor.length();
        for (char c = from; c <= to; c++) {
            shiftMap.put(c, m);
        }
        for (int i = 0; i < m; i++) {
            shiftMap.put(searchFor.charAt(i), m - i);
        }
        return shiftMap;
    }
}
