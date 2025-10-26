package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCalculatorTest {

    private WinnerCalculator winnerCalculator;

    @BeforeEach
    void setUp() {
        winnerCalculator = new WinnerCalculator();
    }

    @DisplayName("최대 position을 올바르게 찾는다")
    @Test
    void getMaxPosition_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        
        // car2가 가장 앞에 위치
        for (int i = 0; i < 3; i++) {
            car2.move();
        }
        car1.move();
        
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        
        // when
        int maxPosition = winnerCalculator.getMaxPosition(cars);
        
        // then
        assertThat(maxPosition).isEqualTo(3);
    }

    @DisplayName("단독 우승자를 올바르게 찾는다")
    @Test
    void calculateWinners_단독우승() {
        // given
        List<Car> cars = new ArrayList<>();
        
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        
        car1.move();
        car1.move();
        car2.move();
        
        cars.add(car1);
        cars.add(car2);
        
        // when
        List<String> winners = winnerCalculator.calculateWinners(cars);
        
        // then
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("pobi");
    }

    @DisplayName("공동 우승자를 올바르게 찾는다")
    @Test
    void calculateWinners_공동우승() {
        // given
        List<Car> cars = new ArrayList<>();
        
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        
        // car1과 car2가 공동 우승
        for (int i = 0; i < 3; i++) {
            car1.move();
            car2.move();
        }
        car3.move();
        
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        
        // when
        List<String> winners = winnerCalculator.calculateWinners(cars);
        
        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}

