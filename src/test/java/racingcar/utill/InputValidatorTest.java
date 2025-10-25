package racingcar.utill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputValidatorTest {

    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @Test
    void validateCarName_길이_초과() {
        // given
        String carName = "abcdef";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 입력해주세요.");
    }

    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    @Test
    void validateCarName_빈_문자열() {
        // given
        String carName = "";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "a1", "1.5"})
    void validateTryCount_숫자가_아님(String tryCount) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자로 입력해주세요.");
    }

    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
    @Test
    void validateTryCount_1_미만() {
        // given
        String tryCount = "0";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상, 100이하 숫자로 입력해주세요.");
    }

    @DisplayName("시도 횟수가 100 초과이면 예외가 발생한다")
    @Test
    void validateTryCount_100_초과() {
        // given
        String tryCount = "101";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상, 100이하 숫자로 입력해주세요.");
    }
}
