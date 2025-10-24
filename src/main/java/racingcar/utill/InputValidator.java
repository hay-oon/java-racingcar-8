package racingcar.utill;

public class InputValidator {
    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
        }
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    public static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
        if (Integer.parseInt(tryCount) < 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상으로 입력해주세요.");
        }
    }
}
