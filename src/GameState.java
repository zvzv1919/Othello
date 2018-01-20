/**
 * Created by zvzv1919 on 2018/1/14.
 * equals: True if allDiscs and movePlayer are the same.
 * copy: copies allDiscs, whiteDiscs, blackDiscs and droppables.
 * updateColorSets: update 'whiteDiscs' and 'blackDiscs'.
 */
public class GameState {
    private GroupofDisc whiteDiscs;
    private GroupofDisc blackDiscs;
    private GroupofDisc droppables;
    private GroupofDisc allDiscs;
    private PlayerColor movePlayer; //the player who should take the current turn to move

    private static final int BLANK_GAMESTATE = 0;

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
        whiteDiscs.setColor(PlayerColor.white);
        blackDiscs.setColor(PlayerColor.black);
        movePlayer = PlayerColor.black;
    }

    public GameState(int option){
        allDiscs = new GroupofDisc();
        whiteDiscs = new GroupofDisc();
        droppables = new GroupofDisc();
        if(option == BLANK_GAMESTATE){
            //Does nothing
        }
    }

    public GroupofDisc getAllDiscs() {
        return allDiscs;
    }

    public PlayerColor getMovePlayer() {
        return movePlayer;
    }

    public void setMovePlayer(PlayerColor movePlayer) {
        this.movePlayer = movePlayer;
    }

    public boolean equals(Object o){
        if(!(o instanceof GameState)){
            return super.equals(o);
        }
        GameState operand = (GameState) o;
        if(this.equals(operand.allDiscs) && this.movePlayer == operand.movePlayer){
            return true;
        }
        return false;
    }

    public GroupofDisc getDroppables() {
        return droppables;
    }

    public void setDroppables(GroupofDisc droppables) {
        this.droppables = droppables;
    }

    public void updateColorSets(){
        whiteDiscs = new GroupofDisc();
        blackDiscs = new GroupofDisc();
        for (Disc disc: allDiscs.getList()) {

            if(disc.getPlayerColor() == PlayerColor.white){
                whiteDiscs.addDisc(disc);
            }
            if(disc.getPlayerColor() == PlayerColor.black){
                blackDiscs.addDisc(disc);
            }
        }
    }

    public static GameState copy(GameState gameState){
        GameState newGameState = new GameState(BLANK_GAMESTATE);
        newGameState.droppables = GroupofDisc.copy(gameState.droppables);
        newGameState.whiteDiscs = GroupofDisc.copy(gameState.whiteDiscs);
        newGameState.blackDiscs = GroupofDisc.copy(gameState.blackDiscs);
        newGameState.allDiscs = GroupofDisc.copy(gameState.allDiscs);
        newGameState.movePlayer = gameState.movePlayer;
        return newGameState;
    }

    public void changeInto(GameState gameState){
        droppables = GroupofDisc.copy(gameState.droppables);
        whiteDiscs = GroupofDisc.copy(gameState.whiteDiscs);
        blackDiscs = GroupofDisc.copy(gameState.blackDiscs);
        allDiscs = GroupofDisc.copy(gameState.allDiscs);
        movePlayer = gameState.movePlayer;
    }

    public GroupofDisc getBlackDiscs() {
        return blackDiscs;
    }

    public GroupofDisc getWhiteDiscs() {
        return whiteDiscs;
    }
}
