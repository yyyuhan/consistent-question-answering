package ed.inf;

import org.junit.Test;

import java.util.regex.Pattern;

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

    public static String matchRegex(String stat, String orinTB, String newTB) {
        String REGEX = null;
        if (orinTB != null && newTB != null) {
            REGEX = "#R1#";
            stat = Pattern.compile(REGEX).matcher(stat).replaceAll(orinTB);
            REGEX = "#R2#";
            return Pattern.compile(REGEX).matcher(stat).replaceAll(newTB);
        }
        REGEX = "#R#";
        if (orinTB == null) {
            return Pattern.compile(REGEX).matcher(stat).replaceAll(newTB);
        }
        else
            return Pattern.compile(REGEX).matcher(stat).replaceAll(orinTB);
    }

    @Test
    public static double getProb(int count, int rounds) {
        return count / rounds;
    }

}
