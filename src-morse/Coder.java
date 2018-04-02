import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Coder {
    public static void codeToMorse(Map<String, String> morseAlp, BufferedReader reader) {
        StringBuilder resStr = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try {
            String currStr;
            while ((currStr = reader.readLine()) != null) {
                String[] input = currStr.split(" +"); //+ means that it will be ignored more than one space
                for (int i = 0; i < input.length; i++) {
                    String word = input[i];
                    for (int j = 0; j < word.length(); j++) {
                        char letter = word.charAt(j);
                        if(morseAlp.get(Character.toString(letter).toLowerCase()) != null) {
                            resStr.append(morseAlp.get(Character.toString(letter).toLowerCase()));
                            resStr.append(" ");
                        }
                    }
                    resStr.append("      ");
                }
                String tmpStr = resStr.toString();
                resStr.setLength(0);

                result = result.append(tmpStr).append("\r\n");
            }
        } catch (IOException exception) {
            System.err.println("Error!");
        }
        finally {
            MyFileWriter.write(result.toString());
            //...
        }
    }

    public static void main(String[] args) {
        Map<String, String> morseCodes = new HashMap<String, String>();

    }
}
