package homework.day21;

import java.io.*;
import java.util.Arrays;

public class Demo3 {
    private static String[] searchJava(File dir) {
        File[] files = dir.listFiles();
        String[] java = new String[files.length];
        int i = 0;

        for (File file : files) {
            // 判断如果是文件
            if (file.isFile()) {
                // 再判断是否是.java文件
                if (file.getName().endsWith(".java")) {
                    // 如果是 输出绝对路径
                    java[i] = file.getName();
                    i += 1;
                }

            }
            else {
                // 如果是目录
                // 递归
                searchJava(file);
            }

        }
        return java;
    }

    private static void cloneFiles(String srcPath, String targetPath) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetPath,true));

        String s;
        while ((s = reader.readLine()) != null){
            writer.write(s);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws Exception{
        String path = "src/month1/day18";
        String targetPath = "testjava/c";
        File file = new File(path);
        String[] javas = searchJava(file);
        System.out.println(Arrays.toString(javas));

        for (String java : javas) {
            cloneFiles(path + "/" +java,targetPath +"/" + java);
        }
    }
}
