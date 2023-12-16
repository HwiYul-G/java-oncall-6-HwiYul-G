package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.model.Employees;
import oncall.model.Month;
import oncall.model.data.WorkDay;
import oncall.util.Util;

public class InputView {

    private enum ConsoleMessage {
        INPUT_MONTH_AND_START_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
        INPUT_WEEKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
        INPUT_WEEKND("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }


    public Month inputMonthAndStartDay() {
        System.out.println(ConsoleMessage.INPUT_MONTH_AND_START_DAY.message);
        String input = Console.readLine();
        List<String> splitInput = Util.splitByComma(input);
        int month = Integer.parseInt(splitInput.get(0));
        String startDay = splitInput.get(1);
        return new Month(month, startDay);
    }

    public Employees inputWeekdayInfo(){
        System.out.println(ConsoleMessage.INPUT_WEEKDAY.message);
        String input = Console.readLine();
        List<String> splitInput = Util.splitByComma(input);
        return Employees.of(splitInput, WorkDay.WEEKDAY);
    }

    public Employees inputWeekendInfo(){
        System.out.println(ConsoleMessage.INPUT_WEEKND.message);
        String input = Console.readLine();
        List<String> splitInput = Util.splitByComma(input);
        return Employees.of(splitInput, WorkDay.WEEKEND);
    }




}
