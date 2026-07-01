package day19;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo4 {
    private static void initDir(String path) throws IOException {
        StringBuilder sb = new StringBuilder(path);
        if(new File(path).mkdir()){
            System.out.println("创建"+ path +"目录成功！");
            if(new File(sb + "/a1").mkdir()){
                if(new File(sb + "/a2").mkdir()){
                    if(new File(sb + "/b1").mkdir()){
                        if(new File(sb + "/b2").mkdir()){
                            if(new File(sb + "/a3.txt").createNewFile()){
                                if(new File(sb + "/b3.txt").createNewFile()){
                                    if(new File(sb + "/a4.py").createNewFile()){
                                        if(new File(sb + "/b4.cpp").createNewFile()){
                                            System.out.println("初始化测试目录完成！");
                                            File[] files = new File(path).listFiles();
                                            System.out.println(Arrays.toString(files));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        String path = "test";
        initDir(path);
        File file = new File(path);
        File[] f1 = file.listFiles(pathname -> {
            if(pathname.isDirectory()){
                return pathname.getName().contains("a");
            }
            return false;
        });
        System.out.println(Arrays.toString(f1));

        File[] f2 = file.listFiles(pathname -> {
            if(pathname.isFile()){
                return pathname.getName().endsWith(".txt");
            }
            return false;
        });
        System.out.println(Arrays.toString(f2));

        File[] f3 = file.listFiles(pathname -> {
            if(pathname.isFile()){
                return pathname.getName().startsWith("a");
            }
            return false;
        });
        System.out.println(Arrays.toString(f3));
    }
}
