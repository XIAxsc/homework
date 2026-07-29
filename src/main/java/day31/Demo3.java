package main.java.day31;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 筛选出年龄大于 18的学生；
 * 按分数降序排序；
 * 只提取学生姓名，收集成 List<String>；
 * 统计所有学生的平均分。
 */
public class Demo3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("小明", 18, 60D),
                new Student("小红", 17, 80D),
                new Student("小刚", 19, 50D),
                new Student("小丽", 18, 88D),
                new Student("小华", 20, 95D),
                new Student("小梅", 18, 100D)
        );
        // students.forEach(System.out::println);

        // 筛选出年龄大于 18的学生；
        System.out.println("===年龄大于18的学生===");
        students.stream()
                .filter(s -> s.getAge() > 18)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 按分数降序排序
        System.out.println("\n===按分数降序排序===");
        students.stream()
                .sorted((s1, s2) -> (int) (s2.getScore() - s1.getScore()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 只提取学生姓名，收集成 List<String>
        System.out.println("\n===只提取学生姓名，收集成 List<String>===");
        System.out.println(students.stream()
                .map(Student::getName)
                .collect(Collectors.toList()));

        // 统计所有学生的平均分
        System.out.println("\n===统计所有学生的平均分===");
        System.out.println(students.stream()
                .map(Student::getScore)
                .reduce(Double::sum).get() / students.size());
    }
}

class Student {
    String name;
    Integer age;
    Double score;

    public Student(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
