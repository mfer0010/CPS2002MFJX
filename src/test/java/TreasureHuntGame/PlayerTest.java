package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    Player player, player2;
    Position pos;

    @Before
    public void setup() {
        pos = new Position(2,4);
        player = new Player("Marc", 5, pos);
        player2 = new Player(5);
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
