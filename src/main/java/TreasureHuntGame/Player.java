package TreasureHuntGame;

/**
 * Created by marc on 20/03/2018.
 */
public class Player {
    private String name;
    private Position position, startingPosition;
    private Map map;
    private char [][] playerMap;
    HTMLGenerator htmlGenerator = new HTMLGenerator();

    //Each Player must be initialized with the size of the map
    //and the starting position
    public Player (int size) {
        name = "Undefined";
        position = new Position();
        map = new Map();
        playerMap = map.createFoggyMap(size);
        this.startingPosition = new Position();
    }

    public Player(String name, int mapSize, Position startingPosition) {
        this.name = name;
        position = new Position();
        map = new Map();
        playerMap = map.createFoggyMap(mapSize);
        this.startingPosition = new Position(startingPosition);
        this.position = new Position(startingPosition);
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
        if (direction == 'U') {
            Position pos = new Position(position.x-1,position.y);
            setPosition(pos);
        } else if (direction == 'D') {
            Position pos = new Position(position.x+1,position.y);
            setPosition(pos);
        } else if (direction == 'L') {
            Position pos = new Position(position.x,position.y-1);
            setPosition(pos);
        } else if (direction == 'R') {
            Position pos = new Position(position.x,position.y+1);
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

    public char [][] getMap() {
        return playerMap;
    }

    //function to move the player back to their origional starting position
    public void resetPosition() {
        position = startingPosition;
    }

    //skip
    void GenerateHtmlFile(){
        try{
            htmlGenerator.GenerateHTMLPlayerFile(this.playerMap, this.name, this.position);
        }
        catch (Exception e){
            System.out.println("Unable to generate HTML file");
            System.exit(0);
        }
    }
}
