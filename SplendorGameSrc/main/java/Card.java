import java.util.HashMap;

/**The first thing I implemented: contains support for making a number of cards and all the info needed **/
public class Card {

    Card(int level, Color color, int value, HashMap<Color, Integer> cost) {
        _level = level;
        _color = color;
        _cost = cost;
        _value = value;
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