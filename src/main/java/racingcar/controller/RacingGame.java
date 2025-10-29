package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.utill.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
public class RacingGame {

    /**
     * [개선 포인트 1] 단순히 흐름만 제어
     * 모든 로직은 도메인 객체(Cars)가 담당
     * RacingGame은 "누가, 언제"만 결정 (Orchestration)
     */
    public void play() {
        // 1. 입력받고 검증
        String inputCarNames = InputView.readCarNames().trim();
        Cars cars = Cars.from(inputCarNames); // Cars가 생성과 검증을 담당

        String inputTryCount = InputView.readTryCount().trim();
        InputValidator.validateTryCount(inputTryCount);
        int tryCount = Integer.parseInt(inputTryCount);

        // 2. 게임 시작
        OutputView.printGameStart();

        // 3. 경주 실행 - cars가 자신의 상태를 관리하며 경주 진행
        for (int i = 0; i < tryCount; i++) {
            cars.race(); // Cars가 자신의 경주 로직을 가짐
            OutputView.printResult(cars.getCars());
        }

        // 4. 우승자 계산 - cars가 자신의 데이터로 우승자 찾음
        Winners winners = cars.findWinners();
        OutputView.printWinners(winners.getWinnerNames());
    }
}