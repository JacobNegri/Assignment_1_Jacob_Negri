package Super_Trump;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jnegr3 on 26/09/2016.
 */
public class STDeck {

    private static final int NUM_CARDS_INIT = 60;
    private ArrayList<STCard> cards;

    // todo: list of all cards
    public STDeck() {
        cards =  new ArrayList<STCard>();

        for(int i = 0; i < NUM_CARDS_INIT; i++) {
            cards.add(new STCard());
            // google how to create random array of integers
        }
    }

    public ArrayList<STCard> dealCards(int i) {
        return null;
    }
}
