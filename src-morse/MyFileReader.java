import java.io.*;
import java.net.SocketPermission;
import java.util.HashMap;
import java.util.Map;

public class MyFileReader {
    public static void read(String mode, String name) {
        BufferedReader reader = null;
        BufferedReader freader = null;
        Map<String, String> morseAlpEng = new HashMap<>();
        Map<String, String> morseAlpEngInvert = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader("alphabet.txt"));
            freader = new BufferedReader(new FileReader(name));
//            System.out.printf("File %s was opened successfully\n", name);
            switch (mode) {
                case "code":
                    MapCreator.createForCode(reader, morseAlpEng);
                    Coder.codeToMorse(morseAlpEng, freader);
                    break;
                case "decode":
                    MapCreator.createForDecode(reader, morseAlpEngInvert);
                    Decoder.decodeToEng(morseAlpEngInvert, freader);
                    break;
            }
//            System.out.println("Map was created successfully");
        } catch (FileNotFoundException exception) {
            System.err.println("Error!\n");
            System.out.printf("Couldn't find file %s\n", name);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException exception) {
                System.err.println("Error!\n");
            }
        }
    }
}