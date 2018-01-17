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
    JButton whiteButton;

    public Controller(){
        frame = new JFrame();
        whole = new JPanel();
        board = new Board(new GameState());
        buttonPane = new JPanel();
    }
    public void run(){
        JButton blackButton = new JButton("black");
        whiteButton = new JButton("white");
        JButton restartButton = new JButton("restart");
        blackButton.addActionListener(new ColorChanger(Color.black, this));
        //whiteButton.addActionListener(new ColorChanger(Color.white));

        buttonPane.add(blackButton);
        buttonPane.add(whiteButton);
        buttonPane.add(restartButton);
        whole.add(buttonPane);
        whole.add(board);


        frame.add(whole);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        game = new Game(board);
        game.run();

        frame.setVisible(true);
    }

    private class ColorChanger implements ActionListener{
        Controller controller;
        Color color;
        int x = 0;

        ColorChanger(Color color, Controller controller){
            this.color = color;
            this.controller = controller;
        }
        ColorChanger(Color color){
            this.color = color;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(color == Color.white) {
                System.out.println("haha");
            }
            if(color == Color.black){
                if(x++ % 2 == 0) {
                    //controller.whiteButton.addActionListener(new ColorChanger(Color.white));
                    /*controller.buttonPane.remove(whiteButton);
                    buttonPane.repaint();
                    buttonPane.updateUI();*/
                }
                else{
                    /*controller.buttonPane.add(whiteButton);
                    buttonPane.repaint();
                    buttonPane.updateUI();*/
                }
            }
        }
    }


}
