package main.java.day26;

import java.lang.reflect.InvocationTargetException;

public class Demo4 {
}

// 业务类
class UserService extends LoggedService {

    private String getUserInfo(int userId) {  // 测试私有方法
        return "User_" + userId;
    }

    public void deleteUser(String username) {
        System.out.println("正在删除用户: " + username);
    }

    // 通过execute调用方法，自动触发日志
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UserService service = new UserService();

        // 调用方法并记录日志（无需手动处理反射）
        service.execute("getUserInfo", 1001);  // 调用私有方法
        service.execute("deleteUser", "alice");
    }
}