package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winnerNames;

    public Winners(List<String> winnerNames) {
        this.winnerNames = new ArrayList<>(winnerNames);
    }

    public List<String> getWinnerNames() {
        return new ArrayList<>(winnerNames);
    }

    public String getFormattedNames() {
        return String.join(", ", winnerNames);
    }
}

