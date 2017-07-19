package ed.inf;

/**
 * Created by s1668090 on 19/07/17.
 */
public enum Query {
    SELECT ("SELECT"),
    PROJECT ("PROJECT"),
    JOIN ("JOIN");

    private final String query;

    Query(String query) {
        this.query = query;
    }
}
