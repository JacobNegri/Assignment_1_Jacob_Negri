package Super_Trump;

import java.util.ArrayList;
/**
 * Created by jnegr3 on 26/09/2016.
 */
public class STPlayer {
    private ArrayList<STCard> cards;

    private String playerId;

    public STPlayer(String playerId) {
        this.playerId = playerId;
    }

    public void setCards(ArrayList<STCard> cards) {
        this.cards = cards;
    }

    public String toString() {
        return "Player Id =" + playerId + "\n cards = " + cards;
    }

    public ArrayList<STCard> playersHand(){
        return cards;
    }

}
