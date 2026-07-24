package test.mysql;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class demo2 {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());

        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);


        PreparedStatement preparedStatement = connection.prepareStatement("select * from city");

        Statement statement = connection.createStatement();

        int affectRaws = statement.executeUpdate("insert into test.s values (201813,'秦始皇','male',3000,'管理系',11)");

        System.out.println(affectRaws);

        ResultSet resultSet = statement.executeQuery("select name as '姓名',(2026-age) as '出生年份',dept as '所属部门' from test.s");

        while (resultSet.next()) {
            String name = resultSet.getString("姓名");
            int birth = resultSet.getInt("出生年份");
            String dept = resultSet.getString("所属部门");
            System.out.println("姓名：" + name + " 出生年份：" + birth + " 所属部门：" + dept);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
