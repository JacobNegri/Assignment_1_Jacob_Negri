package Super_Trump;

import java.util.*;


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

        dealerID = new Random().nextInt(numPlayers + 1);

    }

    public void dealRandomCards() {

        players = new STPlayer[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new STPlayer("" + i);
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
            for (int indexPlayer = yourPlayerId; indexPlayer < players.length; indexPlayer++) {

                if (indexPlayer == yourPlayerId){
                    System.out.println("Users Turn: \n");
                    showPlayerTurn();
                }
                else{
                    System.out.println("Computers Turn: ");
                }
            }

            if (players[yourPlayerId].playersHand().size() == 0){
                gameIsOn = false;
            }
//            else if (players[].playersHand().size() == 0){
//                gameIsOn = false;
//            }
            //gameIsOn = false;
            //showTurnPlayer();

        }
    }

    private void showPlayerTurn() {

        int selectOption;
        int handCount = players[yourPlayerId].playersHand().size();

        System.out.println(this.getHumPlayer());

        Scanner userSelection = new Scanner(System.in);



        try {
            System.out.println("\nWhat card do you wish to play? \nType '0' to pass >>");
            selectOption = userSelection.nextInt();

            while (selectOption < 0 || selectOption > handCount) {
                System.out.println("< Please enter a card place holder within your hand >\nWhat card do you wish to play? \nType '0' to pass >>");
                selectOption = userSelection.nextInt();
            }

            if (selectOption == 0) {
                System.out.println("<< Turn Passed >>");
                ArrayList<STCard> drawnCard = deck.dealCards(1);

                players[yourPlayerId].playersHand().addAll(drawnCard);

                System.out.println(players[yourPlayerId].playersHand());
            } else {
                System.out.println("<< " + players[yourPlayerId].playersHand().get(selectOption - 1) + " Card is played >>");
                players[yourPlayerId].playersHand().remove(selectOption - 1);

                System.out.println(players[yourPlayerId].playersHand());
            }
        } catch (InputMismatchException e){
            System.out.println("Please Enter a number for the cards position >");
            showPlayerTurn();
        }
    }
}
