package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by marc on 21/03/2018.
 */
public class CheckMovementTest {
    Player player;
    Position pos;
    Game game;
    Map map;
    char [][] gameMap;
    int mapSize = 5;

    @Before
    public void setup() {
        map = new Map();
        game = new Game();
        gameMap = map.CreateMap(mapSize);
        pos = new Position(3,2);
        player = new Player("Marc",mapSize,pos);
        System.out.println("Game Map:");
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        /*System.out.println("Player Map:");
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.print(player.getMap()[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    @After
    public void teardown() {
        map = null;
        pos = null;
        player = null;
    }

    @Test
    public void testCheckMovement() {
        pos = new Position(3,3);
        boolean victory = game.CheckMovement(player,gameMap,pos);
        if (victory) {
            assertEquals('T',gameMap[3][3]);
        } else {
            assertNotEquals('T',gameMap[3][3]);
        }
    }

    @Test
    public void testPlayerMap() {
        pos = new Position(3,3);
        boolean victory = game.CheckMovement(player,gameMap,pos);
        assertNotEquals('B',player.getMap()[3][3]);
    }
}
