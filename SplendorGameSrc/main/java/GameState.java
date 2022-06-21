import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class GameState {
    //what do we want to keep track of in
    /** Tracks the current state of the game and its parameters
     * upon initialization. Can be played player-vs-player or AI V AI
     * AI-vs-AI for ML purposes. Returns an exit code: 0 is
     *  normal; any positive quantity indicates an error.  */
    GameState(Player player1, Player player2, ArrayList<Card> unshuffledDeck) { //handles the entire logic for setting up the game
        HashMap<Color, Integer> bank = new HashMap<>();
        bank.put(Color.BLUE, 7);
        bank.put(Color.RED, 7);
        bank.put(Color.BLACK, 7);
        bank.put(Color.GREEN, 7);
        bank.put(Color.WHITE, 7);
        bank.put(Color.JOKER, 5);
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

    }

    /** Suite of methods for making moves, withdrawing and reserving */
    Card retrieveCard(Player player, boolean isReserving, Card desiredCard) {
        //remove the hand from the data structure used, put it into the hand of the target player if !isReserving


    }

    /** Modifies the player's account to match their intent. MORE VALIDATION NEEDED */
    void makeWithdrawal(Player player, HashMap<Color, Integer> intent) {
        int sum = 0;
        for (int val : player.showTokens().values()) {
            sum += val;
        }
        sum -= player.showTokens().get(Color.JOKER);
        if (sum > 10) {
            System.out.println("Your account is too full!");
        } else {
            for (Color col : intent.keySet()) {
                player.showTokens().put(col, player.showTokens().get(col) + intent.get(col));
            }
        }
    }

    /**Methods for displaying, in some way, the current state of the game**/


    Player _player1;
    Player _player2;
    Stack<Card> realDeck1;
    Stack<Card> realDeck2;
    Stack<Card> realDeck3;
    Card[] visibleT1 = new Card[4];
    Card[] visibleT2 = new Card[4];
    Card[] visibleT3 = new Card[4];


}
