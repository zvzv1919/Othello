/**
 * Created by zvzv1919 on 2018/1/14.
 */
public class GameState {
    private GroupofDisc whiteDiscs;
    private GroupofDisc blackDiscs;
    private final GroupofDisc allDiscs;
    private Color movePlayer; //the player who should take the current turn to move

    public GameState(){
        //Create discs from a1 to h8 and add them to 'allDiscs'
        allDiscs = new GroupofDisc();
        for(char x = 'a'; x <= 'h'; x++) {
            for(int y = 1; y <= 8; y++){
                allDiscs.addDisc(new Disc(x, y));
            }
        }

        //assign colors for the 4 initial discs at the central of the board
        whiteDiscs = new GroupofDisc();
        whiteDiscs.addDisc(allDiscs.getDisc('d',4));
        whiteDiscs.addDisc(allDiscs.getDisc('e',5));
        blackDiscs = new GroupofDisc();
        blackDiscs.addDisc(allDiscs.getDisc('d',5));
        blackDiscs.addDisc(allDiscs.getDisc('e',4));
        whiteDiscs.setColor(Color.white);
        blackDiscs.setColor(Color.black);
        movePlayer = Color.black;
    }
    public GroupofDisc getAllDiscs() {
        return allDiscs;
    }

    public Color getMovePlayer() {
        return movePlayer;
    }

    public void setMovePlayer(Color movePlayer) {
        this.movePlayer = movePlayer;
    }
}
