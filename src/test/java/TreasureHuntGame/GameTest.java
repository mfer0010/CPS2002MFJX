package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameTest {

    Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @After
    public void teardown() {
        game = null;
    }

    @Test
    public void TestSetNumOfPlayersSmaller() {
        //Exercise
        boolean setPlayersNum = game.SetNumOfPlayers(1);
        //Verify
        assertEquals(false, setPlayersNum);
    }

    @Test
    public void TestSetNumOfPlayersLarger() {
        //Exercise
        boolean setPlayersNum = game.SetNumOfPlayers(10);
        //Verify
        assertEquals(false, setPlayersNum);
    }

    @Test
    public void TestSetNumOfPlayersWithinRange() {
        //Exercise
        boolean setPlayersNum = game.SetNumOfPlayers(5);
        //Verify
        assertEquals(true, setPlayersNum);
    }

}
