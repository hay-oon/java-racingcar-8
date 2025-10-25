package racingcar.utill;

public class InputValidator {
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하로 입력해주세요.";
    private static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "자동차 이름은 비어있을 수 없습니다.";
    private static final String TRY_COUNT_NUMBER_ERROR_MESSAGE = "시도 횟수는 숫자로 입력해주세요.";
    private static final String TRY_COUNT_MIN_ERROR_MESSAGE = "시도 횟수는 1 이상, 100이하 숫자로 입력해주세요.";
    private static final int TRY_COUNT_MIN = 1;
    private static final int TRY_COUNT_MAX = 100;

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
    }

    public static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ERROR_MESSAGE);
        }
        if (Integer.parseInt(tryCount) < TRY_COUNT_MIN || Integer.parseInt(tryCount) > TRY_COUNT_MAX) {
            throw new IllegalArgumentException(TRY_COUNT_MIN_ERROR_MESSAGE);
        }
    }
}
