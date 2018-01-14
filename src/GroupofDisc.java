import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zvzv1919 on 2018/1/10.
 *
 */


//a set of disc that can be flipped together, for convenient purpose;
//can also be searched.
//setColor: set the color of the whole group of discs to what is passed in(calls 'disc.setColor(color)'.
//getDisc: returns the disc of the specified coordinates, null if there !exists such a disc in the groupofDisc

public class GroupofDisc {
    private ArrayList<Disc> list;

    public GroupofDisc() {
        list = new ArrayList<>();
    }

    public void addDisc(Disc disc) {
        list.add(disc);
    }

    //free memory

    public void setColor(Color color){
        /*
        Iterator<Disc> e = list.iterator();
        while(e.hasNext()) {
            e.next().setColor(color);
        }*/
        for (Disc d: list) {
            d.setColor(color);
        }
    }

    public Disc getDisc(char x, int y){
        for (Disc disc: list) {
            if(disc.getX() == x && disc.getY() == y) {
                return disc;
            }
        }
        return null;
    }

}
