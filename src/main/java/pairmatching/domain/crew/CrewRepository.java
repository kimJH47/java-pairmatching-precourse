package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private final List<Crew> crews = new ArrayList<>();

    //등록
    //중복확인
    public Crew save(final Crew crew) {
        validateDuplicate(crew);
        crews.add(crew);
        return crew;
    }

    private void validateDuplicate(Crew crew) {
        if (crews.contains(crew)) {
            throw new IllegalArgumentException("크루이름이 중복됩니다");
        }
    }
    //조회
}
