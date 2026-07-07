package month1.day22;

import java.io.*;

public class Demo4 {
    public static void main(String[] args) {
        clone c1 = new clone("t1", "src/month1/day21/Demo1.java", "test/day22/Demo1.java");
        clone c2 = new clone("t2", "src/month1/day21/Demo2.java", "test/day22/Demo2.java");
        clone c3 = new clone("t3", "src/month1/day21/Demo3.java", "test/day22/Demo3.java");

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
    }
}

class clone2 implements Runnable {
    String name;
    String srcPath;
    String targetPath;

    public clone2(String name, String srcPath, String targetPath) {
        this.name = name;
        this.srcPath = srcPath;
        this.targetPath = targetPath;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcPath));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetPath, true));

            File file = new File(srcPath);
            long srcLength = file.length();

            int readCount = -1;
            long clonedLength = 0;
            byte[] bytes = new byte[10];
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);
                out.flush();
                clonedLength += readCount;
                double per = (double) clonedLength / (double) srcLength * 100.0;
                System.out.println("线程" + name + ":" + srcPath + "文件已复制" + per + "%");
            }
            System.out.println(srcPath + "文件复制完成");

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}