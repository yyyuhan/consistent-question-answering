package ed.inf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
        String REGEX;
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

    public static double getProb(int count, int rounds) {
        return count / rounds;
    }

    public static void delColumn(Integer key, HashMap<Integer, ArrayList<String>> dupMap, ArrayList<String> delList) {
        int size = dupMap.get(key).size();
        if (size > 1) {
            int rdm = new Random().nextInt(size);
            int i = 0;
            for (String ctid : dupMap.get(key)) {
                if (rdm != i) {
                   delList.add(ctid);
                }
                i++;
            }
        }
        // if size == 1, keep it (not add to delList)
        dupMap.remove(key);
    }
}
