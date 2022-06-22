import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Human extends Player  { //this should extend player but otherwise it wont compile
    Human() {
        super();
        _isAI = false;
        inputRead = new InputStreamReader(System.in);
        br = new BufferedReader(inputRead);
    }

    /**Returns a move based on the input of the user**/
    String getMove() throws IOException {
        return br.readLine(); //return a line read in from input
    }

    InputStreamReader inputRead;
    BufferedReader br;

}
