package day42_43;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void executeQuery(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from test.user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");

            System.out.printf("id：%d，name：%s，password：%s%n", id, name, password);
        }
        connection.close();
    }

    public static void main(String[] args) throws Exception {

        // DBCP
        // Connection connection = DBCPUtils.getDBCPConnection();

        // Druid
        // Connection connection = DruidUtils.getDruidConnection();

        // C3p0
        Connection connection = C3p0Utils.getCp30Connection();

        executeQuery(connection);
    }
}
