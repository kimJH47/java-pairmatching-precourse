package pairmatching.domain.crew;

import java.util.Arrays;

public enum Course {
    BACK_AND("백앤드"),
    FRONT_AND("프론트앤드");

    private final String courseName;

    Course(String courseName) {

        this.courseName = courseName;
    }

    public static Course create(String inputCourse) {
        return Arrays.stream(Course.values())
                .filter(course -> course.courseName.equals(inputCourse))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }





}
