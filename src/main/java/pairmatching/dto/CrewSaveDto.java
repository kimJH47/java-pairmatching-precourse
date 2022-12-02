package pairmatching.dto;

import pairmatching.domain.crew.Course;
import pairmatching.domain.crew.Crew;

public class CrewSaveDto {
    private final String name;
    private final Course course;

    private CrewSaveDto(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public static CrewSaveDto create(final String name, final String course) {
        return new CrewSaveDto(name, Course.create(course));
    }

    public Crew toEntity() {
        return Crew.create(course, name);
    }
}
