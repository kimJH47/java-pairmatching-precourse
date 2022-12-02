package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import pairmatching.domain.pair.Level;
import pairmatching.domain.pair.Mission;

public class Crew {
    private final Course course;
    private final String name;

    private final Map<Level, List<Crew>> pairedCrews = new HashMap<>();

    private Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static Crew create(Course course, String name) {
        return new Crew(course, name);
    }


    public boolean isSameCourse(Course course) {
        return this.course.equals(course);
    }

    public boolean isPaired(Level level, Crew crew) {
        List<Crew> crews = this.pairedCrews.get(level);
        return crews.contains(crew);
    }


    //refactoring -> toString vs getName
    public String getName() {
        return name;
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

    public void addPairedCrew(Mission mission, List<Crew> pairedCrew) {
        List<Crew> crews = pairedCrews.get(mission.getLevel());
        for (Crew crew : pairedCrew) {
            if (!crew.equals(this)) {
                crews.add(crew);
            }
        }
    }
}
