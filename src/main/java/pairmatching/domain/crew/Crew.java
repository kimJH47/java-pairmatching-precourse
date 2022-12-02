package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.Map;

public class Crew {
    private final Level level;
    private final Course course;
    private final String name;

    private final Map<Mission, String> pairedCrews = new HashMap<>();

    private Crew(Level level, Course course, String name) {
        this.level = level;
        this.course = course;
        this.name = name;
    }

    public static Crew create(Level level, Course course, String name) {
        return new Crew(level, course, name);
    }


}
