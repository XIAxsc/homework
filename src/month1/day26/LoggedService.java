package month1.day26;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

// 抽象父类
public abstract class LoggedService {
    // 供子类调用的入口方法：通过方法名和参数调用实际方法，并自动记录日志
    protected Object execute(String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = UserService.class;

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
                if (!(args[i].getClass() == parameterTypes[i].getClass())) {
                    break;
                }
            }
            targetMethod = method;
            break;
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = dateFormat.format(date);

        targetMethod.setAccessible(true);
        Object result = targetMethod.invoke(this, args);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test/day26/log.txt", true))) {
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

        return null;
    }
}
