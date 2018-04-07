package ch.hslu.ad.sw06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * Swing panel to show falling bubbles (bubbles created with every click)
 */
public class BubbleFallPanel extends JPanel {
    private List<Bubble> bubbles = new LinkedList<>();
    final BubbleFallPanel panel;

    public BubbleFallPanel() {
        panel = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                addBubble(Bubble.createRandomBubble(e.getX(), e.getY()));
            }
        });


        Timer t = new Timer(40, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.repaint();
            }
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Bubble bubble : bubbles) {
            if (bubble.isLiving()) {
                g.setColor(bubble.getColor());
                g.fillOval(bubble.getPositionX(), bubble.getPositionY(), bubble.getSize(), bubble.getSize());
            }
        }
    }

    /**
     * Add a new falling bubble to the GUI
     * @param bubble the bubble to add
     */
    private void addBubble(final Bubble bubble) {
        bubbles.add(bubble);
        System.out.println("Bubble added: " + bubble);
        new Thread(() -> {
            while (bubble.isLiving()) {
                bubble.nextPosition(panel.getHeight());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
        }).start();
    }

}
