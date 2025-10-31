package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 일급 컬렉션: 자동차 목록을 관리하는 도메인 객체
 * 객체지향 원칙: 데이터와 그 데이터를 다루는 로직을 함께 묶음
 */
public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    /**
     * 문자열 입력으로 자동차 목록 생성
     * 생성 로직을 Cars가 담당하므로 독립적인 객체가 됨
     */
    public static Cars from(String inputCarNames) {
        List<Car> carList = Arrays.stream(inputCarNames.split(","))
            .map(Car::new)
            .toList();
        
        return new Cars(carList);
    }

    /**
     * 경주 실행 - 모든 자동차에 대해 랜덤 이동 처리
     * 경주 로직을 Cars가 가지고 있음 (데이터 + 행동의 결합)
     */
    public void race() {
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        });
    }

    /**
     * 우승자 찾기 - 최대 위치를 가진 자동차들 반환
     * Cars가 자신의 데이터로 우승자를 계산 (캡슐화)
     */
    public Winners findWinners() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .toList();
        
        return new Winners(winnerNames);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}

