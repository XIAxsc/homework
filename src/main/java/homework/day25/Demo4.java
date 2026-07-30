package homework.day25;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo4 {
}

// 1. 工具类 MethodLogger
class MethodLogger {
    public static Object logMethod(Object target, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException {
        // 步骤提示：
        // a. 获取 target 的 Class 对象
        Class clazz = target.getClass();

        // b. 遍历所有方法，找到名称和参数类型匹配的方法（注意处理基本类型！）
        Method[] methods = clazz.getDeclaredMethods();
        Method targetMethod = null;
        for (Method method : methods) {
            if (!methodName.equals(method.getName())) {
                continue;
            }
            Class[] parameterTypes = method.getParameterTypes();
            if (args.length != parameterTypes.length) {
                continue;
            }
            for (int i = 0; i < args.length; i++) {
                if (!(args[i].getClass() == convertToPrimitiveType(parameterTypes[i].getClass()))) {
                    break;
                }
            }
            targetMethod = method;
            break;
        }

        // c. 调用 method.invoke() 执行方法
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = dateFormat.format(date);
        Object result = targetMethod.invoke(target, args);
        // d. 记录日志（格式参考下方示例）
        // [日志] 开始调用方法: getUserInfo
        // [日志] 时间: 2025-03-06 01:24:12
        // [日志] 参数类型: [int], 参数值: [1001]
        // [日志] 返回值: User_1001
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("testjava/day25/log.txt", true))) {
            writer.write("[日志] 开始调用方法：" + methodName);
            writer.newLine();
            writer.write("[日志] 时间：" + dateString);
            writer.newLine();
            writer.write("[日志] 参数类型：" + Arrays.toString(targetMethod.getParameterTypes()) + "，参数值：" + Arrays.toString(args));
            writer.newLine();
            writer.write("[日志] 返回值：" + result);
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // 将包装类型转换为基本类型（例如 Integer.class → int.class）
    private static Class<?> convertToPrimitiveType(Class<?> clazz) {
        if (clazz == Integer.class) return int.class;
        if (clazz == Long.class) return long.class;
        if (clazz == Double.class) return double.class;
        if (clazz == Float.class) return float.class;
        if (clazz == Boolean.class) return boolean.class;
        if (clazz == Character.class) return char.class;
        if (clazz == Byte.class) return byte.class;
        if (clazz == Short.class) return short.class;
        return clazz;
    }
}

// 3. 测试类
class UserService {

    public String getUserInfo(int userId) {
        return "User_" + userId;
    }

    public void deleteUser(String username) {
        System.out.println("Deleting user: " + username);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        UserService service = new UserService();

        // 使用反射调用方法并记录日志
        MethodLogger.logMethod(service, "getUserInfo", 1001);
        MethodLogger.logMethod(service, "deleteUser", "alice");
    }
}