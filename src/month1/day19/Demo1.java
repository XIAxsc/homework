package month1.day19;

import java.util.Scanner;

public class Demo1 {
    private static int cardLength = 10;
    private static int passwordLength = 6;
    public static void main(String[] args) {
        try {
            processPayment();
        } catch (PaymentProcessingException e) {
            System.out.println(e.getMessage());
        }
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

    public static void processPayment() throws PaymentProcessingException {
        try {
            inputMassage();
            // 进行支付处理
            System.out.println("Payment processed successfully.");
        } catch (InvalidCreditCardException e) {
            // 捕获到银行卡验证异常，向用户提供具体的错误信息
            throw new PaymentProcessingException("支付失败: " + e.getMessage() + " 请检查您的卡信息并重试。");
        }
    }

    private static void inputMassage() throws InvalidCreditCardException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入信用卡号：");
        String cardNumber = sc.nextLine();
        if(cardNumber == null || cardNumber.isEmpty()){
            throw new InvalidCreditCardException("信用卡号格式错误");
        }
        if (cardNumber.length() != cardLength) {
            throw new InvalidCreditCardException("信用卡号长度错误");
        }
        if (!isDigit(cardNumber)) {
            throw  new InvalidCreditCardException("信用卡内容错误");
        }

        System.out.print("请输入密码：");
        String password = sc.nextLine();
        if(password == null || password.isEmpty()){
            throw new InvalidCreditCardException("密码格式错误");
        }
        if (password.length() != passwordLength) {
            throw new InvalidCreditCardException("密码位数错误");
        }
        if (!isDigit(password)) {
            throw  new InvalidCreditCardException("密码内容错误");
        }
    }
}

class PaymentProcessingException extends Exception {
    public PaymentProcessingException(String message) {
        super(message);
    }
}

class InvalidCreditCardException extends Exception {
    public InvalidCreditCardException(String message) {
        super(message);
    }
}
class RException extends RuntimeException {
    public RException(String message) {
        super(message);
    }
}