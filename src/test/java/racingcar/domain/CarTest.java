package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 이름을 올바르게 생성한다")
    @Test
    void 생성자_테스트() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("move() 호출 시 position이 올바르게 증가한다")
    @Test
    void move_테스트() {
        // given
        Car car = new Car("pobi");

        // when
        car.move();
        car.move();
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
