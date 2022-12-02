package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Mission;

public class Pair {
    private final List<Crew> crews;
    private final Mission mission;
    private final Course course;

    private Pair(List<Crew> crews, Mission mission, Course course) {
        this.crews = new ArrayList<>(crews);
        this.mission = mission;
        this.course = course;
    }

    public static Pair create(Mission mission, Course course, Crew... crews) {
        return new Pair(Arrays.asList(crews), mission, course);
    }

    public static Pair create(Mission mission, Course course, List<Crew> crews) {
        return new Pair(crews, mission, course);
    }

    public Pair addPaired() {
        crews.forEach(crew -> crew.addPairedCrew(mission, crews));
        return this;
    }

    public List<String> getPairCrewsName() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
    public boolean isSameCourse(Course course) {
        return this.course.equals(course);
    }

    public boolean isSameMission(Mission mission) {
        return this.mission.equals(mission);
    }


}
