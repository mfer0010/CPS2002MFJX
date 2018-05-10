package TreasureHuntGame;

import java.util.ArrayList;

/**
 * Created by jasmi on 10/05/2018.
 */
public class Team implements Observable{
    public char [][] mapState;
    private char [][] gameMap;
    ArrayList<Observer> playerObsList = new ArrayList<Observer>();

    public Team(int mapSize, char[][] gameMap){
        createFoggyMap(mapSize);
        this.gameMap = gameMap;
    }

    public void updateMapState(Position position){
        mapState[position.x][position.y] = gameMap[position.x][position.y];
        notifyObserver();
    }

    public void addObserver(Observer o){
        playerObsList.add(o);
    }

    public void notifyObserver(){
        for(Observer o : playerObsList){
            o.update();
        }
    }

    //This function creates a map state filled with 'Black' Tiles,
    public void createFoggyMap(int size) {
        mapState = new char[size][size];
        //populate map
        for(int i = 0; i <size; i++) {
            for (int j = 0; j < size; j++) {
                mapState[i][j] = 'B';
            }
        }
    }
}
