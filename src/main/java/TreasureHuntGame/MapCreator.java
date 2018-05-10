package TreasureHuntGame;

/**
 * Created by marc on 08/05/2018.
 */
public class MapCreator {
    // Factory Method
    public Map createMap(String type){
        //Determine which creator to use
        MapCreator creator = determineMapType(type);

        return creator.create();
    }

    public MapCreator determineMapType(String type) {
        if (type.equals("Hazardous")) {
            //System.out.println("Hazard");
            return new HazardousMapCreator();
        }
        else{
            //System.out.print("Safe");
            return new SafeMapCreator();
        }
    }

    //To be overridden
    public Map create(){
        return null;
    }
}
