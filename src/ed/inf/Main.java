package ed.inf;

import ed.inf.dao.Result;


public class Main {

    private static String ORI_QUERY;
    private static String RWT_QUERY;
    private double err;
    private double alpha;
    private Query query = new Query();
    private final Postgresql psql;
    private final int ROUNDS;
    private int count;

    public Main(double err, double alpha, String oriQuery, String rwtQuery) {
        this.err = err;
        this.alpha = alpha;
        this.ROUNDS = getRounds(alpha, err);
        this.psql = new Postgresql();
        this.query = new Query();
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
                // delete other rows with same id
                psql.initialMap();
                psql.randPick(); // update delList
                if (! psql.isAvailable()) // no valid deletion is available
                    psql.insertDelList();
                    break;
            }
//            if (psql.isConsistent()) // TODO: true
//                count++;

        }
    }

    public Result execute() {
        long startTime = Util.getTime();
        executeLoop();
        long endTime = Util.getTime();
        long oriTime = 0; // TODO
        return new Result(alpha, err, ROUNDS, ORI_QUERY, count, oriTime, endTime - startTime);
    }

    public int getRounds(double alpha, double err) {

        return Util.getRounds(alpha, err);
    }

    public static void main(String[] args) {
	// write your code here

//        String oriQuery = q.SELECT_ALL; // TODO
//        String rwtQuery = q.getRwt(oriQuery);
//        Main m = new Main(0.1, 0.1, oriQuery, rwtQuery);
//        Result rst = m.execute();
//        System.out.println(rst);
    }
}
