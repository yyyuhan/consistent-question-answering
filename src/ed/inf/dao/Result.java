package ed.inf.dao;
import  ed.inf.Util;
/**
 * Created by s1668090 on 20/07/17.
 */
public class Result {

    final Object[][] table = new String[7][2];

    private double alpha;
    private double err;
    private int rounds;
    private String query;
    private double prob;
    private long oriTime; // Time of Q over R
    private long totalTime; // Time of algorithm

    public Result(double alpha, double err, int rounds, String query, int count, long oriTime, long totalTime) {
        this.alpha = alpha;
        this.err = err;
        this.rounds = rounds;
        this.query = query;
        this.prob = Util.getProb(count, rounds);
        this.oriTime = oriTime;
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
//        table[0] = new String[] { "alpha", "error", "rounds", "query", "Prob", "time of Q over R", "time of algorithm" };
//        table[1] = new Object[] {ealpha, err, rounds, query, prob, oriTime, totalTim};
//        for (Object[] row : table) {
//            System.out.format("%-15s%-15s%-15s\n", row);
        return alpha +" | "+ err +" | "+ rounds +" | "+ query +" | "+ prob +
                " | " + oriTime +" | "+ totalTime;
        }
    }

