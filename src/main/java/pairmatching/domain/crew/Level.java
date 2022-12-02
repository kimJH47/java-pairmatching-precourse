package pairmatching.domain.crew;

import java.util.Arrays;

public enum Level {
    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String level;

    Level(String level) {
        this.level = level;
    }

    public static Level create(String inputLevel) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name().equals(inputLevel))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return level;
    }
}
