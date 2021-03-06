/*package TreasureHuntGame;
import java.util.*;

public class Map {

    private int size;
    private double waterProb = 0.1;

    public Map(){
    }

    public int GetSize(){
        return size;
    }

    public void SetSize(int s){
        size = s;
    }

    public char[][] CreateMap(int s){
        size = s;
        char mapArray[][] = new char[size][size];
        Random rand = new Random();
        double temp;
        int x, y;

        //determine whether a given tile is a water tile using probability
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp = rand.nextDouble();
                if(temp < waterProb){ //then it is a water tile
                    mapArray[i][j] = 'W';
                }
                else {
                    mapArray[i][j] = 'G';
                }
            }
        }//close for loop

        //find a random position for the treasure
        x = rand.nextInt(size);
        y = rand.nextInt(size);
        mapArray[x][y] = 'T';

        return mapArray;
    }

    //Added by Marc:
    //This function creates a map state filled with 'Black' Tiles,
    //This is to be used for each player's personal map
    //which will be displayed.
    public char[][] createFoggyMap(int size) {
        this.size = size;
        char mapArray[][] = new char[size][size];
        //populate map
        for(int i = 0; i <size; i++) {
            for (int j = 0; j < size; j++) {
                mapArray[i][j] = 'B';
            }
        }
        return mapArray;
    }

    /*
    Added by Marc:
    This function accepts the player's map and the game map and a position and reveals
    the tile in the position of the player map

    public void revealTile(char[][] playerMap, char[][]gameMap, Position pos) {
        int x = pos.x;
        int y = pos.y;
        playerMap[x][y] = gameMap[x][y];
    }
}*/

package TreasureHuntGame;

public interface Map {
//    int size;
//    double waterProb = 0;

    void setSize(int size);
    int getSize();
    double getWaterProb();
    char[][] CreateMap(int s);
    //char[][] createFoggyMap(int size);
    //void revealTile(char[][] playerMap, char[][]gameMap, Position pos);
}