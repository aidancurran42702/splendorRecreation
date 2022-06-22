import java.util.Formatter;
import java.util.HashMap;

/**The first thing I implemented: contains support for making a number of cards and all the info needed **/
public class Card {
    Card(int level, Color color, int value, HashMap<Color, Integer> cost) {
        _level = level; //1, 2 or 3
        _color = color;
        _cost = cost;
        _value = value;
    }

    public String toString() {
        Formatter f = new Formatter();
        f.format("---------------------");
        f.format("%n");
        f.format(String.format("|Color:".concat(_color.toString())));
        f.format("|");
        f.format("%n");
        f.format(String.format("|Points:%d|", _value));
        f.format("%n");
        f.format(String.format("|Cost:".concat(_cost.toString())));
        f.format("|");
        f.format("%n");
        f.format("---------------------");
        return f.toString();
    }

    int returnValue() {
        return _value;
    }

    HashMap<Color, Integer> returnCost() {
        return _cost;
    }

    Color returnColor() {
        return _color;
    }


    HashMap<Color, Integer> _cost;

    int _level;

    Color _color;

    int _value;

}
