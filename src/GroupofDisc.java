import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zvzv1919 on 2018/1/10.
 * a set of disc that can be flipped together, for convenient purpose;
 * can also be searched.
 * setColor: set the color of the whole group of discs to what is passed in(calls 'disc.setColor(color)'.
 * getDisc: returns the disc of the specified coordinates, null if there !exists such a disc in the groupofDisc
 * equals: returns true only if the size of groups are the same, and discs of the same position from two groups have
 *      the same color. Attention: works properlly only when all discs have different positions
 * copy: copies the list and create a new GroupofDisc according to the list.
 * TODO:Sort and optimize equals.
 */


//
//
//
//

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

    public ArrayList<Disc> getList() {
        return list;
    }
    public boolean equals(Object o){
        Disc e;
        if(!(o instanceof GroupofDisc)){
            return super.equals(o);
        }
        GroupofDisc operand = (GroupofDisc) o;
        if(operand.list.size() != list.size()){
            return false;
        }
        for (Disc d: list) {
            e = operand.getDisc(d.getX(),d.getY());
            if(e == null || e.getColor() != d.getColor()){
                return false;
            }
        }
        return true;
    }
    public void absorb(GroupofDisc groupofDisc){
        if(groupofDisc == null){
            return;
        }
        for (Disc disc: groupofDisc.getList()) {
            list.add(disc);
        }
    }
    public static GroupofDisc copy(GroupofDisc groupofDisc){
        GroupofDisc newGroup = new GroupofDisc();
        for (Disc disc: groupofDisc.list) {
            Disc newDisc = new Disc(disc.getX(), disc.getY());
            newDisc.setColor(disc.getColor());
            newGroup.list.add(newDisc);
        }
        return newGroup;
    }
}
