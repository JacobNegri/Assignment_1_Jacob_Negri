package Super_Trump;

import java.util.*;

import static Super_Trump.Mineral_SuperTrumps_code.getUserMenuChoice;
import static Super_Trump.Mineral_SuperTrumps_code.showMenu;

/**
 * Created by Jacob Negri on 25/09/2016.
 */

public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8;

    // below added for the GUI
    public static STGame currGame;

    private int numPlayers;
    private int dealerID;
    private STPlayer[] players;
    private STDeck deck;
    int yourPlayerId;

    private int botPlayerId1;
    private int botPlayerId2;
    private int botPlayerId3;
    private int botPlayerId4;

    private int botWins;

    private List computerBots = new ArrayList(4);


    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;
        deck = new STDeck();

        currGame = this;
    }

    public boolean playCard(STCard card) {
        return true;
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

    public void selectBOTPlayer1(){
        botPlayerId1 = 1;
    }

    public STPlayer getBOTPlayer1() {
        return players[botPlayerId1];
    }

    public void selectBOTPlayer2(){
        botPlayerId2 = 2;
    }

    public STPlayer getBOTPlayer2() {
        return players[botPlayerId2];
    }

    public void selectBOTPlayer3(){
        botPlayerId3 = 3;
    }

    public STPlayer getBOTPlayer3() {
        return players[botPlayerId3];
    }

    public void selectBOTPlayer4(){
        botPlayerId4 = 4;
    }

    public STPlayer getBOTPlayer4() {
        return players[botPlayerId4];
    }







    public void playTheGame() {

        int convertObjectToInteger;

        Boolean gameIsOn = true;

        computerBots.add(botPlayerId1);
        computerBots.add(botPlayerId2);
        computerBots.add(botPlayerId3);
        computerBots.add(botPlayerId4);

        while (gameIsOn) {

            // System.out.println("The dealer is " + dealerID);
            // System.out.println("Player Id " + (dealerID + 1) + ": You start the round >>");

            //todo: setup players in correct order
            for (int indexPlayer = yourPlayerId; indexPlayer < players.length; indexPlayer++) {

                if (players[yourPlayerId].playersHand().size() == 0){
                    System.out.println("Congratulations, YOU WIN!!!!!!!!!!! ");
                    gameIsOn = false;
                    showMenu();
                    getUserMenuChoice();
                    break;
                }

                else if (indexPlayer == yourPlayerId){
                    System.out.println("Users Turn: \n");
                    showPlayerTurn();
                }
                else{
                    System.out.println("Computers Turn: ");
                    convertObjectToInteger = Integer.parseInt(computerBots.get(indexPlayer - 1).toString());

                    // As the XML file is currently not being able to load the BOT players will just place down a random card

                    //selectOption = new Random().nextInt(players[botPlayerId1].playersHand());

//                    System.out.println("<< " + players[botPlayerId1].playersHand().get(selectOption - 1) + " Card is played >>");
//                    players[yourPlayerId].playersHand().remove(selectOption - 1);
//
//                    System.out.println(players[yourPlayerId].playersHand());
                    showCompTurn(convertObjectToInteger);
                }
            }


            //else if (.playersHand().size() == 0){

            //}
//            else if (players[].playersHand().size() == 0){
//                gameIsOn = false;
//            }
            //gameIsOn = false;
            //showTurnPlayer();

        }
    }

    private void showCompTurn(int computerId) {
        System.out.println("Computer Id = " + computerId);

        // This is only added as the reading XML was not working and would not allow me to actually get the players to place cards without knowing values of each card

        System.out.println("<< " + players[computerId].playersHand().get(1) + " Card is played >>\n");
        players[computerId].playersHand().remove(1);

        System.out.println(players[computerId].playersHand()+"\n");

        if (players[computerId].playersHand().size() == 0) {
            System.out.println("Player ID: " + computerId + " WINS!!");
            showMenu();
            getUserMenuChoice();
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
