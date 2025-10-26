package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRegistrar;
import racingcar.domain.RaceProcessor;
import racingcar.domain.WinnerCalculator;
import racingcar.utill.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final WinnerCalculator winnerCalculator = new WinnerCalculator();
    private final RaceProcessor raceProcessor = new RaceProcessor();
    private final CarRegistrar carRegistrar = new CarRegistrar();

    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void run() {
        String inputCarNames = InputView.readCarNames();
        cars = carRegistrar.registerCars(inputCarNames);

        String inputTryCount = InputView.readTryCount();
        InputValidator.validateTryCount(inputTryCount.trim());
        int tryCount = Integer.parseInt(inputTryCount.trim());

        OutputView.printGameStart();
        
        for (int i = 1; i <= tryCount; i++) {
            raceProcessor.processRace(cars);
            OutputView.printResult(cars);
        }

        winners = winnerCalculator.calculateWinners(cars);
        OutputView.printWinners(winners);
    }
}