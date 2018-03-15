import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class MapCreator{
    public static void createForCode(BufferedReader reader, Map<String, String> alpM) {
        try{
            String curLine;
            while ((curLine = reader.readLine()) != null){
                String[] info = curLine.split(" ");
                alpM.put(info[0], info[1]);
            }
        }
        catch(IOException exception){
            System.err.println("Error while reading file: " + exception.getLocalizedMessage());
        }
    }

    public static void createForDecode(BufferedReader reader, Map<String, String> alpM){
        try{
            String curLine;
            while ((curLine = reader.readLine()) != null){
                String[] info = curLine.split(" ");
                alpM.put(info[1], info[0]);
            }
        }
        catch(IOException exception){
            System.err.println("Error while reading file: " + exception.getLocalizedMessage());
        }
    }
}
