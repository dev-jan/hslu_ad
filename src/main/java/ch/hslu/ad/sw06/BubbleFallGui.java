package ch.hslu.ad.sw06;

import javax.swing.*;

/**
 * Swing GUI starter for the falling bubbles
 */
public class BubbleFallGui {
    public static void main(String[] args) {
        // create new window frame (the GUI frame itself)
        JFrame windowFrame = new JFrame("AD - Falling bubbles :)");

        // add bubble fall panel to the window
        windowFrame.getContentPane().add(new BubbleFallPanel());

        // exit the program if the window get closed
        windowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set default size of the window, otherwise its very small
        windowFrame.setSize(600, 400);

        // show the window to the user
        windowFrame.setVisible(true);
    }

}
