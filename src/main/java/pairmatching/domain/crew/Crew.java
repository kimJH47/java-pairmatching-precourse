package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.Map;

public class Crew {
    private final Course course;
    private final String name;

    private final Map<Mission, String> pairedCrews = new HashMap<>();

    private Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static Crew create(Course course, String name) {
        return new Crew(course, name);
    }


}
