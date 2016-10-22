package Super_Trump;

/**
 * Created by jnegr3 on 26/09/2016.
 */
public class STCard {
    private int id;
    private String name;

    // COMMENTED AND USE THE ONES BELOW
//    public STCard(int id){
//        this.id = id;
//    }
    // COMMENTED AND USE THE ONES BELOW
//    public String toString() {
//        return "Id =" + id;
//    }

    public STCard(int i, String s) {
        id = i;
        name = s;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
