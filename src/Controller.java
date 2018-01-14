import javax.swing.*;

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

        buttonPane.add(blackButton);
        buttonPane.add(whiteButton);
        buttonPane.add(restartButton);
        whole.add(buttonPane);
        whole.add(board);

        frame.add(whole);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
