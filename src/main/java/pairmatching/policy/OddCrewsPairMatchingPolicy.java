package pairmatching.policy;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Mission;
import pairmatching.domain.pair.Pair;
import pairmatching.utils.PairUtils;

public class OddCrewsPairMatchingPolicy implements PairMatchingPolicy {

    @Override
    public List<Pair> pairing(List<Crew> shuffledCrews, Course course, Mission mission) {
        List<Pair> pairedCrews = new ArrayList<>();
        for (int i = 0; i < shuffledCrews.size() - 2; i++) {
            Crew crew1 = shuffledCrews.get(i);
            Crew crew2 = shuffledCrews.get(i + 1);
            validatePaired(crew1, crew2, mission);
            pairedCrews.add(Pair.create(mission, course, crew1, crew2));
        }
        Pair lastPair = addLastPair(PairUtils.getLastCrew(shuffledCrews), course, mission);
        pairedCrews.add(lastPair);
        return pairedCrews;
    }

    private Pair addLastPair(List<Crew> lastCrews, Course course, Mission mission) {
        validatePaired(lastCrews, mission);
        return Pair.create(mission, course, lastCrews);

    }

    private void validatePaired(Crew crew1, Crew crew2, Mission mission) {
        //level 을 get 할지 dto 로 리팩토링할지 고민
        if (crew1.isPaired(mission.getLevel(), crew2)) {
            throw new IllegalArgumentException("이미 페어매칭이 되었던 크루입니다");
        }
    }

    //refactoring
    private void validatePaired(List<Crew> crews, Mission mission) {
        Crew crew1 = crews.get(0);
        Crew crew2 = crews.get(1);
        Crew crew3 = crews.get(2);
        //level 을 get 할지 dto 로 리팩토링할지 고민
        if (crew1.isPaired(mission.getLevel(), crew2)) {
            throw new IllegalArgumentException("이미 페어매칭이 되었던 크루입니다");
        }
        if (crew1.isPaired(mission.getLevel(), crew3)) {
            throw new IllegalArgumentException("이미 페어매칭이 되었던 크루입니다");
        }
        if (crew2.isPaired(mission.getLevel(), crew2)) {
            throw new IllegalArgumentException("이미 페어매칭이 되었던 크루입니다");
        }
    }
}

