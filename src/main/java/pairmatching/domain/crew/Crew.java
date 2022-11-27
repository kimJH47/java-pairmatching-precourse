package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Lists;

public class Crew {
    private final Level level;
    private final Course course;
    private final String name;

    private final List<String> pairedCrews = new ArrayList<>();

    private Crew(Level level, Course course, String name) {
        this.level = level;
        this.course = course;
        this.name = name;
    }

    public static Crew create(Level level, Course course, String name) {
        return new Crew(level, course, name);
    }




}
