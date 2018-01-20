import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by zvzv1919 on 2018/1/13.
 * Paints the gameboard UI
 * Processes the mouse click input
 * clicked: Called by the controller to suggest the position of the next move of player
 */
public class Board extends JPanel{
    private GameState gameState;
    private Judge judge;

    private final int DEFAULT_GRID_SIZE = 50;

    //Sets the visual size of the board
    public Dimension getPreferredSize(){
        int x = 10 * DEFAULT_GRID_SIZE;
        int y = x;
        return new Dimension(x,y);
    }

    public Board(){
        gameState = new GameState();
    }
    public void paintComponent(Graphics g) {
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

    public void clicked(int x, int y) {
        char newX = (char)(x / DEFAULT_GRID_SIZE + 'a' - 1);
        int newY = y / DEFAULT_GRID_SIZE;

        if(newX >= 'a' && newX <= 'h' && newY >= 1 && newY <= 8) {
            Disc newDisc = gameState.getAllDiscs().getDisc(newX, newY);
            //newDisc.setColor(gameState.getMovePlayer());
            judge.processNextMove(newDisc);
        }

    }

    public GameState getGameState() {
        return gameState;
    }
    public void getAJudge(){
        judge = new Judge(gameState);
        judge.setBoard(this);
        judge.setDroppables(judge.computeDroppablePoints(Color.black));
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
