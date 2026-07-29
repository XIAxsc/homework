package homework.day42_43;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPUtils {

    public static Connection getDBCPConnection() throws Exception {

        InputStream in = Main.class.getClassLoader().getResourceAsStream("dbcp.properties");

        Properties properties = new Properties();
        properties.load(in);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        return dataSource.getConnection();

    }
}
