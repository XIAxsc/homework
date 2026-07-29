package day41;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo2 {

    private static void insertPre() throws Exception {
        long start = System.currentTimeMillis();
        Connection connection = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into demo2 (name) values (?)");

        for (int i = 0; i < 10000000; i++) {
            preparedStatement.setString(1, "name" + i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        JDBCUtils.closeConnection(null, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("PreparedStatement方法耗时：" + (end - start) + "ms");
    }

    private static void querySqlByPrimaryKey(int num) throws Exception {

        long start = System.currentTimeMillis();

        Connection connection = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from demo2 where id = ?");

        preparedStatement.setInt(1, num);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id：" + id + " ，name：" + name);
        }

        JDBCUtils.closeConnection(resultSet, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("主键查询耗时：" + (end - start) + "ms");
    }

    private static void querySqlByCommon(int num) throws Exception {

        long start = System.currentTimeMillis();

        Connection connection = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from demo2 where name = ?");

        preparedStatement.setString(1, "name" + num);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id：" + id + " ，name：" + name);
        }

        JDBCUtils.closeConnection(resultSet, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("普通字段查询耗时：" + (end - start) + "ms");
    }

    public static void main(String[] args) throws Exception {

        // insertPre();
        querySqlByPrimaryKey(500000);
        querySqlByCommon(4999999);

    }
}
