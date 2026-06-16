package day8.account;

public class Account {
    private String userName;
    private String password;
    private double balance;

    public void setUserName(String userName) {
        if (4 > userName.length() || userName.length() > 6) {
            System.out.println("抱歉，您输入的用户名长度不规范（请输入4~6位长度的用户名）");
            return;
        }
        this.userName = userName;
    }

    public void setPassword(String password) {
        if (password.length() != 6) {
            System.out.println("抱歉，您输入的密码长度不规范（请输入六位密码）");
            return;
        }
        this.password = password;
    }

    public void setBalance(double balance) {
        if(balance <= 100){
            System.out.println("抱歉，您输入的余额太小（请输入大于一百的值）");
            return;
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
        Account a1 = new Account();
        a1.setBalance(100);
        a1.setUserName("hello world");
        a1.setPassword("1234567");
        System.out.println(a1);
        Account a2 = new Account();
        a2.setUserName("RWKK");
        a2.setPassword("JGBYA!");
        a2.setBalance(114514);
        System.out.println(a2);
    }
}
