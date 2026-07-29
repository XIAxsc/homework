package demos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

// 1. 工具类 MethodLogger
class MethodLogger {
    public static Object logMethod(Object target, String methodName, Object... args) throws Exception {
        // a. 获取 target 的 Class 对象
        Class<?> targetClass = target.getClass();
        // b. 遍历所有方法，找到名称和参数类型匹配的方法（注意处理基本类型！）
        Method[] methods = targetClass.getDeclaredMethods();
        Method realMethod = null;
        int flag = 1;
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (methodName.equals(method.getName())) {
                if (args.length == method.getParameterCount()) {
                    for (int i = 0; i < args.length; i++) {
                        Class<?> argType = convertToPrimitiveType(args[i].getClass());
                        Class<?> primitiveType = convertToPrimitiveType(parameterTypes[i]);
                        if (!argType.equals(primitiveType)) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 1) {
                        realMethod = method;
                    }
                }
            }
        }
        if (realMethod == null) {
            return null;
        } else {
            // c. 调用 method.invoke() 执行方法
            realMethod.setAccessible(true);
            Object result = realMethod.invoke(target, args);
            // d. 记录日志（格式参考下方示例）

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/demos/logs.txt", true))) {
                // [日志] 开始调用方法: getUserInfo
                writer.write("[日志] 开始调用方法：" + methodName);
                writer.newLine();
                // [日志] 时间: 2025-03-06 01:24:12
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = dateFormat.format(date);
                writer.write("[日志] 时间：" + format);
                writer.newLine();
                // [日志] 参数类型: [int], 参数值: [1001]
                writer.write("[日志] 参数类型: " + Arrays.toString(realMethod.getParameterTypes()) + "，参数类型：" + Arrays.toString(args));
                writer.newLine();
                // [日志] 返回值: User_1001
                writer.write("[日志] 返回值:" + result);
                writer.newLine();
                writer.newLine();
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
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
public class UserService {

    public String getUserInfo(int userId) {
        return "User_" + userId;
    }

    public void deleteUser(String username) {
        System.out.println("Deleting user: " + username);
    }

    public static void main(String[] args) throws Exception {
        UserService service = new UserService();

        // 使用反射调用方法并记录日志
        MethodLogger.logMethod(service, "getUserInfo", 1001);
        MethodLogger.logMethod(service, "deleteUser", "alice");
    }
}
