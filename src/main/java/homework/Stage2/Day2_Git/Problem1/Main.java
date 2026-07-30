package homework.Stage2.Day2_Git.Problem1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Class> animalClasses = Arrays.asList(Cat.class, Dog.class, Pig.class, Tiger.class);
        // 找到 所有的包含@Flag注解的类，打印注解中的value属性值
        for (Class animal : animalClasses) {
            if (animal.isAnnotationPresent(Flag.class)) {
                Flag annotation = (Flag) animal.getAnnotation(Flag.class);
                System.out.println("annotation.value() = " + annotation.value());
            }
        }
    }
}

