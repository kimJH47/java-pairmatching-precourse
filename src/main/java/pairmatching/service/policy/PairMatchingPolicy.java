package pairmatching.service.policy;

import java.util.List;
import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Mission;
import pairmatching.domain.pair.Pair;

public interface PairMatchingPolicy {

    List<Pair> pairing(List<Crew> shuffledCrews, Course course, Mission mission);


}
