package Super_Trump;
import java.util.*;
/**
 * Created by Jacob Negri on 25/09/2016.
 */
public class Mineral_SuperTrumps_code {

    private MenuSelection menuOption;

    private Mineral_SuperTrumps_code(MenuSelection menuOption){
        this.menuOption = menuOption;
    }

    private enum MenuSelection{
        NEW_GAME, QUIT_GAME
    }

    public static void main(String[] args) {
        welcomeMessage();
        showMenu();
        getUserMenuChoice();
//          No longer needed as made enumerated;;;;;;;;;;
//        int menuChoice = getUserMenuChoice();
//        STGame game;
//        if(menuChoice == NEW_GAME){
//            game = startGame();
//            game.playTheGame();
//        }
//        else if(menuChoice == QUIT_GAME){
//            System.out.println("Thanks for playing.");
//        }
    }

    private void selectedMenuOption(){
        switch(menuOption) {

            case NEW_GAME:
                STGame game;
                game = startGame();
                game.playTheGame();
                break;

            case QUIT_GAME:
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

    private static void getUserMenuChoice() {
        int userMenuSelection = 0;

        Scanner userInput = new Scanner(System.in);

        while (userMenuSelection < 1 || userMenuSelection > 2) {
            System.out.println("Enter Menu Choice");
            userMenuSelection = userInput.nextInt() ;
        }
//      if made enumarated will need these if statements
        if (userMenuSelection == 1){
            Mineral_SuperTrumps_code newGame = new Mineral_SuperTrumps_code(MenuSelection.NEW_GAME);
            newGame.selectedMenuOption();
        }

        else if(userMenuSelection == 2){
            Mineral_SuperTrumps_code newGame = new Mineral_SuperTrumps_code(MenuSelection.QUIT_GAME);
            newGame.selectedMenuOption();
        }

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

        try {
            while (userPlayerSelection < 1 || userPlayerSelection > 5) {
                System.out.println("Enter amount of players");
                userPlayerSelection = userInput.nextInt() ;
            }



        } catch (InputMismatchException e) {
            System.out.println("Please Enter a number for the cards position");
            getNumPlayers();
        }
        return userPlayerSelection;
    }


    private static void showPlayer(STPlayer humPlayer) {
        System.out.println("Human player" + humPlayer);
    }
}
