package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        String[] carNames = inputCarNames.split(",");
        List<Car> carList = new ArrayList<>();
        
        for (String name : carNames) {
            racingcar.utill.InputValidator.validateCarName(name.trim());
            carList.add(new Car(name.trim()));
        }
        
        return new Cars(carList);
    }

    /**
     * 경주 실행 - 모든 자동차에 대해 랜덤 이동 처리
     * 경주 로직을 Cars가 가지고 있음 (데이터 + 행동의 결합)
     */
    public void race() {
        for (Car car : cars) {
            int randomNumber = camp.nextstep.edu.missionutils.Randoms
                .pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    /**
     * 우승자 찾기 - 최대 위치를 가진 자동차들 반환
     * Cars가 자신의 데이터로 우승자를 계산 (캡슐화)
     */
    public Winners findWinners() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        
        return new Winners(winnerNames);
    }

    /**
     * 내부 데이터를 직접 노출하지 않고 복사본 반환 (캡슐화)
     */
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}

