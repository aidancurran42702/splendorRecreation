import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/** Represents one player in a game of Jump61.  At any given time, each
 *  Player is attached to a Game and has a Side.  Each call of getMove()
 *  returns a valid move.
 **/
abstract class Player {

    /** A Player in GAME, initially playing COLOR. */
    Player() {
        reserved = new ArrayList<>();
        _hand = new ArrayList<Card>();
        _points = 0;
        _account = new HashMap<Color, Integer>();
        _account.put(Color.BLUE, 0);
        _account.put(Color.RED, 0);
        _account.put(Color.BLACK, 0);
        _account.put(Color.GREEN, 0);
        _account.put(Color.WHITE, 0);
        _account.put(Color.JOKER, 0);

    }

    /** Return the color I am currently playing. */
    final ArrayList<Card> getHand() {
        return _hand;
    }

    /** Return the Game I am currently playing in. */


    public void addToHand(Card card) {
        _hand.add(card);
    }

    /** Return my next move, or a command.*/
    abstract String getMove() throws IOException;

    HashMap<Color, Integer> showTokens() {
        return _account;
    }

    void takeTokens(int blue, int green, int white, int red, int black) {
        _account.put(Color.BLUE, _account.get(Color.BLUE) + blue);
        _account.put(Color.GREEN, _account.get(Color.GREEN) + blue);
        _account.put(Color.WHITE, _account.get(Color.WHITE) + blue);
        _account.put(Color.RED, _account.get(Color.RED) + blue);
        _account.put(Color.BLACK, _account.get(Color.BLACK) + blue);

    };

    void reserveCard() {

    };

    /** My current color. */
    private ArrayList<Card> _hand;
    /** The game I'm in. */
    //private final GameState _game;

    private HashMap<Color, Integer> _account;

    int _points;

    boolean _isAI;

    ArrayList<Card> reserved;

}
