package main.java.day21;

import java.io.*;

public class Demo5 {

    public static void encodeFile(File encodingFile, File encodedFile) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(encodingFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(encodedFile, true));

        int readData;
        while ((readData = reader.read()) != -1){
            char c = (char) readData;
            if(Character.isDigit(c)){
                if(c != '9'){
                    writer.write((char) (c + 1));
                }else {
                    writer.write((char) (c - 9));
                }
            } else if (('a' <= c && c < 'z') || ('A' <= c && c < 'Z')) {
                    writer.write((char) (c + 1));

            }else if(c == 'z' || c == 'Z'){
                writer.write((char) (c - 25));
            }
            else writer.write(c);
        }

        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        File encodingFile = new File("testjava/e1.txt");
        File encodedFile = new File("testjava/e2.txt");
        encodeFile(encodingFile, encodedFile);
    }
}
