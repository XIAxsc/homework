package homework.day26;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) {
        Class clazz = AnnotationTest.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Review.class)) {
                System.out.println(method.getName() + "方法使用了注解2");
                System.out.println("Review.comment = " + Review.comment);
            }
        }
    }
}

class AnnotationTest {
    @Review
    public void m1() {
        System.out.println("执行了m1方法！");
    }

    public void m2() {
        System.out.println("执行了m2方法！");
    }

    @Review
    public void m3() {
        System.out.println("执行了m3方法！");
    }

    public void m4() {
        System.out.println("执行了m4方法！");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Review {
    String comment = "Please review this method";
}
