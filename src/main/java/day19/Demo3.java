package main.java.day19;

import java.io.File;

public class Demo3 {

    public static void main(String[] args) {
        String mainPath = "testjava";
        File mainDir = new File(mainPath);
        if (mainDir.mkdir()) {
            System.out.println("一级目录" + mainDir.getName() + "创建成功！");
            if (new File("testjava/test2").mkdir()) {
                System.out.println("二级目录创建成功！");
                if (new File("testjava/test2/test3").mkdir()) {
                    System.out.println("三级目录创建成功！");
                }
            }
            if (new File("testjava/test4").mkdir()) {
                System.out.println("二级目录创建成功！");
            }
        }

        if(deleteDir(mainPath)){
            System.out.println("删除成功！");
        }

    }

    private static boolean deleteDir(String path) {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("目录" + file.getName() + "已被删除");
            return true;
        }

        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            deleteDir(f.getAbsolutePath());
        }
        if (file.delete()) {
            System.out.println("目录" + file.getName() + "已被删除");
            return true;
        }
        return false;
    }
}
