package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jasmi on 10/05/2018.
 */
public class CheckTeamTest {

    Team team;
    Game game;
    Map map;
    Player p1, p2, p3;
    MapCreator mapCreator;
    char [][] gameMap;
    int mapSize = 5;

    @Before
    public void setup() {
        game = new Game();
        mapCreator = new MapCreator();
        map = mapCreator.createMap("Hazardous");
        gameMap = map.CreateMap(mapSize);
        team = new Team(mapSize, gameMap);
        p1 = new Player("Marc", mapSize, new Position(2,2), team);
        p2 = new Player("Jasmine", mapSize, new Position(4,2), team);
        p3 = new Player(mapSize);
        team.addObserver(p1);
        team.addObserver(p2);
    }

    @After
    public void teardown() {
        game = null;
        mapCreator = null;
        map = null;
    }

    @Test
    public void testUpdateMapState() {
        //Exercise
        team.updateMapState(new Position(3,3));
        //Verify
        assertEquals(gameMap[3][3], team.mapState[3][3]);
    }

    @Test
    public void testNotifyObserver(){
        //exercise
        team.updateMapState(new Position(1,3));
        team.notifyObserver();
        //verify
        assertEquals(gameMap[1][3], p1.getMap()[1][3]);
        assertEquals(gameMap[1][3], p2.getMap()[1][3]);
    }

    @Test
    //test that all the tiles are set to black
    public void testFoggyMap(){
        team.createFoggyMap(mapSize);
        for(char[] i: team.mapState){
            for(char j : i){
                assertEquals('B', j);
            }
        }
    }

    @Test
    public void testAddObserver(){
        int size = team.playerObsList.size();
        team.addObserver(p3);
        assertTrue(size == (team.playerObsList.size()-1));
    }
}
