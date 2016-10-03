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
    int yourPlayerId;

    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;
        deck = new STDeck();
    }

    public void selectDealer() {
        // google how to get random int in java
        // number between 1 and number of players
        // for now return 1

        // the two
        // int i = new random().nextInt(2) ;
        dealerID = 1;
    }

    public void dealRandomCards() {

        players = new STPlayer[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new STPlayer("Playerid=" + i);
        }

        for (STPlayer player : players) {
            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);
        }
    }

    public void selectYouAsPlayer(){
        yourPlayerId = 0;
    }

    public STPlayer getHumPlayer() {
        return players[yourPlayerId];
    }

    public void playTheGame() {

        Boolean gameIsOn = true;

        while (gameIsOn) {

            //todo: setup players in correct order
            for (int indexPlayer = 0; indexPlayer < players.length; indexPlayer++) {
                //todo: check humanplayer
                if (indexPlayer == yourPlayerId){
                    System.out.println("This is the human player: ");
                    showPlayerTurn();
                }
                else{
                    System.out.println("This player is the computer: ");
                }
            }

            gameIsOn = false;
            //showTurnPlayer();

        }
    }

    private void showPlayerTurn() {
        System.out.println(this.getHumPlayer());
    }
}
