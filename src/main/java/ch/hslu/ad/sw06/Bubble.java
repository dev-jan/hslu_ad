package ch.hslu.ad.sw06;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.awt.*;

/**
 * Represents a bubble in the GUI
 */
public class Bubble {
    private static final int ALPHA_SPEED = 30;

    private int positionX;
    private int positionY;
    private int size;
    private int speed;
    private Color color;

    private boolean isMoving = true;
    private boolean isLiving = true;

    /**
     * Create a new bubble with random values at the given position
     * @param positionX X position
     * @param positionY Y position
     * @return the created bubble
     */
    public static Bubble createRandomBubble(int positionX, int positionY) {
        Bubble b = new Bubble();
        b.setPositionX(positionX);
        b.setPositionY(positionY);
        b.setSize(RandomHelper.nextRandom(20, 50));
        b.setSpeed(RandomHelper.nextRandom(5, 15));
        b.setColor(RandomHelper.nextRandomColor());
        return b;
    }

    /**
     * Calculate the next position of the bubble and make the change
     */
    public void nextPosition(int maxY) {
        if (maxY - (size) < positionY) {
            this.isMoving = false;
        }
        if (this.isMoving) {
            this.positionY = this.positionY + speed;
        }
        else {
            if (this.color.getAlpha() < ALPHA_SPEED) {
                this.setLiving(false);
            }
            if (this.isLiving) {
                this.color = new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), this.color.getAlpha() - ALPHA_SPEED);
            }
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("positionX", positionX)
                .append("positionY", positionY)
                .append("size", size)
                .append("speed", speed)
                .append("color", color)
                .toString();
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isLiving() {
        return isLiving;
    }

    public void setLiving(boolean living) {
        isLiving = living;
    }
}
