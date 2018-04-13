package TreasureHuntGame;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by marc on 22/03/2018.
 */
public class main {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Player> players = new ArrayList<Player>();
        //Possible Directions:
        ArrayList <Character> directions = new ArrayList<Character>();
        directions.add('U');
        directions.add('D');
        directions.add('L');
        directions.add('R');
        Player p;
        char direction = 'U';
        Game game = new Game();
        Map map = new Map();
        boolean correct = false;
        boolean victory = false; //True when a player finds the treasure
        boolean cond1, cond2;

        int numOfPlayers = 0, mapSize = 0;


        //Check the User inputs:
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
                scanner.next(); //to avoid infinite loop
                correct = false;
            }
        }

        //Create the Game Map:
        char [][] gameMap = map.CreateMap(mapSize);

        //create each player
        ArrayList <Position> positions = game.GenerateStartingPositions(gameMap,numOfPlayers,mapSize);
        System.out.println(positions.get(1).x+" "+positions.get(1).y);
        for (int i = 1; i <= numOfPlayers; i++) {
            p = new Player("Player "+i,mapSize,positions.get(i-1));
            p.GenerateHtmlFile();
            players.add(p);
        }

        //test:
        for (int i = 0; i < numOfPlayers; i++) System.out.println(players.get(i).getPosition().x+" "+players.get(i).getPosition().y);

        p = new Player(mapSize);
        //main loop (Until a player wins the game)
        while(!victory) {
            for(Player player:players) {
                System.out.println("******************************");
                System.out.println("           "+player.getName());
                System.out.println("******************************\n\n");
                //get Direction:
                correct = false;
                while(!correct) {
                    try {
                        System.out.println("Choose a Direction (U/D/L/R): ");
                        direction = Character.toUpperCase(scanner.next().charAt(0));
                        if (!directions.contains(direction)) {
                            System.out.println("Enter either U or D or L or R");
                        } else if (direction == 'U' && player.getPosition().y <= 0) {
                            System.out.println(player.getName() + " cannot move up");
                        } else if (direction == 'D' && player.getPosition().y >= mapSize) {
                            System.out.println(player.getName() + " cannot move down");
                        } else if (direction == 'L' && player.getPosition().x <= 0) {
                            System.out.println(player.getName()+" cannot move left");
                        } else if (direction == 'R' && player.getPosition().x >= mapSize) {
                            System.out.println(player.getName()+" cannot move right");
                        } else {
                            correct = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Enter A valid direction");
                        scanner.next(); //to avoid infinite loop
                        correct = false;
                    }
                }
                //set the player's position
                player.move(direction);
                System.out.println(player.getPosition().x+" "+player.getPosition().y);
                //uncover the tile and return true if the player wins:
                victory = game.CheckMovement(player,gameMap,player.getPosition());
                if (victory) {
                    p = player; //save the winning player
                }
                player.GenerateHtmlFile();
            }
        }
        System.out.println("******************************");
        System.out.println(p.getName()+" wins the game!!");
    }
}
