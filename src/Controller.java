import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by zvzv1919 on 2018/1/14.
 */
public class Controller implements Runnable{
    JFrame frame;
    Board board;
    JPanel buttonPane;
    JPanel whole;

    public Controller(){
        frame = new JFrame();
        whole = new JPanel();
        board = new Board(new GameState());
        buttonPane = new JPanel();
    }
    public void run(){
        JButton blackButton = new JButton("black");
        JButton whiteButton = new JButton("white");
        JButton restartButton = new JButton("restart");
        blackButton.addActionListener(new ColorChanger(Color.black));
        whiteButton.addActionListener(new ColorChanger(Color.white));

        buttonPane.add(blackButton);
        buttonPane.add(whiteButton);
        buttonPane.add(restartButton);
        whole.add(buttonPane);
        whole.add(board);

        board.addMouseListener(new drop());

        frame.add(whole);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    private class ColorChanger implements ActionListener{
        Color color;

        ColorChanger(Color color){
            this.color = color;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            board.getGameState().setMovePlayer(color);
        }
    }

    private class drop implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            board.clicked(x,y);
            board.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
