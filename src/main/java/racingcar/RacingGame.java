package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();

        String[] arrayNames = inputName.split(",");
        for (String name : arrayNames) {
            cars.add(new Car(name.trim()));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputTry = Console.readLine();
        int tryCount = Integer.parseInt(inputTry);

        for (int i = 1; i <= tryCount; i++){
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber > 3) {
                    car.move();
                }
            }
        }
    }
}