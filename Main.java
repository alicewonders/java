import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] input = new String[2];
        for (int i = 0; i < input.length; i++){
            input[i] = in.next();
        }
        MyFileReader.read(input[0], input[1]);
    }
}
