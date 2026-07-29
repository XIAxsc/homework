package day21;

import java.io.BufferedReader;
import java.io.FileReader;

public class Demo7 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("testjava/g1.txt"));

        int readCount = -1;
        int numCount = 0;
        int letterCount = 0;
        int spaceCount = 0;
        while ((readCount = reader.read()) != -1){
            char c = (char) readCount;
            if(Character.isLetter(readCount)){
                letterCount += 1;
            } else if (Character.isDigit(readCount)) {
                numCount += 1;
            } else if (c == ' ') {
                spaceCount += 1;
            }
        }

        reader.close();

        System.out.println("中英文字母个数：" + letterCount + "\n" +
                "空格的个数：" + spaceCount + "\n" + "数字字符的个数：" + numCount);
    }
}
