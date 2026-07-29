package homework.day26;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Demo2 {
    public static void main(String[] args) {
        Class<test> testClass = test.class;
        Class<testImpl> testImplClass = testImpl.class;

        if (testClass.isAnnotationPresent(Config.class)) {
            Config testClassAnnotation = testClass.getAnnotation(Config.class);
            System.out.println("test: " + testClassAnnotation.value());
        }
        if (testImplClass.isAnnotationPresent(Config.class)) {
            Config testImplClassAnnotation = testImplClass.getAnnotation(Config.class);
            System.out.println("testImpl: " + testImplClassAnnotation.value());
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@interface Config {
    String value() default "";
}

@Config(value = "interface")
interface test {
    void invoke();
}

@Config(value = "implement class")
class testImpl implements test {
    @Override
    public void invoke() {
        System.out.println("testImpl类执行了方法！");
    }
}