package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.model.Employees;
import oncall.model.Month;
import oncall.model.data.WorkDay;
import oncall.util.Util;

public class InputView {


    public Month inputMonthAndStartDay() {
        System.out.println(ConsoleMessage.INPUT_MONTH_AND_START_DAY.message);
        List<String> input = Util.splitByComma(Console.readLine());
        int month = Integer.parseInt(input.get(0));
        String startDay = input.get(1);
        return new Month(month, startDay);
    }

    public Employees inputWeekdayInfo(){
        System.out.println(ConsoleMessage.INPUT_WEEKDAY.message);
        List<String> input = Util.splitByComma(Console.readLine());
        return Employees.of(input, WorkDay.WEEKDAY);
    }

    public Employees inputWeekendInfo(){
        System.out.println(ConsoleMessage.INPUT_WEEKND.message);
        List<String> input = Util.splitByComma(Console.readLine());
        return Employees.of(input, WorkDay.WEEKEND);
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
