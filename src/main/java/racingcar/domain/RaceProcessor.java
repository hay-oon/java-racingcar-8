package racingcar.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RaceProcessor {

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    public void processRace(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            if (randomNumber >= MOVE_CONDITION) {
                car.move();
            }
        }
    }
}
