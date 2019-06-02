import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

/**
 * Created by zvzv1919 on 2018/1/16.
 */
public class Game implements Runnable {
    private Board board;
    private GameState mainGame;
    private Stack<GameState> history;
    private Judge judge;

    public Game(Board board){
        this.board = board;
        mainGame = new GameState();
        board.setGameState(mainGame);
        history = new Stack<>();
        board.setGame(this);
    }
    @Override
    public void run() {
        getAJudge();
        board.addMouseListener(new Drop());
        history.add(mainGame);
        board.repaint();
    }

    public void undo(){
        if(!history.empty()) {
            mainGame.changeInto(history.pop());
            mainGame.setDroppables(judge.computeDroppablePoints(mainGame.getMovePlayer()));
            board.repaint();
        }
    }

    public void record(){
        history.push(GameState.copy(mainGame));
    }

    public void getAJudge(){
        judge = new Judge(mainGame);
        judge.setBoard(board);
        mainGame.setDroppables(judge.computeDroppablePoints(PlayerColor.black));
        judge.setGame(this);
    }

    class Drop implements MouseListener {
//        boolean isActive;
//
//        public Drop(){
//            isActive = true;
//        }
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            if(isActive) {
//
//            }
            int x = e.getX();
            int y = e.getY();
            board.clicked(x, y);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public Judge getJudge() {
        return judge;
    }
}
