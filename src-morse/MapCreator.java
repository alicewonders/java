import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class MapCreator {
    public static void createForCode(BufferedReader reader, Map<String, String> alpM) {
        try {
            String curLine;
            while ((curLine = reader.readLine()) != null) {
                String[] info = curLine.split(" ");
                alpM.put(info[0], info[1]);
            }
        } catch (IOException exception) {
            System.err.println("Error while reading file: " + exception.getLocalizedMessage());
        }
    }

    public static void createForDecode(BufferedReader reader, Map<String, String> alpM) {
        try {
            String curLine;
            while ((curLine = reader.readLine()) != null) {
                String[] info = curLine.split(" ");
                alpM.put(info[1], info[0]);
            }
        } catch (IOException exception) {
            System.err.println("Error while reading file: " + exception.getLocalizedMessage());
        }
    }

    public static void createForCurrSymbs(BufferedReader reader, TreeMap<String, Integer> freqMap) {
        int amountOfWords = 0;
        try {
            int currSymb = reader.read();
            Integer value;
            char currSymb1 = (char) currSymb;
            while (true) {
                if (currSymb == -1)
                    break;
                if (currSymb == 13) {
                    currSymb = reader.read();
                    if (currSymb == 10)
                    currSymb = reader.read();
                    if (currSymb == -1)
                        break;
                    currSymb1 = (char) currSymb;
                }
                value = freqMap.get(Character.toString(currSymb1));
                if (value == null){
                    freqMap.put(Character.toString(currSymb1), 1);
                    amountOfWords++;

                } else {
                    freqMap.put(Character.toString(currSymb1), freqMap.get(Character.toString(currSymb1)) + 1);
                    amountOfWords++;
                }
                currSymb = reader.read();
                if (currSymb == 32)
                   currSymb = reader.read();
                currSymb1 = (char) currSymb;
            }
        } catch (IOException exception) {
            System.err.println("Error!");
        }
        finally {
            MyFileWriter.freqWrite(freqMap, amountOfWords);
        }
    }
}
