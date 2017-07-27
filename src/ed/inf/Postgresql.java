package ed.inf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.sql.PreparedStatement;

/**
 * Created by s1668090 on 19/07/17.
 */
public class Postgresql {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://pgteach.inf.ed.ac.uk:5432/s1668090";
    private static final String DB_USER = "s1668090";
    private static final String DB_PASSWORD = "";
    public static String MSG_OPENDB = "Opened database successfully";

    private Connection conn;
    private HashMap<Integer, ArrayList<String>> dupMap;
    private ArrayList<String> delList;

    public Postgresql() {
        dupMap = new HashMap<>();
        delList = new ArrayList<>();
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
        System.out.println(MSG_OPENDB);
        return con;
    }

    public void clearNewTable() {
        System.out.println("===clear new table===");
        Statement st;
        int rowsDeleted = 0;
        try {
            st = conn.createStatement();
            rowsDeleted = st.executeUpdate(Query.deleteAll());
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully deleted " + rowsDeleted + " rows!");
    }

    public void initialMap() {
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query.getSelectInitMap());
            while (rs.next())
            {
                int id = rs.getInt(1);
                String ctid = rs.getString(2);
                if (! dupMap.containsKey(id)) {
                    ArrayList list = new ArrayList<String>();
                    list.add(ctid);
                    dupMap.put(id, list);
                } else {
                    dupMap.get(id).add(ctid);
                }


            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void randPick() {
        int size = this.dupMap.size();
        int rdm = new Random().nextInt(size);
        int i = 0;
        for (Integer key : this.dupMap.keySet()) {
            if (rdm == i) {
                Util.delColumn(key, dupMap, delList);
                break;
            }
            i++;
        }
    }

    public boolean isAvailable() {
        for (ArrayList idList : dupMap.values()) {
            if (idList.size() > 1)
                return true;
        }
        return false;
    }

    public void insertDelList() {

        try {
            PreparedStatement ps = conn.prepareStatement(Query.getInsert());
            for (String str : delList) {
//                System.out.println("from del List" + str);
                ps.setString(1, str);
                ps.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean isConsistent(boolean isTwoTable, String QUERY) {
        Statement st = null;
        ResultSet rs = null;
        boolean consistent = false;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Query.getQuery(isTwoTable, QUERY));
            if (! rs.next()) // result set is empty
                consistent = true;
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consistent;
    }
}
