import java.util.ArrayList;

/** Represents one player in a game of Jump61.  At any given time, each
 *  Player is attached to a Game and has a Side.  Each call of getMove()
 *  returns a valid move.
 **/
abstract class Player {

    /** A Player in GAME, initially playing COLOR. */
    Player(GameState game) {
        _game = game;
        _cards = new ArrayList<Card>();

    }

    /** Return the color I am currently playing. */
    final ArrayList<Card> getCards() {
        return _cards;
    }

    /** Return the Game I am currently playing in. */
    final GameState getGame() {
        return _game;
    }

    /** Return my next move, or a command.*/
    abstract String getMove();

    /** My current color. */
    private ArrayList<Card> _cards;
    /** The game I'm in. */
    private final GameState _game;

}
