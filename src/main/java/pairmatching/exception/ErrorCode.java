package pairmatching.exception;

public enum ErrorCode {
    FAILED_PAIR_MATCHING("페어매칭에 실패하였습니다.");

    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }

}
