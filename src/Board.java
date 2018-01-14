import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by zvzv1919 on 2018/1/13.
 *
 */
public class Board extends JPanel{
    private GameState gameState;
    private final int DEFAULT_GRID_SIZE = 30;

    public Board(GameState gameState) {
        this.gameState = gameState;
    }

    //Sets the visual size of the board
    public Dimension getPreferredSize(){
        int x = 10 * DEFAULT_GRID_SIZE;
        int y = x;
        return new Dimension(x,y);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Draw the game board
        for(int i = 1; i <= 9; i++) {
            g.drawLine(DEFAULT_GRID_SIZE, i * DEFAULT_GRID_SIZE,
                    9 * DEFAULT_GRID_SIZE, i * DEFAULT_GRID_SIZE);
            g.drawLine(i * DEFAULT_GRID_SIZE, DEFAULT_GRID_SIZE,
                    i * DEFAULT_GRID_SIZE, 9 * DEFAULT_GRID_SIZE);
        }


        //Draw the discs
        for (Disc disc: gameState.getAllDiscs().getList()) {
            //assert (disc!= null);
            switch (disc.getColor()){
                case none:{
                    break;
                }
                case black:{
                    g.fillOval((1 + (disc.getX() - 'a')) * DEFAULT_GRID_SIZE + DEFAULT_GRID_SIZE/4,
                            (1 + (disc.getY() - 1)) * DEFAULT_GRID_SIZE + DEFAULT_GRID_SIZE/4,
                            (DEFAULT_GRID_SIZE / 2),
                            (DEFAULT_GRID_SIZE / 2));
                    break;
                }
                case white:{
                    g.drawOval((1 + (disc.getX() - 'a')) * DEFAULT_GRID_SIZE + DEFAULT_GRID_SIZE/4,
                            (1 + (disc.getY() - 1)) * DEFAULT_GRID_SIZE + DEFAULT_GRID_SIZE/4,
                            (DEFAULT_GRID_SIZE / 2),
                            (DEFAULT_GRID_SIZE / 2));
                    break;
                }
            }
        }

    }

    public void clicked(int x, int y){
        char newX = (char)(x / 30 + 'a' - 1);
        int newY = y / 30;

        //inspect newX and newY
        //TODO


        Disc newDisc = gameState.getAllDiscs().getDisc(newX, newY);
        newDisc.setColor(gameState.getMovePlayer());

    }

    public GameState getGameState() {
        return gameState;
    }
}
