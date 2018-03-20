package TreasureHuntGame;

/**
 * Created by marc on 20/03/2018.
 */
public class Player {
    private String name;
    private Position position;

    public Player () {
        name = "Undefined";
        position = new Position();
    }

    public Player(String name) {
        this.name = name;
        position = new Position();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    move function accepts a direction and sets the position of the player accordingly
     */
    public void move(char direction) {
        if (direction == 'U' || direction == 'u') {
            Position pos = new Position(position.x,(position.y)-1);
            setPosition(pos);
        } else if (direction == 'D' || direction == 'd') {
            Position pos = new Position(position.x,(position.y)+1);
            setPosition(pos);
        } else if (direction == 'L' || direction == 'l') {
            Position pos = new Position((position.x)-1,position.y);
            setPosition(pos);
        } else if (direction == 'R' || direction == 'r') {
            Position pos = new Position((position.x)+1,position.y);
            setPosition(pos);
        }
    }

    /*
    setPosition function changes the position of the player according to its input pos
     */

    public void setPosition(Position pos) {
        position = pos;
    }

    public Position getPosition() {
        return position;
    }
}
