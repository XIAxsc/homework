package main.java.day21;

import java.io.*;

public class Demo5_1
 {

    public static void main(String[] args) {
        String inputFile = "testjava/e1.txt";   // 原文件路径
        String outputFile = "testjava/e3.txt"; // 加密后文件路径

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                char encrypted = encryptChar((char) ch);
                writer.write(encrypted);
            }

            System.out.println("加密完成，结果已写入：" + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对单个字符进行加密（仅处理字母和数字，其他原样返回）
     */
    private static char encryptChar(char c) {
        // 处理小写字母
        if (c >= 'a' && c <= 'z') {
            if (c == 'z') {
                return 'a';          // z → a
            } else {
                return (char) (c + 1); // a→b, ..., y→z
            }
        }
        // 处理大写字母
        else if (c >= 'A' && c <= 'Z') {
            if (c == 'Z') {
                return 'A';          // Z → Z（保持不变）
            } else {
                return (char) (c + 1); // A→B, ..., Y→Z
            }
        }
        // 处理数字
        else if (c >= '0' && c <= '9') {
            if (c == '9') {
                return '0';          // 9 → 0
            } else {
                return (char) (c + 1); // 0→1, ..., 8→9
            }
        }
        // 其他字符（包括中文、符号等）原样返回
        else {
            return c;
        }
    }
}