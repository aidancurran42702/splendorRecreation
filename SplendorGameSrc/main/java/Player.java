import java.util.ArrayList;
import java.util.HashMap;

/** Represents one player in a game of Jump61.  At any given time, each
 *  Player is attached to a Game and has a Side.  Each call of getMove()
 *  returns a valid move.
 **/
abstract class Player {

    /** A Player in GAME, initially playing COLOR. */
    Player(GameState game) {
        _game = game;
        _hand = new ArrayList<Card>();
        _points = 0;
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
    final GameState getGame() {
        return _game;
    }

    /** Return my next move, or a command.*/
    abstract String getMove(); //this should be abstract since a player will input, but the AI will choose

    HashMap<Color, Integer> showTokens() {
        return _account;
    }

    void takeTokens() {

    };

    void reserveCard() {

    };

    /** My current color. */
    private ArrayList<Card> _hand;
    /** The game I'm in. */
    private final GameState _game;

    private HashMap<Color, Integer> _account;

    int _points;

}
