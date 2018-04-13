package TreasureHuntGame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLGenerator {

    public HTMLGenerator(){}

    public void GenerateHTMLPlayerFile(char[][]map, String playerName, Position position) throws IOException{
        String fileName = playerName + "_HTML_File.html";
        File htmlFile = new File(fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        WriteToFile(bw, map, playerName, position);
    }

    private void WriteToFile(BufferedWriter bw, char[][]map, String playerName, Position position) throws IOException{
        bw.write("<!DOCTYPE html>\n");
        bw.write("<html>\n");
        bw.write("<body>\n");
        bw.write("  <h1>"+playerName+"</h1>\n");
        bw.write("  <table style=\"height:300px; width:300px;\">\n");
        for(int i = 0; i<map.length; i++){
            bw.write("  <tr>\n");
            for(int j = 0; j<map.length; j++){
                if(position.x == i && position.y == j){
                    //mark the current player's position as a red tile
                    bw.write("      <td bgcolor = ##FF0000></td>\n");
                }
                else {
                    bw.write("      <td " + GetColour(map[i][j]) + "></td>\n");
                }
            }
        }
        bw.write("  </table>\n");
        bw.write("</body>\n");
        bw.write("</html>\n");
        bw.close();
    }

    private String GetColour(char colour){
        switch(colour){
            case 'G':
                return "bgcolor = #00FF00";
            case 'W':
                return "bgcolor = #00FFFF";
            case 'T':
                return "bgcolor = #FFFF00";
            case 'B':
                return "bgcolor = #000000";
            default:
            break;
        }
        return "";
    }

}
