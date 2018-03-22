package TreasureHuntGame;

import java.util.Scanner;
/**
 * Created by marc on 22/03/2018.
 */
public class main {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Map map = new Map();
        boolean correct = false;
        boolean cond1, cond2;

        int numOfPlayers, mapSize;

        while (!correct) {
            try {
                System.out.println("Enter the number of players:");
                numOfPlayers = scanner.nextInt();
                cond1 = game.CheckNumOfPlayers(numOfPlayers);
                System.out.println("Enter the map size:");
                mapSize = scanner.nextInt();
                cond2 = game.CheckMapSize(mapSize, numOfPlayers);
                correct = cond1 && cond2;
                if (!correct) {
                    System.out.println("Error, check restrictions on number of players and map size.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!!");
                correct = false;
            }
        }
    }
}
