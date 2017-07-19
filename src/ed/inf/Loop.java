package ed.inf;

/**
 * Created by s1668090 on 19/07/17.
 */
public class Loop {
    private long startTime;
    private long endTime;

    public Loop() {
        startTime = Util.getTime();
    }

    public long loopTime() {
        endTime = Util.getTime();
        return endTime - startTime;
    }
}
