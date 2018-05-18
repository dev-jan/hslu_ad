package ch.hslu.ad.sw13;

/**
 * This class represents a simple searcher for the word "ANANAS".
 */
public class AnanasSearch {
    public static final int NOT_FOUND = -1;
    public static final String ANANAS = "ANANAS";

    /**
     * Return the first index of the word ANANAS in the given text.
     * @param text the text to search for ANANAS
     * @return the first index of ANANAS (the first A) or -1 if the text not contain ANANAS
     */
    public static int stateSearch(final String text) {
        int index = 0;
        String state = "";
        while ((!state.equals(ANANAS)) && (index < text.length())) {
            switch (state) {
                case "":
                    if (text.charAt(index) == 'A') {
                        state = "A";
                    }
                    break;
                case "A":
                    if (text.charAt(index) == 'N') {
                        state = "AN";
                    }
                    else if (text.charAt(index) != 'A') {
                        state = "";
                    }
                    break;
                case "AN":
                    if (text.charAt(index) == 'A') {
                        state = "ANA";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "ANA":
                    if (text.charAt(index) == 'N') {
                        state = "ANAN";
                    }
                    else if (text.charAt(index) == 'A') {
                        state = "A";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "ANAN":
                    if (text.charAt(index) == 'A') {
                        state = "ANANA";
                    }
                    else {
                        state = "";
                    }
                    break;
                case "ANANA": {
                    if (text.charAt(index) == 'S') {
                        state = ANANAS;
                    }
                    else if (text.charAt(index) == 'A') {
                        state = "A";
                    }
                    else if (text.charAt(index) == 'N') {
                        state = "ANAN";
                    }
                    else {
                        state = "";
                    }
                    break;
                }
            }
            index++;
        }
        if (state.equals(ANANAS)) {
            return index - ANANAS.length();
        }
        return NOT_FOUND;
    }
}
