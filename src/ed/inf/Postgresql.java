package ed.inf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by s1668090 on 19/07/17.
 */
public class Postgresql {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/s1668090";
    private static final String DB_USER = "s1668090";
    private static final String DB_PASSWORD = "";

    private Connection conn;

    public Postgresql() {
        conn = getConnection();
        try {
            conn.setAutoCommit(false); // TODO
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return con;
    }

    public void clearNewTable() {
        Statement st = null;
        int rowsDeleted = 0;
        try {
            st = conn.createStatement();
            rowsDeleted = st.executeUpdate(Query.deleteAll()); // TODO
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully deleted " + rowsDeleted + " rows!");
    }

    public void insert(String row) {
        Statement st = null;
        int rowsDeleted = 0;
        try {
            st = conn.createStatement();
            rowsDeleted = st.executeUpdate(Query.deleteAll()); // TODO
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully deleted " + rowsDeleted + " rows!");
    }
}
