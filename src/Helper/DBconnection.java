package Helper;

public class DBconnection {
    private static DBconnection ourInstance = new DBconnection();

    public static DBconnection getInstance() {
        return ourInstance;
    }

    private DBconnection() {
    }
}
