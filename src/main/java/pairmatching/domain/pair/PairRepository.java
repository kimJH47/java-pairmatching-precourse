package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

public class PairRepository {
    private final List<Pair> pairs = new ArrayList<>();

    public void save(final List<Pair> pairs) {
        pairs.addAll(pairs);
    }
}
