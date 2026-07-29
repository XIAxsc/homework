package homework.day21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("testjava/d1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("testjava/d2.txt", true));

        String line;
        while ((line = reader.readLine()) != null){
            writer.write(String.valueOf((new StringBuilder(line).reverse())));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
