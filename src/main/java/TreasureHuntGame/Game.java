package TreasureHuntGame;

import java.util.ArrayList;

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
    }

    //skip
    void GenerateHtmlFile(){

    }

    //marc
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
