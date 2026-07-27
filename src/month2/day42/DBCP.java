package month2.day42;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBCP {

    public static void executeQuery(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");

            System.out.printf("id：%d，name：%s，password：%s%n", id, name, password);
        }
    }

    public static void main(String[] args) throws SQLException {
        DataSource dataSource = null;

        try {
            Properties properties = new Properties();
            // InputStream inputStream = DBCP.class.getClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(new FileReader("dbcp.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection connection = dataSource.getConnection();

        executeQuery(connection);

        connection.close();
    }
}
