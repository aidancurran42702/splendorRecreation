import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVCardReader {

    public static void main(String... args) throws IOException {
        //ArrayList<Card> cards = readCardsFromCSV("SplendorGameSrc/main/java/Utils/SplendorCardValues.csv");
        ArrayList<Card> cards = readCardsFromCSV("out/test/Splendor AI/Utils/SplendorCardValues.csv");
        for (Card card : cards) {
            System.out.println(card.returnCost()); //just for testing
        }
    }

    public static ArrayList<Card> readCardsFromCSV(String filename) throws IOException {
        ArrayList<Card> cards = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String first = reader.readLine(); //get this out of the way
            String line = reader.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                int level = Integer.parseInt(attributes[0]);
                Color col = Color.WHITE;
                switch (attributes[1]) {
                    case "White":
                        col = Color.WHITE;
                        break;
                    case "Black":
                        col = Color.BLACK;
                        break;
                    case "Blue":
                        col = Color.BLUE;
                        break;
                    case "Red":
                        col = Color.RED;
                        break;
                    case "Green":
                        col = Color.GREEN;
                        break;
                }
                int value = Integer.parseInt(attributes[2]);
                HashMap<Color, Integer> cardColors = new HashMap<>();
                for (int i = 3; i < 8; i++) {
                    if (Integer.parseInt(attributes[i]) != 0) {
                        switch(i) {
                            case 3:
                                cardColors.put(Color.BLACK, Integer.parseInt(attributes[i]));
                                break;
                            case 4:
                                cardColors.put(Color.BLUE, Integer.parseInt(attributes[i]));
                                break;
                            case 5:
                                cardColors.put(Color.GREEN, Integer.parseInt(attributes[i]));
                                break;
                            case 6:
                                cardColors.put(Color.RED, Integer.parseInt(attributes[i]));
                                break;
                            case 7:
                                cardColors.put(Color.WHITE, Integer.parseInt(attributes[i]));
                                break;
                        }
                    }
                }
                Card newCard = new Card(level, col, value, cardColors);
                cards.add(newCard);
                //System.out.print(newCard.toString());
                line = reader.readLine();
            }

        } catch (Exception IOException) {
            IOException.printStackTrace();
        }
        return cards;
    }



}
