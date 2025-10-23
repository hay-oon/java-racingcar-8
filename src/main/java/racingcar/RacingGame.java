package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private int maxPosition = 0;

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

        System.out.println("\n실행 결과");

        // 시도 횟수만큼 경주 실행
        for (int i = 1; i <= tryCount; i++){
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber > 3) {
                    car.move();
                }
            }
            // 게임 결과 출력
            for (Car car : cars) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println("");
        }

        // 최대 전진 거리 판정
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 우승자 판정
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}