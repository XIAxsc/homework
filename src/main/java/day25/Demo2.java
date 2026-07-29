package main.java.day25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo2 {

    public static void callTargetMethod(String configFilePath) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Properties props = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(configFilePath))) {
            props.load(reader);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String className = props.getProperty("className");
        String methodName = props.getProperty("methodName");

        Class clazz = Class.forName(className);
        Object o = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getDeclaredMethod(methodName);
        Object result = method.invoke(o);


        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);
        System.out.println("result = " + result);
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        callTargetMethod("testjava/day25/config.properties");
    }
}
