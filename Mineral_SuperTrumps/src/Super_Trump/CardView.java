package Super_Trump;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jnegr3 on 22/10/2016.
 */
public class CardView extends JPanel {

    STCard card;
    JLabel cardName;

    public CardView(STCard card) {
        this.card = card;
        cardName = new JLabel(card.getName() + "_id" + card.getId());
        add(cardName);

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                STGame.currGame.validCardToPlay(card);

                cardName.setText("I was clicked!!!");
            }
        });
    }


}
