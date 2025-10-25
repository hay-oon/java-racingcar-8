package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utill.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void run() {
        String inputCarNames = InputView.readCarNames();

        String[] arrayNames = inputCarNames.split(",");

        for (String name : arrayNames) {
            InputValidator.validateCarName(name.trim());

            cars.add(new Car(name.trim()));
        }

        String inputTryCount = InputView.readTryCount();

        InputValidator.validateTryCount(inputTryCount.trim());

        int tryCount = Integer.parseInt(inputTryCount.trim());

        OutputView.printGameStart();

        // 시도 횟수만큼 경주 실행
        for (int i = 1; i <= tryCount; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber > 3) {
                    car.move();
                }
            }
            OutputView.printResult(cars);
        }

       int maxPosition = getMaxPosition(cars);

        decideWinners(cars, maxPosition);

        OutputView.printWinners(winners);
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
    
    private void decideWinners(List<Car> cars, int maxPosition) {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
    }
}