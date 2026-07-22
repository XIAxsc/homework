package test.mysql;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo1 {
    public static void main(String[] args) throws Exception {

        DriverManager.registerDriver(new Driver());

        //        String url = "协议 + ip + 端口 + 路径 + 参数";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        // 2. 发送用户名和密码，建立连接
        // 返回的当前是一个Connection接口，但是实际上在运行的时候，返回是Connection接口的实现类的实例
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 获取statement对象
        Statement statement = connection.createStatement();

        // 4. 发送SQL语句
        ResultSet resultSet = statement.executeQuery("select * from test.user");

        // 5. 解析结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password_col = resultSet.getString("password");
            System.out.println("id: " + id + ", name: " + name + ", password: " + password_col);
        }

        // 6. 断开连接
        statement.close();
        connection.close();
    }
}
