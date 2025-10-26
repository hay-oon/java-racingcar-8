package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {
    
    public List<String> calculateWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        
        return winners;
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
