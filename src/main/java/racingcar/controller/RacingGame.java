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
        
        createCars(inputCarNames);

        String inputTryCount = InputView.readTryCount();

        InputValidator.validateTryCount(inputTryCount.trim());

        int tryCount = Integer.parseInt(inputTryCount.trim());

        OutputView.printGameStart();

        playGame(cars, tryCount);

        int maxPosition = getMaxPosition(cars);

        decideWinners(cars, maxPosition);

        OutputView.printWinners(winners);
    }


    private void createCars(String inputCarNames) {
        String[] arrayNames = inputCarNames.split(",");
        for (String name : arrayNames) {
            InputValidator.validateCarName(name.trim());
            cars.add(new Car(name.trim()));
        }
    }

    private void playGame(List<Car> cars, int tryCount) {
        for (int i = 1; i <= tryCount; i++) {
            moveCars(cars);
            OutputView.printResult(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber > 3) {
                car.move();
            }
        }
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