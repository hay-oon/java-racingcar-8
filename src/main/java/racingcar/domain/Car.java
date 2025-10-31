package racingcar.domain;

import racingcar.utill.InputValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        InputValidator.validateCarName(name);
        this.name = name;
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}