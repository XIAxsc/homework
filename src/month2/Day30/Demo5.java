package month2.Day30;

import java.util.*;

public class Demo5 {
    public static void main(String[] args) {
        // ----- 创建班主任数据 -----
        List<Teacher> teachers = Arrays.asList(
                new Teacher(101, "张老师", 35),
                new Teacher(102, "李老师", 42),
                new Teacher(103, "王老师", 28)
        );

        // ----- 创建学生数据（通过 teacherId 关联班主任） -----
        List<Student> students = Arrays.asList(
                new Student(1, "小明", 18, 101),
                new Student(2, "小红", 17, 101),
                new Student(3, "小刚", 19, 102),
                new Student(4, "小丽", 18, 103),
                new Student(5, "小华", 20, 102),
                new Student(6, "小梅", 18, 101)
        );

        HashMap<Integer, List<Student>> studentsMap = new HashMap<>();
        for (Student student : students) {
            List<Student> studentList = studentsMap.get(student.getTeacherId());
            if (studentList == null) {
                studentList = new ArrayList<>();
            }
            studentList.add(student);
            studentsMap.put(student.getTeacherId(), studentList);
        }
        ArrayList<Grade> grades = new ArrayList<>();
        for (Teacher teacher : teachers) {
            Grade grade = new Grade(teacher, studentsMap.get(teacher.getId()));
            grades.add(grade);
            System.out.println(grade.teacher);
            System.out.println(grade.students);
        }

        // HashMap<Teacher, List<Student>> gradeMap = new HashMap<>();
        // for (Teacher teacher : teachers) {
        //     List<Student> gradeStudents = new ArrayList<>();
        //     for (Student student : students) {
        //         if (student.getTeacherId() == teacher.getId()) {
        //             gradeStudents.add(student);
        //             gradeMap.put(teacher, gradeStudents);
        //         }
        //     }
        // }
        //
        // Set<Teacher> teacherSet = gradeMap.keySet();
        // for (Teacher teacher : teacherSet) {
        //     Grade grade = new Grade(teacher, gradeMap.get(teacher));
        //     grades.add(grade);
        //     System.out.println(grade.teacher);
        //     System.out.println(grade.students);
        // }
    }
}

class Grade {
    Teacher teacher;
    List<Student> students;

    public Grade(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private int teacherId;  // 所属班主任的 ID

    public Student(int id, String name, int age, int teacherId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teacherId = teacherId;
    }

    // Getter 和 Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, teacherId=%d}",
                id, name, age, teacherId);
    }
}

class Teacher {
    private int id;
    private String name;
    private int age;

    public Teacher(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter 和 Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Teacher{id=%d, name='%s', age=%d}", id, name, age);
    }
}
