package TreasureHuntGame;

import java.util.ArrayList;

/**
 * Created by jasmi on 20/03/2018.
 */

public class Game {
    int numOfPlayers;
    int mapSize;
    ArrayList<Player> players = new ArrayList<Player>();

    //jas
    char[][] GenerateMap(){
        char [][] map = new char [1][1];
        return map;
    }

    //jas
    void GenerateStartingPositions(char [][] map){
        //modifies players
    }

    //skip
    void GenerateHtmlFile(){

    }

    //marc
    /*
    Function that accepts the map and a position and moves the player to that position
    and returns the state of the player depending on the tile
     */
    int CheckMovement(char [][] map, Position pos){
        return 1;
    }
}
