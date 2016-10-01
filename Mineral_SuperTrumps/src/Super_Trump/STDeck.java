package Super_Trump;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jnegr3 on 26/09/2016.
 */
public class STDeck {

    private static final int NUM_CARDS_INIT = 10;
    private ArrayList<STCard> cards;

    public STDeck() {
        cards =  new ArrayList<STCard>();

        for(int i = 0; i < NUM_CARDS_INIT; i++) {
            cards.add(new STCard());
        }
    }

    public ArrayList<STCard> dealCards(int nCards) {

        for (int i = 0; i < nCards; i++){

            int idx = new Random().nextInt();

            STCard card =
        }
        return null;
    }
}
 8:14