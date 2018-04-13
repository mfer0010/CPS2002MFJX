package TreasureHuntGame;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jasmi on 20/03/2018.
 */

public class Game {
    int minPlayers = 2;
    int maxPlayers = 8;
    int minMapSize1 = 5;
    int minMapSize2 = 8;
    int maxMapSize = 50;
    int mapSize;
    Map map = new Map();


    public Game(){
    }

    boolean CheckNumOfPlayers(int numOfPlayers){
        if(numOfPlayers < minPlayers || numOfPlayers > maxPlayers){
            return false; //unsuccessful
        }
        return true;
    }

    boolean CheckMapSize(int mapSize, int numOfPlayers){
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
    ArrayList<Position> GenerateStartingPositions(char [][] map, int numOfPlayers, int mapSize){
        Random rand = new Random();
        ArrayList <Position> positions = new ArrayList<Position>();
        int x, y;
        for(int i = 0; i < numOfPlayers; i++){

            while(true) {
                x = rand.nextInt(mapSize);
                y = rand.nextInt(mapSize);

                //make sure that start position is not a water or treasure tile
                if (map[x][y] == 'G') {
                    Position startPos = new Position(x, y);
                    positions.add(startPos);
                    break;
                }
            }
        }//close for loop
        return positions;
    }

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
            //already been
            player.resetPosition();
        }
        return false; //keep playing
    }
}

