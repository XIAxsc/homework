package demos;

import utils.Student;
import utils.StudentUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOperation_1 {
    public static void main(String[] args) {
        // 年龄大于20的学生
        List<Student> studentList = StudentUtil.getStudentList();
        studentList.stream()
                .filter(student -> student.getAddress() == Student.Address.BJ && student.getAge() > 20)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // 只取出北京的人
        long countBJ = studentList.stream()
                .filter(s -> s.getAddress() == Student.Address.BJ)
                .count();
        long countDistinctBJ = studentList.stream()
                .filter(s -> s.getAddress() == Student.Address.BJ)
                .distinct()
                .count();
        System.out.println("去重前：" + countBJ + "\n去重后：" + countDistinctBJ);

        System.out.println("----------------------------------------------------");

        // limit限制输出的数量
        studentList.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // skip跳过前几个元素
        studentList.stream()
                .skip(4)
                .distinct()
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // map转换类型
        studentList.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // sorted排序
        studentList.stream()
                .filter(s -> s.getHeight() > 180)
                .sorted((s1, s2) -> s1.getHeight() - s2.getHeight())
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // anyMatch获取是否有任意一个匹配，返回结果（true，false）
        System.out.println(studentList.stream().anyMatch(s -> s.getHeight() > 200));

        System.out.println("----------------------------------------------------");

        // allMatch是否全都匹配，结果为（true，false）
        System.out.println(studentList.stream().allMatch(s -> s.getAge() < 30));

        System.out.println("----------------------------------------------------");

        // noneMatch是否没有一个匹配，结果为（true，false）
        System.out.println(studentList.stream().noneMatch(s -> s.getAddress() == Student.Address.SZ));

        System.out.println("----------------------------------------------------");

        // findAny返回任意一个流中的元素，默认第一个
        // findFirst返回第一个元素
        Optional<Student> any = studentList.stream().findAny();
        any.ifPresent(System.out::println);

        System.out.println("----------------------------------------------------");

        // forEach遍历流
        studentList.stream().forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        // count计数返回流中元素的个数
        System.out.println(studentList.stream().count());

        System.out.println("----------------------------------------------------");

        // reduce计算汇总元素，如求和，求最大最小值等
        // 就是逐个比较前后两个元素得到新的元素（新元素可以是这两个元素之一），然后再和下一个元素运算
        System.out.println(studentList.stream().reduce((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2));

        System.out.println("----------------------------------------------------");

        // collect收集器，将流到此处的元素收集到一个容器（集合类）中
        Map<String, Student> collect = studentList.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getName, student -> student));
        collect.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
