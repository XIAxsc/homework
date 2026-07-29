package homework.day22;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) {
        clone c1 = new clone("s1", "src/month1/day21/Demo1.java", "testjava/day22/Demo1.java");
        clone c2 = new clone("s2", "src/month1/day21/Demo2.java", "testjava/day22/Demo2.java");
        clone c3 = new clone("s3", "src/month1/day21/Demo3.java", "testjava/day22/Demo3.java");

        c1.start();
        c2.start();
        c3.start();
    }
}

class clone extends Thread {
    String srcPath;
    String targetPath;

    public clone(String name, String srcPath, String targetPath) {
        super(name);
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
                System.out.println("线程" + super.getName() + ":" + srcPath + "文件已复制" + per + "%");
            }
            System.out.println(srcPath + "文件复制完成");

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
