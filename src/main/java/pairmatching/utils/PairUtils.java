package pairmatching.utils;

import java.util.List;
import pairmatching.domain.crew.Crew;

public class PairUtils {
    private PairUtils() {

    }

    public static boolean isOdd(List<Crew> list) {
        return list.size() % 2 != 0;

    }

    public static boolean isOverTryCount(int count) {
        return count != 3;
    }
}
