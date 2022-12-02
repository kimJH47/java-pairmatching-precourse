package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private final List<Crew> crews = new ArrayList<>();

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

    public List<Crew> findByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(course))
                .collect(Collectors.toList());
    }
}
