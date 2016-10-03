package Super_Trump;
import java.util.*;
/**
 * Created by Jacob Negri on 25/09/2016.
 */
public class Mineral_SuperTrumps_code {

    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;

    public static void main(String[] args) {
        welcomeMessage();
        showMenu();
        int menuChoice = getUserMenuChoice();
        STGame game;
        if(menuChoice == NEW_GAME){
            game = startGame();
            game.playTheGame();
        }
        else if(menuChoice == QUIT_GAME){
            System.out.println("Thanks for playing.");
        }
    }

    private static STGame startGame() {

        int numPlayers = getNumPlayers();
        STGame game = new STGame(numPlayers);
        game.selectDealer();
        game.dealRandomCards();

        game.selectYouAsPlayer();

        STPlayer humPlayer = game.getHumPlayer();
        showPlayer(humPlayer);

        // game.playTheGame();
        return game;
    }

    private static int getUserMenuChoice() {
        int userMenuSelection = 0;

        Scanner userInput = new Scanner(System.in);

        while (userMenuSelection < 1 || userMenuSelection > 2) {
            System.out.println("Enter Menu Choice");
            userMenuSelection = userInput.nextInt() ;
        }
//      if made enumarated will need these if statements
//        if (userMenuSelection == 1){
//            return 1;
//        }
//
//        else if(userMenuSelection == 2){
//            return 2;
//        }
        // get the user choice and return it
        // currently just return 1 until above comment is code
        return userMenuSelection;
    }

    private static void welcomeMessage() {
        System.out.println("hello");
    }

    private static void showMenu() {
        System.out.println("1. Start game");
        System.out.println("2. Exit");
    }

    private static int getNumPlayers() {

        int userPlayerSelection = 0;

        Scanner userInput = new Scanner(System.in);

        while (userPlayerSelection < 1 || userPlayerSelection > 5) {
            System.out.println("Enter amount of players");
            userPlayerSelection = userInput.nextInt() ;
        }
        // get the numebr of players
        // currently just return 1 until above comment is coded
        return userPlayerSelection;
    }

    private static void showPlayer(STPlayer humPlayer) {
        System.out.println("Human player" + humPlayer);
    }
}
