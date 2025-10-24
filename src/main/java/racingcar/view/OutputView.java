package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {
    private static final String GAME_START_MESSAGE = "실행 결과";

    public static void printGameStart() {
        System.out.println("\n" + GAME_START_MESSAGE);
    }
    
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("");
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
