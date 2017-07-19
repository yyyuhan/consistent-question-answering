package ed.inf;

/**
 * Created by s1668090 on 19/07/17.
 */
public class Compute {

    private final double ROUNDS;
    private double totalTime;

    public Compute(double alpha, double err) {
        this.ROUNDS = Util.getRounds(alpha, err);
    }
}
