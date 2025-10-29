package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("문자열 입력으로 자동차 목록을 생성한다")
    @Test
    void from_테스트() {
        // given
        String inputCarNames = "pobi,woni,jun";

        // when
        Cars cars = Cars.from(inputCarNames);

        // then
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @DisplayName("경주를 실행하면 모든 자동차가 랜덤하게 이동한다")
    @Test
    void race_테스트() {
        // given
        Cars cars = Cars.from("pobi,woni");

        // when
        cars.race();

        // then
        List<Car> carList = cars.getCars();
        assertThat(carList).isNotNull();
    }

    @DisplayName("단독 우승자를 올바르게 찾는다")
    @Test
    void findWinners_단독우승() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        pobi.move();
        pobi.move();
        woni.move();
        Cars cars = new Cars(List.of(pobi, woni));

        // when
        Winners winners = cars.findWinners();

        // then
        assertThat(winners.getWinnerNames()).hasSize(1);
        assertThat(winners.getWinnerNames()).containsExactly("pobi");
    }

    @DisplayName("공동 우승자를 올바르게 찾는다")
    @Test
    void findWinners_공동우승() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        
        for (int i = 0; i < 3; i++) {
            pobi.move();
            woni.move();
        }
        jun.move();
        
        Cars cars = new Cars(List.of(pobi, woni, jun));

        // when
        Winners winners = cars.findWinners();

        // then
        assertThat(winners.getWinnerNames()).hasSize(2);
        assertThat(winners.getWinnerNames()).containsExactlyInAnyOrder("pobi", "woni");
    }

    @DisplayName("우승자 이름을 포맷된 문자열로 반환한다")
    @Test
    void getFormattedNames_테스트() {
        // given
        Winners winners = new Winners(List.of("pobi", "woni"));

        // when
        String result = winners.getFormattedNames();

        // then
        assertThat(result).isEqualTo("pobi, woni");
    }
}

