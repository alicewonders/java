import java.io.*;

public class MyFileWriter {
    public static void write(String value){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter("out.txt", false));
            writer.write(value);
        } catch(IOException exception){
            System.err.println("Error while writing in file: " + exception.getLocalizedMessage());
        } finally {
            try{
                if (writer != null){
                    writer.close();
                }
            } catch (IOException exception){
                System.err.println("Error while closing file: " + exception.getLocalizedMessage());
            }
        }

    }
    public static void main(String[] args) {

    }
}
