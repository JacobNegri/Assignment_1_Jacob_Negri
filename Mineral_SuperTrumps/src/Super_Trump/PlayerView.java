package Super_Trump;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by jnegr3 on 22/10/2016.
 */
public class PlayerView extends JPanel {

    STPlayer player;
    JLabel playerName = new JLabel("not set");

    public PlayerView(STPlayer player) {
        this.player = player;

        add(playerName);

        addAllCards();
    }
    private void addAllCards() {
        //ArrayList<STCard> cards = player.getCards();
        ArrayList<STCard> cards = new ArrayList<STCard>();

        // BELOW IS ONLY IF THE LOADING CODE ABOVE DOES NOT WORK
        cards.add(new STCard(13,"13"));
        cards.add(new STCard(12,"12"));
        cards.add(new STCard(21,"21"));
        cards.add(new STCard(17,"17"));
        cards.add(new STCard(5,"5"));
        cards.add(new STCard(21,"21"));

        for (int i = 0; i < cards.size(); i++) {
            STCard card = cards.get(i);
            CardView cardView = new CardView(card);
            System.out.println("new card i = " + i);
            add(cardView);

        }

        repaint();
    }
}
