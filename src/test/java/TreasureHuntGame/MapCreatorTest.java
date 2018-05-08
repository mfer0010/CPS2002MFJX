package TreasureHuntGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by marc on 08/05/2018.
 */
public class MapCreatorTest {
    MapCreator mapCreator;
    Map map;

    @Before
    public void setup() {
        mapCreator = new MapCreator();
    }

    @After
    public void teardown() {
        mapCreator = null;
    }

    @Test
    public void testHazardType() {
        map = mapCreator.createMap("Hazardous");
        double prob = map.getWaterProb();
        //System.out.println(prob);
        assertTrue(prob >= 0.25 && prob <= 0.35);
    }

    @Test
    public void testSafeType() {
        map = mapCreator.createMap("Safe");
        double prob = map.getWaterProb();
//        System.out.println(prob);
        assertTrue(prob >= 0 && prob <= 0.1);
    }
}
