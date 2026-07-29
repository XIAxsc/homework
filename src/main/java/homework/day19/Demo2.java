package homework.day19;

import java.util.Scanner;

public class Demo2 {
    private static final int passwordLength = 6;
    public static void main(String[] args) {
        try {
            registration();
        } catch (RegistrationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean rightMail(String s){
        for (int i = 0; i < s.length(); i++) {
            if(!s.contains("@")){
                return false;
            }
        }
        return true;
    }

    private static boolean isDigit(String s){
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(!Character.isDigit(a)){
                return false;
            }
        }
        return true;
    }

    private static void registration() throws RegistrationException {
        try {
            inputMassage();
            // 进行支付处理
            System.out.println("注册成功！");
        } catch (EmailValidationException | PasswordValidationException e) {
            // 捕获到银行卡验证异常，向用户提供具体的错误信息
            throw new RegistrationException("注册失败: " + e.getMessage() + " 请检查您的注册信息并重试。");
        }
    }

    private static void inputMassage() throws EmailValidationException,PasswordValidationException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入邮箱：");
        String mail = sc.nextLine();
        if(mail == null || mail.isEmpty()){
            throw new EmailValidationException("邮箱错误");
        }
        if (!rightMail(mail)) {
            throw  new EmailValidationException("邮箱内容错误");
        }

        System.out.print("请输入密码：");
        String password = sc.nextLine();
        if(password == null || password.isEmpty()){
            throw new PasswordValidationException("密码格式错误");
        }
        if (password.length() != passwordLength) {
            throw new PasswordValidationException("密码位数错误");
        }
        if (!isDigit(password)) {
            throw  new PasswordValidationException("密码内容错误");
        }
    }
}

class RegistrationException extends Exception {
    public RegistrationException(String message) {
        super(message);
    }
}

class EmailValidationException extends Exception {
    public EmailValidationException(String message) {
        super(message);
    }
}
class PasswordValidationException extends Exception {
    public PasswordValidationException(String message) {
        super(message);
    }
}
