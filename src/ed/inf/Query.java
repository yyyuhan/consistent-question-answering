package ed.inf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s1668090 on 20/07/17.
 */
public class Query {

    static final String orinTB = "base";
    static final String newTB = "new";

    public static String SELECT_ALL = "SELECT * FROM #R#;";
    public static String DELETE_ALL = "DELETE * FROM #R#;";
    public static String INSERT = "INSERT INTO #R# VALUES (?, ?, ?, ?, ?);";

    public Map<String, String> oriToRwt;

    public Query() {
        oriToRwt = new HashMap();
//        oriToRwt.put(); // TODO
    }

    public String getRwt(String oriQuery) {
        return oriToRwt.get(oriQuery);
    }

    public static String selectAll() {
        return Util.matchRegex(SELECT_ALL, orinTB, null);
    }

    // clear new table
    public static String deleteAll() {
        return Util.matchRegex(DELETE_ALL, newTB, null);
    }

    // insert into new table
    public static String insert() {
        return Util.matchRegex(INSERT, null, newTB);
    }

    public static void findViolation() {

    }

}
