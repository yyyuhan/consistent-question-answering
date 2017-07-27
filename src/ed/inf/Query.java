package ed.inf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s1668090 on 20/07/17.
 */
public class Query {

    static final String orinTB = "test";
    static final String newTB = "ctidtest";

    public static String SELECT_ALL = "SELECT * FROM #R#;";
    public static String DELETE_ALL = "DELETE FROM #R#;";
    public static String INSERT = "INSERT INTO #R# (id) VALUES (? :: tid);";
    public static String SELECT_INIT_MAP = "SELECT id, ctid FROM #R#;";
    public static String SELECT_NOT_IN = "SELECT * FROM (SELECT * FROM #R1# as temp WHERE ctid NOT IN (SELECT ctid from #R2#)) as tempd WHERE age>33 AND city='Edinburgh';";
//    insert into ctidtest (id) values (concat('(',10,',','20',')')::tid);


//    public Map<String, String> oriToRwt;

    public Query() {

//        oriToRwt = new HashMap();
//        oriToRwt.put(); // TODO
    }

//    public String getRwt(String oriQuery) {
//        return oriToRwt.get(oriQuery);
//    }

    public static String getQuery(String query, boolean isOrinTB, boolean isNewTB) {
        if (isOrinTB && isNewTB)
            return Util.matchRegex(true, query, orinTB, newTB);
        if (isNewTB)
            return Util.matchRegex(false, query, newTB, null);
        else // isOrinTB : true
            return Util.matchRegex(false, query, orinTB, null);
    }
//    public static String selectAll() {
//        return Util.matchRegex(false, SELECT_ALL, orinTB, null);
//    }
//
//    // clear new table
//    public static String deleteAll() {
//        return Util.matchRegex(false, DELETE_ALL, newTB, null);
//    }
//
//    public static String getSelectInitMap() {
//        return Util.matchRegex(false, SELECT_INIT_MAP, orinTB, null);
//    }
//    // insert into new table
//    public static String getInsert() {
//        return Util.matchRegex(false, INSERT, newTB, null);
//    }

}
