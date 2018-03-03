package ch.hslu.ad.sw02;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ColorFiller {
    private Color[][] field;

    public static void main(String[] args) {
        ColorFiller colorFiller = new ColorFiller(10,10);
        colorFiller.initDefaultField();
        drawExcercisePath(colorFiller);

        colorFiller.colorArea(5, 4, new Color("-"), new Color());

        System.out.println(colorFiller.toString());
    }

    public static void drawExcercisePath(ColorFiller colorFiller) {
        Color c = new Color("X");
        colorFiller.setColorOfFieldOneIndexed(2,2,c);
        colorFiller.setColorOfFieldOneIndexed(2,3,c);
        colorFiller.setColorOfFieldOneIndexed(2,4,c);
        colorFiller.setColorOfFieldOneIndexed(3,2,c);
        colorFiller.setColorOfFieldOneIndexed(3,3,c);
        colorFiller.setColorOfFieldOneIndexed(3,4,c);
        colorFiller.setColorOfFieldOneIndexed(3,5,c);
        colorFiller.setColorOfFieldOneIndexed(3,6,c);
        colorFiller.setColorOfFieldOneIndexed(3,9,c);
        colorFiller.setColorOfFieldOneIndexed(3,10,c);
        colorFiller.setColorOfFieldOneIndexed(4,2,c);
        colorFiller.setColorOfFieldOneIndexed(4,3,c);
        colorFiller.setColorOfFieldOneIndexed(4,4,c);
        colorFiller.setColorOfFieldOneIndexed(4,5,c);
        colorFiller.setColorOfFieldOneIndexed(4,6,c);
        colorFiller.setColorOfFieldOneIndexed(4,7,c);
        colorFiller.setColorOfFieldOneIndexed(4,8,c);
        colorFiller.setColorOfFieldOneIndexed(4,9,c);
        colorFiller.setColorOfFieldOneIndexed(4,10,c);
        colorFiller.setColorOfFieldOneIndexed(5,2,c);
        colorFiller.setColorOfFieldOneIndexed(5,5,c);
        colorFiller.setColorOfFieldOneIndexed(5,6,c);
        colorFiller.setColorOfFieldOneIndexed(5,7,c);
        colorFiller.setColorOfFieldOneIndexed(5,8,c);
        colorFiller.setColorOfFieldOneIndexed(5,9,c);
        colorFiller.setColorOfFieldOneIndexed(5,10,c);
        colorFiller.setColorOfFieldOneIndexed(6,2,c);
        colorFiller.setColorOfFieldOneIndexed(6,5,c);
        colorFiller.setColorOfFieldOneIndexed(7,2,c);
        colorFiller.setColorOfFieldOneIndexed(7,5,c);
        colorFiller.setColorOfFieldOneIndexed(7,6,c);
        colorFiller.setColorOfFieldOneIndexed(7,7,c);
        colorFiller.setColorOfFieldOneIndexed(7,8,c);
        colorFiller.setColorOfFieldOneIndexed(8,2,c);
        colorFiller.setColorOfFieldOneIndexed(8,8,c);
        colorFiller.setColorOfFieldOneIndexed(9,2,c);
        colorFiller.setColorOfFieldOneIndexed(9,3,c);
        colorFiller.setColorOfFieldOneIndexed(9,4,c);
        colorFiller.setColorOfFieldOneIndexed(9,5,c);
        colorFiller.setColorOfFieldOneIndexed(9,6,c);
        colorFiller.setColorOfFieldOneIndexed(9,7,c);
        colorFiller.setColorOfFieldOneIndexed(9,8,c);
    }

    /**
     * Create a new ColorFiller with a given length and width of the fild
     * @param x length of the field to create
     * @param y width of the field to create
     */
    public ColorFiller(int x, int y) {
        this.field = new Color[x][y];
    }

    public Color getColorOfField(int x, int y) {
        if (isPointInField(x, y)) {
            return this.field[x][y];
        }
        return null;
    }

    public boolean isPointInField(int x, int y) {
        if (x >= this.field.length || y >= this.field[x].length) {
            return false;
        }
        return true;
    }

    public Color[][] getField() {
        return this.field;
    }

    public void initDefaultField() {
        for (int i = 0; i < this.field.length;i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                this.field[i][j] = new Color();
            }
        }
    }

    public void colorArea(final int x,
                          final int y,
                          final Color fillColor,
                          final Color outsideColor) {
        Color actualColor = this.getColorOfField(x, y);
        if ((actualColor != null) && (!actualColor.equals(outsideColor)) && (!actualColor.equals(fillColor))) {
            setColorOfField(x, y, fillColor);
            colorArea(x + 1, y, fillColor, outsideColor);
            colorArea(x, y + 1, fillColor, outsideColor);
            colorArea(x -1, y, fillColor, outsideColor);
            colorArea(x, y -1, fillColor, outsideColor);
        }
    }

    public void setColorOfField(int x, int y, Color newColor) {
        if (isPointInField(x, y)) {
            this.field[x][y] = newColor;
        }
    }

    public void setColorOfFieldOneIndexed(int x, int y, Color newColor) {
        if (isPointInField(x - 1, y - 1)) {
            this.field[x - 1][y - 1] = newColor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.field.length;i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                sb.append(this.field[i][j] != null ? this.field[i][j].toString() : " ");
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static class Color {
        private String colorCode;

        public Color() {
            // default color code
            this.colorCode = "O";
        }

        public Color(String colorCode) {
            this.colorCode = colorCode;
        }

        public String getColorCode() {
            return colorCode;
        }

        public void setColorCode(String colorCode) {
            this.colorCode = colorCode;
        }

        @Override
        public String toString() {
            return getColorCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Color color = (Color) o;

            return new EqualsBuilder()
                    .append(colorCode, color.colorCode)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(colorCode)
                    .toHashCode();
        }
    }
}
