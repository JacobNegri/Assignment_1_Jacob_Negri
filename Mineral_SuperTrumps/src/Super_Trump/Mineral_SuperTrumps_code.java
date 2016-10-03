package Super_Trump;
import java.util.*;
/**
 * Created by Jacob Negri on 25/09/2016.
 */
public class Mineral_SuperTrumps_code {

    public static void main(String[] args) {
        parse();
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
    private MenuSelection menuOption;

    private Mineral_SuperTrumps_code(MenuSelection menuOption){
        this.menuOption = menuOption;
    }

    private enum MenuSelection{
        NEW_GAME, QUIT_GAME, INSTRUCTIONS
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
                break;

            case INSTRUCTIONS:
                System.out.println("<<< Mineral Supertrumps Rules >>>");
                System.out.println(" . A dealer is randomly selected \n . A card can only be placed if the value of that card is higher then the trump categroy selected");
                System.out.println(" . There are five categories to choose from \n . A SuperTrump card can change the category currently being played \n . If you pass you will draw a card from the deck  \n . To win you must have no cards in your hand");
                System.out.println("..................................................................");
                showMenu();
                getUserMenuChoice();

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

        if(numPlayers == 2){
            game.selectBOTPlayer1();

            STPlayer botPlayerId1 = game.getBOTPlayer1();

            showPlayer(botPlayerId1);
        }
        else if(numPlayers == 3){
            game.selectBOTPlayer1();
            game.selectBOTPlayer2();

            STPlayer botPlayerId1 = game.getBOTPlayer1();
            STPlayer botPlayerId2 = game.getBOTPlayer2();

            showPlayer(botPlayerId1);
            showPlayer(botPlayerId1);
        }
        else if(numPlayers == 4){
            game.selectBOTPlayer1();
            game.selectBOTPlayer2();
            game.selectBOTPlayer3();

            STPlayer botPlayerId1 = game.getBOTPlayer1();
            STPlayer botPlayerId2 = game.getBOTPlayer2();
            STPlayer botPlayerId3 = game.getBOTPlayer3();

            showPlayer(botPlayerId1);
            showPlayer(botPlayerId2);
            showPlayer(botPlayerId3);
        }
        else if(numPlayers == 5){
            game.selectBOTPlayer1();
            game.selectBOTPlayer2();
            game.selectBOTPlayer3();
            game.selectBOTPlayer4();

            STPlayer botPlayerId1 = game.getBOTPlayer1();
            STPlayer botPlayerId2 = game.getBOTPlayer2();
            STPlayer botPlayerId3 = game.getBOTPlayer3();
            STPlayer botPlayerId4 = game.getBOTPlayer4();

            showPlayer(botPlayerId1);
            showPlayer(botPlayerId2);
            showPlayer(botPlayerId3);
            showPlayer(botPlayerId4);
        }


        // game.playTheGame();
        return game;
    }

    private static void getUserMenuChoice() {
        int userMenuSelection = 0;

        Scanner userInput = new Scanner(System.in);

        while (userMenuSelection < 1 || userMenuSelection > 3) {
            try {
                System.out.println("Enter Menu Choice:");
                userMenuSelection = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect Menu Selection:\nPlease Enter a Menu Choice");
                System.out.println("....................................................");
                userInput.nextLine();
        }
//      if made enumarated will need these if statements
        if (userMenuSelection == 1){
            Mineral_SuperTrumps_code newGame = new Mineral_SuperTrumps_code(MenuSelection.NEW_GAME);
            newGame.selectedMenuOption();
        }

        else if(userMenuSelection == 2){
            Mineral_SuperTrumps_code newGame = new Mineral_SuperTrumps_code(MenuSelection.INSTRUCTIONS);
            newGame.selectedMenuOption();
        }

        else if(userMenuSelection == 3){
            Mineral_SuperTrumps_code newGame = new Mineral_SuperTrumps_code(MenuSelection.QUIT_GAME);
            newGame.selectedMenuOption();
        }


        }
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Mineral Supertrumps.");
    }

    private static void showMenu() {
        System.out.println("1. Start game");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
    }

    private static int getNumPlayers() {

        int userPlayerSelection = 0;
        Scanner userInput = new Scanner(System.in);

        while (userPlayerSelection < 1 || userPlayerSelection > 5) {
            try {
                System.out.println("Please Enter the number of players (1-5):");
                userPlayerSelection = userInput.nextInt() ;

            } catch (InputMismatchException e) {
                    System.out.println("Enter a number:");
                    System.out.println("....................................................");
                    userInput.nextLine();
        }

        }

        return userPlayerSelection;
    }


    private static void showPlayer(STPlayer humPlayer) {
        System.out.println(humPlayer);
        System.out.println("........................................................");
    }
}
