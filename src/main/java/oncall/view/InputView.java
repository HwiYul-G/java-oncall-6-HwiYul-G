package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public void inputMonthAndStartDay() {
        System.out.println(ConsoleMessage.INPUT_MONTH_AND_START_DAY.message);
        String input = Console.readLine();
        // TODO : 데이터변경
    }

    public void inputWeekdayInfo(){
        System.out.println(ConsoleMessage.INPUT_WEEKDAY.message);
        String input = Console.readLine();
        // TODO : 데이터변경
    }

    public void inputWeekendInfo(){
        System.out.println(ConsoleMessage.INPUT_WEEKND.message);
        String input = Console.readLine();
        // TODO : 데이터변경
    }

    private enum ConsoleMessage {
        INPUT_MONTH_AND_START_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
        INPUT_WEEKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
        INPUT_WEEKND("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }


}
