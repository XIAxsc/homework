package month2.day42;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class Druid {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        DBCP.executeQuery(connection);

        connection.close();
    }
}
