import java.io.*;
import java.util.Map;

public class Decoder{
    public static void decodeToEng(Map<String, String> alpM, BufferedReader reader){
        StringBuilder resStr = new StringBuilder();
        StringBuilder word = new StringBuilder();
        try {
            String currStr;
            while ((currStr = reader.readLine()) != null){
                String[] inStr = currStr.split("       ");
                for (int i = 0; i < inStr.length; i++){
                    String[] currWord  = inStr[i].split(" ");
                    for (int j = 0; j < currWord.length; j++){
                        word.append(alpM.get(currWord[j]));
                    }
                    resStr = resStr.append(word).append(" ");
                    word.setLength(0);
                }
                resStr = resStr.append("\r\n");
            }
        } catch(IOException exception){
            System.err.println("Error!");
        }
        finally {
            MyFileWriter.write(resStr.toString());
        }
    }

}