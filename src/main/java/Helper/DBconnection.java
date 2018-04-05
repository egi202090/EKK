package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
    private static Connection ourInstance;

    public static Connection getInstance() throws SQLException {
        if(DBconnection.ourInstance == null){
            new DBconnection();
        }
        return DBconnection.ourInstance;
    }

    private DBconnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");
        if (DBconnection.ourInstance == null) {
            DBconnection.ourInstance = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", connectionProps);
        }
        DBconnection.ourInstance.setCatalog("M326");
        System.out.println("Connected to database");
    }
}
