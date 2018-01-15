/**
 * Created by zx on 2018/1/15.
 *
 */
public class Judge {
    GameState gameState;
    GroupofDisc Droppables;

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
        return null;
    }
    public void processNextMove(Disc disc){

    }
    public void endGame(){
    }
}
