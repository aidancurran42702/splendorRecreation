import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static boolean started = false;

    public static void main(String... args) throws IOException {

        /**TODO for main:
         * return whose move it is
         * actually make a goddamn move
         * this needs a dire fix. GameState needs to handle all the playing of the game,
         * continually requesting inputs along the way**/
        switch (args[0]) {
            case "start":
                System.out.println("start");
                if (!started) {
                    System.out.println("detection");
                    int numMoves = 0;
                    started = true;
                    Player player1 = null;
                    if (args[1].equals("Human")) {
                        player1 = new Human();
                    }
                    else if (args[1].equals("AI")) {
                        player1 = new AI();
                    } else {
                        System.out.println("invalid player input");
                    }

                    Player player2 = null;
                    if (args[2].equals("Human")) {
                        player2 = new Human();
                    }
                    else if (args[2].equals("AI")) {
                        player2 = new AI();
                    } else {
                        System.out.println("invalid player input");
                    }
                    _currGame = new GameState(player1, player2, CSVCardReader.readCardsFromCSV("SplendorGameSrc/main/java/Utils/SplendorCardValues.csv"));
                    _currGame.playGame();
                }
        }


    }

    //public ArrayList<Card> readCardsCSV() {

    //}
    static GameState _currGame;
    //boolean started;
}
