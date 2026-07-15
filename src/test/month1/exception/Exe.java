package test.month1.exception;

public class Exe {
    private static int cardLength = 10;
    private static int passwordLength = 6;

    public static void main(String[] args) {
        try {
            processPayment("1234567890", "111111");
        } catch (PaymentProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processPayment(String cardNumber, String password) throws PaymentProcessingException {
        try {
            validateCreditCard(cardNumber, password);
            // 进行支付处理
            System.out.println("Payment processed successfully.");
        } catch (InvalidCreditCardException e) {
            // 捕获到银行卡验证异常，向用户提供具体的错误信息
            throw new PaymentProcessingException("支付失败: " + e.getMessage() + " 请检查您的卡信息并重试。");
        }
    }

    private static void validateCreditCard(String cardNumber, String password) throws InvalidCreditCardException {
        if (cardNumber.length() != cardLength) {
            throw new InvalidCreditCardException("信用卡号格式错误");
        }
        if (password.length() != passwordLength) {
            throw new InvalidCreditCardException("密码位数错误");
        }
        // 假设这里还有更多的验证逻辑
        // .....
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