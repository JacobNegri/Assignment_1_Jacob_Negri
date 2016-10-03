package Super_Trump;

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
        // get the user choice and return it
        // currently just return 1 until above comment is coded
        return 1;
    }

    private static void welcomeMessage() {
        System.out.println("hello");
    }

    private static void showMenu() {
        System.out.println("1. Start game");
        System.out.println("2. Exit");
    }

    private static int getNumPlayers() {
        // get the numebr of players
        // currently just return 1 until above comment is coded
        return 3;
    }

    private static void showPlayer(STPlayer humPlayer) {
        System.out.println("Hum player" + humPlayer);
    }
}
