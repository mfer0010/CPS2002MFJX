package TreasureHuntGame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    Game game;
    Map map;
    MapCreator mapCreator;
    char [][] gameMap;
    int mapSize = 5;

    @Before
    public void setup() {
        game = new Game();
        mapCreator = new MapCreator();
        map = mapCreator.createMap("Hazardous");
        gameMap = map.CreateMap(mapSize);
    }

    @After
    public void teardown() {
        game = null;
        mapCreator = null;
        map = null;
    }

    @Test
    public void TestCheckNumOfPlayersSmaller() {
        //Exercise
        boolean setPlayersNum = game.CheckNumOfPlayers(1);
        //Verify
        assertEquals(false, setPlayersNum);
    }

    @Test
    public void TestSetNumOfPlayersLarger() {
        //Exercise
        boolean setPlayersNum = game.CheckNumOfPlayers(10);
        //Verify
        assertEquals(false, setPlayersNum);
    }

    @Test
    public void TestSetNumOfPlayersWithinRange() {
        //Exercise
        boolean setPlayersNum = game.CheckNumOfPlayers(5);
        //Verify
        assertEquals(true, setPlayersNum);
    }

    @Test
    public void TestGenerateStartingPosition(){
        ArrayList<Position> startPositions;
        startPositions = game.GenerateStartingPositions(gameMap, 2, mapSize);

        for(int i = 0; i < startPositions.size(); i++){
            assertEquals(gameMap[startPositions.get(i).x][startPositions.get(i).y], 'G');
        }
    }

    @Test
    public void TestCheckMapSizeOutOfRangeSmaller(){
        int mapSize = 2;
        int numPlayers = 3;
        boolean valid = game.CheckMapSize(mapSize, numPlayers);
        assertFalse(valid);
    }

    @Test
    public void TestCheckMapSizeOutOfRangeLarger(){
        int mapSize = 51;
        int numPlayers = 3;
        boolean valid = game.CheckMapSize(mapSize, numPlayers);
        assertFalse(valid);
    }

    @Test
    public void TestCheckMapSizeWithin(){
        int mapSize = 5;
        int numPlayers = 3;
        boolean valid = game.CheckMapSize(mapSize, numPlayers);
        assertTrue(valid);
    }

}
