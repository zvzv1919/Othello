import javax.swing.*;

/**
 * Created by zx on 2018/1/15.
 * findNextPlayer: returns the next player to move, according to the standard Othello rules (SOR), returning none means gameover.
 * computeDroppablePoints: returns the set of points that is legal for the passed-in player to drop his disc.
 *      Returning null means there's no possible moves.
 * processNextMove: Does nothing if the player clicked the wrong position.
 *      Refreshes the main gamestate and repaints the board otherwise.
 * endGame: Ends the current game.
 * flippedDiscs: returns the set of the discs to be flipped when the specified disc is set
 */
public class Judge {
    private GameState gameState;
    private GroupofDisc droppables;
    private Board board;

    public Judge(GameState gameState){
        this.gameState = gameState;
    }

    public Color findNextPlayer(){
        Color currentPlayer = gameState.getMovePlayer();
        Color newPlayer = currentPlayer == Color.white ? Color.black : Color.white;
        GroupofDisc newDroppables;
        newDroppables = computeDroppablePoints(newPlayer);
        if(newDroppables != null){
            return newPlayer;
        }
        else{
            newPlayer = currentPlayer;
            newDroppables = computeDroppablePoints(newPlayer);
            if(newDroppables != null){
                return newPlayer;
            }
            else {
                return Color.none;
            }
        }
    }

    public GroupofDisc computeDroppablePoints(Color player){
        GroupofDisc legalDrops = new GroupofDisc();

        //TODO:OPTIMIZE: search through unoccupied points instead of all points
        for (Disc disc: gameState.getAllDiscs().getList()) {
            Disc copy = new Disc(disc.getX(),disc.getY());
            copy.setColor(player);
            if(disc.getColor() == Color.none && flippedDiscs(copy)!= null){
                legalDrops.getList().add(disc);
            }
        }
        if(legalDrops.getList().size() == 0){
            return null;
        }
        else{
            return legalDrops;
        }
    }

    public synchronized void processNextMove(Disc disc){
        if(droppables.getDisc(disc.getX(), disc.getY()) == null){
            return;
        }
        disc.setColor(gameState.getMovePlayer());
        GroupofDisc flippedDiscs = flippedDiscs(disc);
        flippedDiscs.setColor(gameState.getMovePlayer());
        board.repaint();

        Color newPlayer = findNextPlayer();
        if(newPlayer == Color.none){
            endGame();
            //TODO:missing return
        }
        else {
            gameState.setMovePlayer(newPlayer);
            droppables = computeDroppablePoints(newPlayer);
        }
    }
    public void endGame(){
        System.out.println("Gameover");
    }

    public GroupofDisc flippedDiscs(Disc disc) {
        GroupofDisc flippedDiscs = new GroupofDisc();
        for(char x = (char)(disc.getX() - 1); x <= (char)(disc.getX() + 1); x++){
            if(x < 'a' || x > 'h'){
                continue;
            }
            else {
                for (int y = disc.getY() - 1; y <= disc.getY() + 1; y++) {
                    if(y >= 1 && y <= 8){ //the disc here is on the board
                        Disc intact = gameState.getAllDiscs().getDisc(x,y);
                        if(intact.getColor() == Color.none || intact.getColor() == disc.getColor()){
                            continue;
                        }
                        else {
                            //the disc here has the different color from the central disc
                            GroupofDisc group = checkDirection(disc, intact);
                            flippedDiscs.absorb(group);
                        }
                    }
                }
            }
        }
        if(flippedDiscs.getList().size() == 0){
            return null;
        }
        return flippedDiscs;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    private GroupofDisc checkDirection(Disc central, Disc intact){
        int directionX = intact.getX() - central.getX();
        int directionY = intact.getY() - central.getY();
        //Start to check the discs from the first one on the extended line drawn from the central disc to the intact disc
        char startX = (char)(intact.getX() + directionX);
        int startY = intact.getY() + directionY;
        char endX = 0;
        int endY = 0;
        char x = startX;
        int y = startY;
        GroupofDisc groupofDisc = new GroupofDisc();
        while(gameState.getAllDiscs().getDisc(x,y) != null){//check if the checkee is still on the board
            Disc checkee = gameState.getAllDiscs().getDisc(x,y);
            if(checkee.getColor() == intact.getColor()){
                x+= directionX;
                y+= directionY;
            }
            else if(checkee.getColor() == Color.none){
                break;
            }
            else{//that is to say, checkee.getColor == central.getColor, the successful case
                endX = (char)(x - directionX);
                endY = y - directionY;
                break;
            }
        }
        if(endX == 0){
            return null;
        }

        x = (char)(startX-2 * directionX);
        y = startY-2 * directionY;  //starts to add in to the list from 'intact'(that is , startX - directionX, startY - directionY)
        do{
            x += directionX;
            y += directionY;
            Disc disc = gameState.getAllDiscs().getDisc(x,y);
            groupofDisc.getList().add(disc);
            //System.out.println(x + " " + y); //For testing purposes
        }while (x != endX || y != endY);

        return groupofDisc;
    }
    public void setDroppables(GroupofDisc droppables) {
        this.droppables = droppables;
    }
}
