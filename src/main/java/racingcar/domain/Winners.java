package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 일급 컬렉션: 우승자 목록을 관리하는 도메인 객체
 * WinnerCalculator의 책임을 Winners로 이동하여 객체지향 설계 개선
 */
public class Winners {
    private final List<String> winnerNames;

    public Winners(List<String> winnerNames) {
        this.winnerNames = new ArrayList<>(winnerNames);
    }

    public List<String> getWinnerNames() {
        return new ArrayList<>(winnerNames);
    }

    /**
     * 우승자 이름들을 콤마로 구분된 문자열로 반환
     * 출력 형식도 Winners가 알고 있음 (데이터 + 출력 로직)
     */
    public String getFormattedNames() {
        return String.join(", ", winnerNames);
    }
}

