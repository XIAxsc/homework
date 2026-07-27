package month2.day42;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0 {

    static DataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = cpds.getConnection();

        DBCP.executeQuery(connection);

        connection.close();

    }
}
