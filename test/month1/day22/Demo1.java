package month1.day21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test/a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("test/a.txt", true));

        int oddCount = 0;
        int evenCount = 0;
        int readData = -1;
        while ((readData = br.read()) != -1) {
            if (Character.getNumericValue((char) readData) % 2 == 0 ) {
                evenCount += 1;
            } else {
                oddCount += 1;
            }
        }
        bw.newLine();
        bw.write("偶数个数：" + evenCount);
        bw.newLine();
        bw.write("奇数个数：" + oddCount);

        br.close();
        bw.close();
    }
}
