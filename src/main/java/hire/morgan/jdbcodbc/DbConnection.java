package hire.morgan.jdbcodbc;

import hire.morgan.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by morgan.shepherd
 */
public class DbConnection {
    public static Connection getConnection() throws Exception{
        Connection conn = null;
        Class.forName(Constants.FOR_NAME);
        conn = DriverManager.getConnection(Constants.PATH,Constants.UNAME, Constants.PASS);
        return conn;

    }
}
