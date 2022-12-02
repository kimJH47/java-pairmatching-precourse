package pairmatching.domain.crew;


import java.util.Arrays;

public enum Mission {

    CAR_RACE(Level.ONE, "자동차경주"),
    LOTTO(Level.ONE, "로또"),
    BASEBALL(Level.ONE, "숫자야구게임"),
    CART(Level.TWO, "장바구니"),
    PAYMENT(Level.TWO, "결제"),
    SUBWAY_MAP(Level.TWO, "지하철노선도"),
    PERFORMANCE_IMPROVEMENT(Level.FOUR, "성능개선"),
    RELEASE(Level.FOUR, "배포");


    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission create(Level level, String inputMission) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level.equals(level))
                .filter(mission -> mission.name.equals(inputMission))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return name;
    }
}
