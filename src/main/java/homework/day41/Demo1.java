package homework.day41;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Demo1 {
    private static void sqlFor() throws Exception {
        long start = System.currentTimeMillis();
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        for (int i = 0; i < 10000; i++) {
            statement.executeUpdate("insert into demo1 values (" + i + ",null)");
        }
        JDBCUtils.closeConnection(null, statement, connection);
        long end = System.currentTimeMillis();
        System.out.println("for方法耗时：" + (end - start) + "ms");
    }

    private static void sqlBatch() throws Exception {
        long start = System.currentTimeMillis();
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        for (int i = 10000; i < 20000; i++) {
            statement.addBatch("insert into demo1 values (" + i + ",null)");
        }
        statement.executeBatch();
        JDBCUtils.closeConnection(null, statement, connection);
        long end = System.currentTimeMillis();
        System.out.println("Statement批处理方法耗时：" + (end - start) + "ms");
    }

    private static void sqlPre() throws Exception {
        long start = System.currentTimeMillis();
        Connection connection = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into demo1 values (?,null)");

        for (int i = 20000; i < 30000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        JDBCUtils.closeConnection(null, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("PreparedStatement方法耗时：" + (end - start) + "ms");
    }

    public static void main(String[] args) throws Exception {

        sqlFor();
        sqlBatch();
        sqlPre();

    }

}
