package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return course == crew.course && name.equals(crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }

    public boolean isSameCourse(Course course) {
        return this.course.equals(course);
    }
}
