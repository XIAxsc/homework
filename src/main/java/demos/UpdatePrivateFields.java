package demos;

import java.lang.reflect.Field;

public class UpdatePrivateFields {
    public static void main(String[] args) {
        Student student = new Student();
        try {
            Field field = Student.class.getDeclaredField("score");
            field.setAccessible(true);
            System.out.println(field.get(student));
            field.set(student, 100);
            System.out.println(field.get(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private int score = 60;
}
