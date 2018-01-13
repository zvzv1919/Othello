import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zvzv1919 on 2018/1/10.
 */

//a set of disc that can be flipped together, for convenient purpose;
//can also be searched.

public class GroupofDisc {
    private ArrayList<Disc> list;

    public GroupofDisc() {
        list = new ArrayList<Disc>();
    }

    public void addDisc(Disc disc) {
        list.add(disc);
    }

    //free memory

    public void setOccupation(Occupation occupation){
        Iterator<Disc> e = list.iterator();

    }
}
