package TreasureHuntGame;

/**
 * Created by marc on 08/05/2018.
 */
public class SafeMapCreator extends MapCreator {
    public SafeMap create() {
        return SafeMap.getInstance();
    }
}
