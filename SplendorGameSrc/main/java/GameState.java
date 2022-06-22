import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameState {
    //what do we want to keep track of in
        HashMap<Color, Integer> bank;
    /** Tracks the current state of the game and its parameters
     * upon initialization. Can be played player-vs-player or AI V AI
     * AI-vs-AI for ML purposes. Returns an exit code: 0 is
     *  normal; any positive quantity indicates an error.  */
    GameState(Player player1, Player player2, ArrayList<Card> unshuffledDeck) { //handles the entire logic for setting up the game
        //textSource = new InputStreamReader(System.in);
        _player1 = player1;
        _player2 = player2;
        bank = new HashMap<>();
        bank.put(Color.BLUE, 7);
        bank.put(Color.RED, 7);
        bank.put(Color.BLACK, 7);
        bank.put(Color.GREEN, 7);
        bank.put(Color.WHITE, 7);
        bank.put(Color.JOKER, 5);
        realDeck1 = new Stack<Card>();
        realDeck2 = new Stack<Card>();
        realDeck3 = new Stack<Card>();
        Collections.shuffle(unshuffledDeck);
        for (Card card : unshuffledDeck) {
            switch(card._level) {
                case 1:
                    realDeck1.push(card);
                case 2:
                    realDeck2.push(card);
                case 3:
                    realDeck3.push(card);
            }
        }

        for (int j = 0; j < 3; j++) {
            visibleT1[j] = realDeck1.pop();
            visibleT2[j] = realDeck2.pop();
            visibleT3[j] = realDeck3.pop();
        }

        currPlayer = _player1;
    }

    void playGame() throws IOException {
        int _exit = 0;
        boolean winnerAnnounced = false;
        while (_exit > -1) {
            //the entire game is played within this loop. Use other classes to request text input
            //and do all the other shit. main hardly does anything bar creating the game object to run it
            //and calling the play method look at proj2 for the details
            if (!getWinner()) {
                winnerAnnounced = false;
                System.out.print(prompt());
                executeCommand(whoseMove().getMove()); //this may work? getMove returns something read from user
                //need to get the player whose move it currently is and execute their move
        }
            else {
                System.out.println("We have a winner!");
                System.exit(0);
            }
        }

    }

    private String prompt() {
        if (!getWinner()) {
            return String.format("%s> ", whoseMove());
        } else {
            return "+> ";
        }
    }

    /** Suite of methods for making moves, withdrawing and reserving */
    void retrieveCard(Player player, boolean isReserving, int tier, int index) {
        //remove the hand from the data structure used, put it into the hand of the target player if !isReserving
        switch (tier) {
            case 1:
                player.getHand().add(visibleT1[index]);
                visibleT1[index] = realDeck1.pop();
            case 2:
                player.getHand().add(visibleT2[index]);
                visibleT2[index] = realDeck2.pop();
            case 3:
                player.getHand().add(visibleT3[index]);
                visibleT3[index] = realDeck3.pop();
        }

    }

    /**Tracks if the game is over**/
    boolean getWinner() {
        if (_player1._points >= 15) {
            return true;
        }
        if (_player2._points >= 15) {
            return true;
        }
        return false;
    }

    /**Returns whose move it currently is. Player1 goes first**/
    Player whoseMove() {
        Player temp = currPlayer;
        if (currPlayer == _player1){ //maybe this should be .equals/..
            currPlayer = _player2;
        }
        else {
            currPlayer = _player1;
        }
        return temp;
    }


    /**Methods for displaying, in some way, the current state of the game**/
    public String toString() {
        Formatter format = new Formatter();
        format.format("Tier 3 Cards:");
        format.format("%n");
        for (Card card : realDeck3) {
            format.format(card.toString());
        }

        format.format("Tier 2 Cards:");
        format.format("%n");
        for (Card card : realDeck2) {
            format.format(card.toString());
        }

        format.format("Tier 1 Cards:");
        format.format("%n");
        for (Card card : realDeck1) {
            format.format(card.toString());
        }
        return format.toString();

    }

    /**The primary controller for the entire gamestate. Calls other functions based on what command
     * we see inputted**/
    public void executeCommand(String command) { //no return, just calls other function of game based on inp
        String[] split = command.split(",");
        switch (split[0]) {
            case "withdraw": //uhhh replace this with makeWithdrawal u dumbass
                int numBlue = Integer.parseInt(split[1]);
                int numGreen = Integer.parseInt(split[2]);
                int numWhite = Integer.parseInt(split[3]);
                int numRed = Integer.parseInt(split[4]);
                int numBlack = Integer.parseInt(split[5]);
                whoseMove().takeTokens(numBlue, numGreen, numWhite, numRed, numBlack); //why is this here?

                bank.put(Color.BLUE, bank.get(Color.BLUE) - numBlue);
                bank.put(Color.GREEN, bank.get(Color.GREEN) - numGreen);
                bank.put(Color.RED, bank.get(Color.RED) - numRed);
                bank.put(Color.BLACK, bank.get(Color.BLACK) - numBlack);
                bank.put(Color.WHITE, bank.get(Color.WHITE) - numWhite);
                System.out.println(bank);


            case "reserve":


            case "purchase":
                Card desiredCard;
                int tier = Integer.parseInt(split[1]);
                if (tier == 1) {
                    desiredCard = visibleT1[(Integer.parseInt(split[2]))];
                    visibleT1[Integer.parseInt(split[2])] = realDeck1.pop();
                }

                if (tier == 2) {
                    desiredCard = visibleT2[(Integer.parseInt(split[2]))];
                    visibleT2[Integer.parseInt(split[2])] = realDeck2.pop();
                }

                if (tier == 3) {
                    desiredCard = visibleT3[(Integer.parseInt(split[2]))];
                    visibleT3[Integer.parseInt(split[2])] = realDeck3.pop();
                }
                else {
                    desiredCard = realDeck1.get(Integer.parseInt(split[2]));
                }

                currPlayer.addToHand(desiredCard); //use indexing to specify the card we want
        }

    }

    Player _player1;
    Player _player2;
    Stack<Card> realDeck1;
    Stack<Card> realDeck2;
    Stack<Card> realDeck3;
    Card[] visibleT1 = new Card[4];
    Card[] visibleT2 = new Card[4];
    Card[] visibleT3 = new Card[4];
    Player currPlayer;
    InputStreamReader textSource;


}
