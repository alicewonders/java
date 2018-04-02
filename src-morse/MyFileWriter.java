import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MyFileWriter {
    public static void write(String value) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("out.txt", false));
            writer.write(value);
        } catch (IOException exception) {
            System.err.println("Error while writing in file: " + exception.getLocalizedMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException exception) {
                System.err.println("Error while closing file: " + exception.getLocalizedMessage());
            }
        }

    }

    public static void freqWrite(TreeMap<String, Integer> freqMap, int amountOfWords) {
        FileWriter writer = null;
        Map<String, Integer> check = null;
        try {
            writer = new FileWriter("freqout.txt", false);

            for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                DecimalFormat df = new DecimalFormat("#.##");
                writer.append(entry.getKey())
                        .append(" ")
                        .append(String.valueOf(entry.getValue()))
                        .append(" ")
                        .append(String.valueOf(df.format(entry.getValue() * 1.0 / amountOfWords)))
                        .append("\r")
                        .append("\n");
            }
        } catch (IOException exception) {
            System.err.println("Error!");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
