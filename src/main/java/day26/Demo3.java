package main.java.day26;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Demo3 {
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Authorize {
    String role() default "user";
}

class Services {
    @Authorize(role = "admin")
    public static void deleteData() {
        System.out.println("删除数据！");
    }

    @Authorize
    public static void viewData() {
        System.out.println("访问数据！");
    }
}

class AuthorizationTest {
    public static void executeMethod(String methodName, String userRole) throws Exception {
        Class<Services> clazz = Services.class;
        Method method = clazz.getDeclaredMethod(methodName);
        if (method.isAnnotationPresent(Authorize.class)) {
            Authorize annotation = method.getAnnotation(Authorize.class);
            if (userRole.equals(annotation.role())) {
                System.out.println(userRole + "执行了" + methodName + "方法！");
                method.invoke(new Object());
            } else {
                System.out.println(userRole + "没有权限执行" + methodName + "方法！");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        executeMethod("deleteData", "user");
        executeMethod("deleteData", "admin");
        executeMethod("deleteData", "user");
        executeMethod("deleteData", "admin");
    }
}