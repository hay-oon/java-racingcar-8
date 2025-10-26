package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utill.InputValidator;

public class CarRegistrar {
    
    public List<Car> registerCars(String inputCarNames) {
        String[] arrayNames = inputCarNames.split(",");
        List<Car> cars = new ArrayList<>();
        
        for (String name : arrayNames) {
            InputValidator.validateCarName(name.trim());
            cars.add(new Car(name.trim()));
        }
        
        return cars;
    }
}

