package ed.inf;

import ed.inf.dao.Result;


public class Main {

    private static String ORI_QUERY;
    private static String RWT_QUERY;
    private double err;
    private double alpha;
    private String oriQuery;
    private String rwtQuery;
    private final Postgresql psql;
    private final int ROUNDS;
    private int count;

    public Main(double err, double alpha, String oriQuery, String rwtQuery) {
        this.err = err;
        this.alpha = alpha;
        this.oriQuery = oriQuery;
        this.rwtQuery = rwtQuery;
        this.ROUNDS = getRounds(alpha, err);
        this.psql = new Postgresql();
        this.ORI_QUERY = oriQuery;
        this.RWT_QUERY = rwtQuery;
        this.count = 0;
    }

    public void executeLoop() {
        // loop
        for (int idx=1; idx<=ROUNDS; idx++) {
            // clear table
            psql.clearNewTable();
            while (true) {
                // randomly pick a row to stay
                String row = psql.randPick(); // TODO
                // delete other rows with same id
                psql.delColumn(); // TODO
                if (! psql.isAvailable()) // TODO:no valid deletion is available
                    break;
                else { // valid deletion exists: insert it into new table
                    psql.insert(row);
                }
            }
            if (psql.isConsistent()) // TODO: true
                count++;

        }
    }

    public Result execute() {
        long startTime = Util.getTime();
        executeLoop();
        long endTime = Util.getTime();
        long oriTime = 0; // TODO
        return new Result(alpha, err, ROUNDS, oriQuery, count, oriTime, endTime - startTime);
    }

    public int getRounds(double alpha, double err) {

        return Util.getRounds(alpha, err);
    }

    public static void main(String[] args) {
	// write your code here
        Query q = new Query();
        String oriQuery = q.SELECT_ALL; // TODO
        String rwtQuery = q.getRwt(oriQuery);
        Main m = new Main(0.1, 0.1, oriQuery, rwtQuery);
        Result rst = m.execute();
        System.out.println(rst);
    }
}
