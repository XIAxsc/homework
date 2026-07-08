package test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        // 获取字节码文件对象
        Class<?> c = Class.forName("test.annotation.Demo1");
        // 拿到方法对象
        Method loginMethod = c.getDeclaredMethod("login");
        // 判断方法上是否使用了注解
        boolean annotationPresent = loginMethod.isAnnotationPresent(Login.class);
        if (annotationPresent) {
            // 获取注解实例
            Login loginAnnotation = loginMethod.getAnnotation(Login.class);
            // 获取属性值
            String password = loginAnnotation.password();
            String username = loginAnnotation.username();
            // 打印
            System.out.println(password);
            System.out.println(username);

        } else {
            System.out.println("没有使用注解");
        }
    }

    @Login
    public static void login() {

    }
}

// 定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Login {
    // 属性
    String username() default "admin";

    String password() default "123456";
}