package TreasureHuntGame;

/**
 * Created by marc on 20/03/2018.
 */
public class Player implements Observer{
    public Team team = null;
    private String name;
    private Position position, startingPosition;
    //private Map map;
    private char [][] playerMap;
    HTMLGenerator htmlGenerator = new HTMLGenerator();

    //Each Player must be initialized with the size of the map
    //and the starting position
    public Player (int size) {
        name = "Undefined";
        position = new Position();
       // this.team = team;
        //map = new SafeMap();
        //map = SafeMap.getInstance(); //getting copy of the pre-created safe map
        createFoggyMap(size);
        this.startingPosition = new Position();
    }

    public Player(String name, int mapSize, Position startingPosition, Team team) {
        this.name = name;
        position = new Position();
        this.team = team;
        //map = new SafeMap();
        //map = SafeMap.getInstance();
        createFoggyMap(mapSize);
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

    //function to move the player back to their original starting position
    public void resetPosition() {
        position = startingPosition;
    }

    void GenerateHtmlFile(){
        try{
            htmlGenerator.GenerateHTMLPlayerFile(this.playerMap, this.name, this.position);
        }
        catch (Exception e){
            System.out.println("Unable to generate HTML file");
            System.exit(0);
        }
    }

    //This function creates a map state filled with 'Black' Tiles,
    //This is to be used for each player's personal map
    //which will be displayed.
    public void createFoggyMap(int size) {
        playerMap = new char[size][size];
        //populate map
        for(int i = 0; i <size; i++) {
            for (int j = 0; j < size; j++) {
                playerMap[i][j] = 'B';
            }
        }
    }

    public void update(){
        this.playerMap = team.mapState;
        GenerateHtmlFile();
    }
}
