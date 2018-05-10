package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    Player player, player2;
    Position pos;
    Team team;

    @Before
    public void setup() {
        char [][] tempMap = {{'G','G','G','G','G'},{'G','G','G','G','G'},{'G','G','G','G','G'},{'G','G','G','G','G'},{'G','G','G','G','G'}};
        team = new Team(5, tempMap);
        pos = new Position(2,4);
        player = new Player("Marc", 5, pos, team);
        player2 = new Player(5);
        team.addObserver(player);
        team.addObserver(player2);
    }

    @After
    public void teardown() {
        player = null;
    }

    @Test
    public void testSimpleGetName() {

        //Exercise
        String name = player.getName();

        //Verify
        assertEquals("Marc", name);

    }

    @Test
    public void testDefaultGetName() {

        //Exercise
        String name = player2.getName();

        //Verify
        assertEquals("Undefined",name);
    }

    @Test
    public void testSetName() {
        player.setName("Joseph");
        assertEquals("Joseph",player.getName());
    }

    @Test
    public void testSetPosition() {
        player.setPosition(pos);
        Position newPos = player.getPosition();

        assertTrue(newPos.x==2 && newPos.y==4);
    }

    @Test
    public void testMove() {
        player.setPosition(pos);
        player.move('D');
        Position newPos = player.getPosition();

        assertEquals(3,newPos.x);
    }

}
