/**
 * Created by zvzv1919 on 2018/1/10.
 *
 */
public class Disc {
    private Color color;

    //the disc's position, from a1 to h8
    private char x; //ranges from a to h
    private int y; //ranges from 1 to 8

    public Disc(char x, int y) {
        this.x = x;
        this.y = y;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public char getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

