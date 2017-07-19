package ed.inf;

/**
 * Created by s1668090 on 19/07/17.
 */
public class Util {

    public static int getRounds(double alpha, double err) {
        return (int) Math.ceil(1/(2*Math.pow(err, 2)) * Math.log(2/alpha));
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }
}
