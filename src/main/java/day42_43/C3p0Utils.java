package day42_43;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {

    static DataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
    }

    public static Connection getCp30Connection() throws SQLException {

        return cpds.getConnection();

    }
}
