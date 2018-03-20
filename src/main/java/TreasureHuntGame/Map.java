package TreasureHuntGame;
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
}
