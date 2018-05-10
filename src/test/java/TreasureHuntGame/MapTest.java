package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

    MapCreator mapCreator;
    Map map;

    @Before
    public void setup() {
        mapCreator = new MapCreator();
        map = mapCreator.createMap("Safe");
        map.setSize(5);
    }

    @After
    public void teardown() {
        map = null;
        mapCreator = null;
    }

    @Test
    public void testGetMapSize() {

        //Exercise
        int mapSize = map.getSize();

        //Verify
        assertEquals(5, mapSize);

    }

    @Test
    public void testCreateMap() {
        //Exercise
        char mapCreated[][] = map.CreateMap(5);

        //Verify
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                assertNotEquals(null, mapCreated[i][j]); //make sure all positions are filled
            }
        }
    }

}
