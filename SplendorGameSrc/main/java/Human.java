import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Human extends Player  {
    Human() {
        super();
        _isAI = false;
        inputRead = new InputStreamReader(System.in);
        br = new BufferedReader(inputRead);
    }

    /**Returns a move based on the input of the user**/
    String getMove() throws IOException {
        return br.readLine();
    }

    InputStreamReader inputRead;
    BufferedReader br;

}
