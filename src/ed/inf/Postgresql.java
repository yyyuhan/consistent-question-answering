package ed.inf;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by s1668090 on 19/07/17.
 */
public class Postgresql {
    public static void postgresJDBC() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/s1668090",
                            "s1668090", "123");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public static void main(String[] args) {

    }
}
