package TreasureHuntGame;

/**
 * Created by marc on 08/05/2018.
 */
import java.util.*;

public class HazardousMap implements Map {
    int size;
    double waterProb;

    public HazardousMap() {
        Random random = new Random();
        this.waterProb = 0.25 +0.1 * random.nextDouble();
//        System.out.println(this.waterProb);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public double getWaterProb() {
        return this.waterProb;
    }
    public char[][] CreateMap(int s){
        setSize(s);
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
}
