package TreasureHuntGame;

import java.util.ArrayList;
<<<<<<< HEAD

/**
 * Created by jasmi on 20/03/2018.
 */

public class Game {
    int numOfPlayers;
    int mapSize;
    ArrayList<Player> players = new ArrayList<Player>();
    Map map = new Map();

    public Game () {}
    //jas
    char[][] GenerateMap(){
        char [][] map = new char [1][1];
        return map;
    }

    //jas
    void GenerateStartingPositions(char [][] map){
        //modifies players
=======
import java.util.Random;

public class Game {
    int minPlayers = 2;
    int maxPlayers = 8;
    int minMapSize1 = 5;
    int minMapSize2 = 8;
    int maxMapSize = 50;
    int numOfPlayers;
    int mapSize;
    ArrayList<Player> players = new ArrayList<Player>();

    Game(){
    }

    boolean SetNumOfPlayers(int numOfPlayers){
        if(numOfPlayers < minPlayers || numOfPlayers > maxPlayers){
            return false; //unsuccessful
        }
        this.numOfPlayers = numOfPlayers;
        return true;
    }

    boolean SetMapSize(int mapSize){
        if(numOfPlayers >= 2 && numOfPlayers <= 4){
            if(mapSize >= minMapSize1 && mapSize <= maxMapSize){
                this.mapSize = mapSize;
                return true;
            }
        }
        else if(numOfPlayers >= 5 && numOfPlayers <= 8){
            if(mapSize >= minMapSize2 && mapSize <= maxMapSize){
                this.mapSize = mapSize;
                return true;
            }
        }
        return false;
    }

    //sets the starting position of the players
    void GenerateStartingPositions(char [][] map){
        Random rand = new Random();
        int x, y;
        for(int i = 0; i < numOfPlayers; i++){

            while(true) {
                x = rand.nextInt(mapSize);
                y = rand.nextInt(mapSize);

                //make sure that start position is not a water or treasure tile
                if (map[x][y] == 'G') {
                    Position startPos = new Position(x, y);
                    players.get(i).setPosition(startPos);
                    break;
                }
            }
        }//close for loop
>>>>>>> jasmine_dev
    }

    //skip
    void GenerateHtmlFile(){

    }

    //marc
<<<<<<< HEAD
    /*
    Function that accepts a player and the position and moves the player to that position
    and returns true if the player won, false otherwise.
     */
    boolean CheckMovement(Player player, char[][] gameMap, Position pos){
        //Uncover the target tile
        map.revealTile(player.getMap(), gameMap, pos);

        char tile = player.getMap()[pos.x][pos.y];
        if (tile == 'T') {
            return true; //Victory!
        } else if (tile == 'G') {
            //Player would have already moved to the tile, thus do nothing
        } else if (tile == 'W') {
            //Move player back to starting position, but leave map
            //in the same state so that the player can see where they've
            //already bin
            player.resetPosition();
        }
        return false; //keep playing
    }
}
=======
//    int CheckMovement(){

 //   }
}
>>>>>>> jasmine_dev
