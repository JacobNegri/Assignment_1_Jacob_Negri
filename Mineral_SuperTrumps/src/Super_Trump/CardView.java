package Super_Trump;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jnegr3 on 22/10/2016.
 */
public class CardView extends JPanel {

    final STCard card;
    JLabel cardName;

    public CardView(final STCard card) {
        this.card = card;
        cardName = new JLabel(card.getName() + "_id" + card.getId());
        add(cardName);

        // card.getImage();

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                STGame game = STGame.currGame;

                boolean ok = game.currGame.playCard(card);

                if(!ok) {
                    cardName.setText("Not okay to play");
                }

                game.getHumPlayer().getCards().remove(card);
                // game.setCurrentCard(card);


                // place cardview to play-table-view
                // remove card-view from player-view
                // game.playCard(card);

                cardName.setText("I was clicked!!!");
            }
        });
    }

//    class MyMouse() extends MouseInputAdapter{
//        public void mouseClicked(MouseEvent e) {
//
//            super.mouseClicked(e);
//
//            STGame.currGame.playCard(card);
//
//            cardName.setText("I was clicked!!!");
//        }
//    }
}
