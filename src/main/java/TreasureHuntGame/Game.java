package TreasureHuntGame;

import java.util.ArrayList;
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
    }

    //skip
    void GenerateHtmlFile(){

    }

    //marc
//    int CheckMovement(){

 //   }
}