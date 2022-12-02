package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.pair.Mission;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.PairRepository;
import pairmatching.dto.PairMatchingDto;
import pairmatching.dto.PairResultDto;
import pairmatching.exception.ErrorCode;
import pairmatching.service.policy.DefaultPairMatchingPolicy;
import pairmatching.service.policy.OddCrewsPairMatchingPolicy;
import pairmatching.service.policy.PairMatchingPolicy;
import pairmatching.utils.PairUtils;

public class PairMatchingService {
    //쿼리
    private final CrewRepository crewRepository;
    private final PairRepository pairRepository;

    public PairMatchingService(CrewRepository crewRepository, PairRepository pairRepository) {

        this.crewRepository = crewRepository;

        this.pairRepository = pairRepository;
    }

    public void pairMatching(PairMatchingDto pairMatchingDto) {
        Course course = pairMatchingDto.getCourse();
        List<Crew> crews = crewRepository.findByCourse(course);
        Mission mission = pairMatchingDto.getMission();
        List<Pair> pairs = tryPairing(crews, course, mission);
        pairRepository.save(pairs.stream()
                .map(Pair::addPaired)
                .collect(Collectors.toList()));


    }

    private List<Pair> tryPairing(List<Crew> crews, Course course, Mission mission) {
        int tryCount = 0;
        while (PairUtils.isOverTryCount(tryCount)) {
            List<Crew> shuffled = Randoms.shuffle(crews);
            try {
                return selectPolicyAndReturnPairs(shuffled, course, mission);
            } catch (IllegalArgumentException e) {
                tryCount++;
            }
        }
        //리팩토링
        throw new IllegalArgumentException(ErrorCode.FAILED_PAIR_MATCHING.getMessage());
    }

    private List<Pair> selectPolicyAndReturnPairs(List<Crew> crews, Course course, Mission mission) {
        if (PairUtils.isOdd(crews)) {
            return pairingCrews(crews, course, mission, new OddCrewsPairMatchingPolicy());
        }
        return pairingCrews(crews, course, mission, new DefaultPairMatchingPolicy());

    }

    private List<Pair> pairingCrews(List<Crew> crews, Course course, Mission mission,
                                    PairMatchingPolicy pairMatchingPolicy) {
        return pairMatchingPolicy.pairing(crews, course, mission);
    }

    //페어매칭 조회
    private PairResultDto findByMission(PairMatchingDto pairMatchingDto) {
        Course course = pairMatchingDto.getCourse();
        Mission mission = pairMatchingDto.getMission();
        List<Pair> pairs = pairRepository.findByCourseAndMission(course, mission);
        return PairResultDto.create(pairs);

    }
}
