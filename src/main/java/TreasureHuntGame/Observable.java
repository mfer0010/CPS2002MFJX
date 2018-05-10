package TreasureHuntGame;

/**
 * Created by jasmi on 10/05/2018.
 */
public interface Observable {
    void addObserver(Observer o);
    void notifyObserver();
}
