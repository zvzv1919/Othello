import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by zvzv1919 on 2018/1/14.
 *
 */
public class Controller implements Runnable{
    JFrame frame;
    Board board;
    JPanel buttonPane;
    JPanel whole;
    Game game;

    JButton restartButton;
    JButton undoButton;

    public Controller(){
        frame = new JFrame();
        whole = new JPanel();
        buttonPane = new JPanel();
    }
    public void run(){
        restartButton = new JButton("新游戏");
        undoButton = new JButton("悔棋");
        restartButton.addActionListener(e ->  {
                startNewGame();
        });
        undoButton.addActionListener(e -> {game.undo();});

        buttonPane.add(restartButton);
        buttonPane.add(undoButton);
        whole.add(buttonPane);

        board = new Board();
        whole.add(board);

        frame.add(whole);
        frame.pack();
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        whole.updateUI();
        startNewGame();

        frame.setVisible(true);
    }

    public void startNewGame(){
        game = new Game(board);
        game.run();
    }
}
