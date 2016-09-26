package Super_Trump;

import java.util.ArrayList;

/**
 * Created by jnegr3 on 26/09/2016.
 */
public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    private int dealerID;
    private STPlayer[] players;
    private STDeck deck;

    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void selectDealer() {
        // google how to get random int in java
        // number between 1 and number of players
        // for now return 1
        dealerID = 1;
    }

    public void dealRandomCards() {

        players = new STPlayer[numPlayers];

        for (STPlayer player : players) {
            ArrayList<STCard> card = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards();
        }
    }
}
