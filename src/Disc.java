/**
 * Created by zvzv1919 on 2018/1/10.
 *
 */
public class Disc {
    private PlayerColor playerColor;

    //the disc's position, from a1 to h8
    private char x; //ranges from a to h
    private int y; //ranges from 1 to 8

    public Disc(char x, int y) {
        this.x = x;
        this.y = y;
        playerColor = PlayerColor.none;
    }
    public PlayerColor getPlayerColor() {
        return playerColor;
    }
    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }
    public char getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

