package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private JDBCUtils() {
    }

    static String driverClassName;
    static String url;
    static String username;
    static String password;


    // 通过静态代码块，读取配置文件
    static {

        // 1. 创建一个Properties对象
        Properties properties = new Properties();

        // 2. 加载文件
        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 3. 获取配置
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driverClassName = properties.getProperty("class");

        // System.out.println("url = " + url);
        // System.out.println("username = " + username);
        // System.out.println("password = " + password);
        // System.out.println("driverClassName = " + driverClassName);


    }

    // 1. 获取连接
    public static Connection getConnection() {

        try {
            // 1. 注册驱动
            // DriverManager.registerDriver(new Driver());
            // new Driver();
            // Driver.class;
            Class.forName(driverClassName);


            Connection connection = DriverManager.getConnection(url, username, password);

            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 2. 关闭资源
    public static void closeConnection(ResultSet rs, Statement statement, Connection conn) {

        // try {
        //     if (rs != null) rs.close();
        // } catch (SQLException e) {
        //     throw new RuntimeException(e);
        // }finally {
        //     try {
        //         if (statement != null) statement.close();
        //     } catch (SQLException e) {
        //         throw new RuntimeException(e);
        //     }finally {
        //         try {
        //             if (conn != null) conn.close();
        //         }catch (Exception e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }

        try {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
