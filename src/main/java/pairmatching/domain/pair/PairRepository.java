package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Mission;

public class PairRepository {
    private final List<Pair> pairs = new ArrayList<>();

    public void save(final List<Pair> pairs) {
        this.pairs.addAll(pairs);
    }

    public List<Pair> findByCourseAndMission(Course course, Mission mission) {
        return pairs.stream()
                .filter(pair -> pair.isSameCourse(course))
                .filter(pair -> pair.isSameMission(mission))
                .collect(Collectors.toList());
    }
}
