package month1.day20;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) {
        String[] words = {"verb:eat", "verb:drink", "verb:sleep", "verb:play",
                "noun:rice", "noun:meat", "noun:hand", "noun:hair"};
        String[][] newWords = new String[words.length][];
        for (int i = 0; i < words.length; i++) {
            newWords[i] = words[i].split(":");
        }
        for (String[] newWord : newWords) {
            StringBuilder folder = new StringBuilder("test/");
            StringBuilder path = folder.append(newWord[0]).append(".txt");
            try (FileOutputStream out = new FileOutputStream(String.valueOf(path), true)) {
                byte[] bytes1 = newWord[0].getBytes();
                byte[] bytes2 = ":".getBytes();
                byte[] bytes3 = newWord[1].getBytes();
                out.write(bytes1);
                out.write(bytes2);
                out.write(bytes3);
                out.write("\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
