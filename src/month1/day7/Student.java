package month1.day7;

public class Student {
    String name;
    int stuId;
    String gender;
    int age;
    double score;

    public Student() {
    }

    public Student(String name, int stuId, String gender, int age, double score) {
        this.name = name;
        this.stuId = stuId;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void print() {
        System.out.print("name=" + name + " ");
        System.out.print("stuId=" + stuId + " ");
        System.out.print("gender='" + gender + " ");
        System.out.print("age=" + age + " ");
        System.out.println("score=" + score);
    }

    public static void main(String[] args) {
        Student stu1 = new Student("张三",1001,"男",18,10);
        Student stu2 = new Student("李四",1002,"男",19,20);
        Student stu3 = new Student("王五",1003,"男",20,30);
        Student stu4 = new Student("赵六",1004,"男",30,40);
        Student stu5 = new Student("刘七",1005,"男",70,50);

        Student[] stu = {stu1,stu2,stu3,stu4,stu5};
        double totalScore = 0.0;

        for(Student student:stu){
            student.print();
            totalScore += student.score;
        }

        double average = totalScore / 5;

        System.out.println("这五个学生的Java成绩平均值：" + average);
    }

}
