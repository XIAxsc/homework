package day8.staff;

public class Staff {
    String name;
    String gender;
    int id;
    int salary;

    static int firstId = 10000;

    public Staff(String name) {
        this.name = name;
        this.id = ++firstId;
    }

    public Staff(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.id = ++firstId;
    }

    public Staff(String name, String gender, int salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.id = ++firstId;
    }

    public int finalSalary(){
        return this.salary - 2000;
    }

    public void printStaff(){
        System.out.println("姓名：" + this.name + "\n"
        + "性别：" + this.gender +"\n"+"员工ID："+this.id+"\n"
        +"实际到手工资："+finalSalary());
    }

    public static void main(String[] args) {
        Staff s1 = new Staff("张三","男",6000);
        Staff s2 = new Staff("李四","男",7000);
        Staff s3 = new Staff("张姐","女",8000);
        s1.printStaff();
        s2.printStaff();
        s3.printStaff();
    }

}
