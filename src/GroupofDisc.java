import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zvzv1919 on 2018/1/10.
 */


//a set of disc that can be flipped together, for convenient purpose;
//can also be searched.
//setColor: set the color of the whole group of discs to what is passed in(calls 'disc.setColor(color)'.


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
}
