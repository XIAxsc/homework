package test.mysql.transaction;

import month2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws SQLException {


        try (Connection connection = JDBCUtils.getConnection()) {
            connection.setAutoCommit(false);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
