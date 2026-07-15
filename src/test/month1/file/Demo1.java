package test.month1.file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test/month1/file", "demo1.py");
        System.out.println(file1.exists());
        if (!file1.exists()) {
            if (file1.isFile()) {
                file1.createNewFile();
            } else throw new demo1exception("该路径不存在");
        }
        System.out.println(file1);
    }
}

class demo1exception extends IOException {
    public demo1exception(String message) {
        super(message);
    }
}