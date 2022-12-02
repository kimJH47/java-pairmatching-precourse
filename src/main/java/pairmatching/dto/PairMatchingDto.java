package pairmatching.dto;

import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Level;
import pairmatching.domain.crew.Mission;

public class PairMatchingDto {
    private final Course course;
    private final Level level;
    private final Mission mission;

    private PairMatchingDto(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static PairMatchingDto create(final String course, final String level, final String mission) {
        Course createCourse = Course.create(course);
        Level createLevel = Level.create(level);
        Mission createMission = Mission.create(createLevel, mission);
        return new PairMatchingDto(createCourse, createLevel, createMission);

    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
