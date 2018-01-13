import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zvzv1919 on 2018/1/11.
 */
public class iterator {
    public static void main(String[] args) {
        ArrayList<Integer> feli = new ArrayList<>();
        feli.add(1);
        feli.add(2);

        Iterator<Integer> e = feli.iterator();
        System.out.println(e);
        while(e.hasNext()) {
            System.out.println(e.next());
        }
        System.out.println(e);

    }
}
