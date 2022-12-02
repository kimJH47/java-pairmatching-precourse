package pairmatching.domain.crew;

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

    @Override
    public String toString() {
        return level;
    }
}
