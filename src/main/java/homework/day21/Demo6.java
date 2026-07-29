package homework.day21;

import java.io.*;

public class Demo6 {

    public static void decodeFile(File decodingFile, File decodedFile) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(decodingFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFile, true));

        int readData;
        while ((readData = reader.read()) != -1){
            char c = (char) readData;
            if(Character.isDigit(c)){
                if(c != '0'){
                    writer.write((char) (c - 1));
                }else {
                    writer.write((char) (c + 9));
                }
            } else if (('a' < c && c <= 'z') || ('A' < c && c <= 'Z')) {
                writer.write((char) (c - 1));

            }else if(c == 'a' || c == 'A'){
                writer.write((char) (c + 25));
            }
            else writer.write(c);
        }

        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        File decodingFile = new File("testjava/e2.txt");
        File decodedFile = new File("testjava/f1.txt");
        decodeFile(decodingFile, decodedFile);
    }
}
