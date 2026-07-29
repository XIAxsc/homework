package main.java.day7;

public class Account {
    public static int id = 10001;
    public String password = "000000";
    public double balance = 0;
    public static double rate = 0.003;

    public Account() {
        id++;
    }

    public Account(String password) {
        this.password = password;
        id++;
    }

    public Account(double balance) {
        this.balance = balance;
        id++;
    }

    public Account(String password, int balance) {
        this.password = password;
        this.balance = balance;
        id++;
    }

    public double income(double year) {
        return this.balance + year * rate * balance;
    }

    public void print(){
        System.out.print("id = " + id + " ");
        System.out.print("password = " + password+ " ");
        System.out.print("balance = " + balance+ " ");
        System.out.println("rate = " + rate);
    }

    public static void main(String[] args) {
        Account user1 = new Account("123456", 10000);
        Account user2 = new Account(2000);
        double year1 = 3;
        double year2 = 10;

        System.out.println("user1在" + year1 +"年后的余额：" + user1.income(year1));
        System.out.println("user2在" + year2 +"年后的余额：" + user2.income(year2));
    }

}
