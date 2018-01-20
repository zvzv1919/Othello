import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by zvzv1919 on 2018/1/16.
 */
public class Game implements Runnable {
    private Board board;
    private GameState mainGame;
    private ArrayList<GameState> history;

    public Game(Board board){
        this.board = board;
        board.setGameState(new GameState());
        history = new ArrayList<>();
    }
    @Override
    public void run() {
        board.getAJudge();
        board.addMouseListener(new Drop());
        mainGame = board.getGameState();
        history.add(mainGame);
        board.repaint();
    }

    class Drop implements MouseListener {
        boolean isActive;

        public Drop(){
            isActive = true;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(isActive) {
                int x = e.getX();
                int y = e.getY();
                board.clicked(x, y);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
