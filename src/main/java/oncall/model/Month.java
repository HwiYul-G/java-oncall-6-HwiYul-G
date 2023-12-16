package oncall.model;

import java.util.List;
import oncall.util.ExceptionMessage;

public record Month(int month, String startDay) {
    private static final List<Integer> MAX_DATE_OF_MONTH = List.of(31,28,31,30,31,30,31,31,30,31,30,31);
    private static final int MONTH_GAP = 1;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final List<String> DAYS = List.of("월", "화", "수", "목", "금", "토", "일");
    private static final List<String> WEEKENDS = List.of("토", "일");
    public Month {
        // int month와 String startDay가 먼저 값이 대입되어야함.
        validateMonth(month);
        validateStartDay(startDay);
    }

    private void validateMonth(int month) {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            // TODO : error message 추후 정리
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private void validateStartDay(String startDay) {
        if (!DAYS.contains(startDay)) {
            // TODO : error message 추후 정리
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public int maxDate() {
        return MAX_DATE_OF_MONTH.get(month - MONTH_GAP);
    }

    // 시작 요일을 기준으로 '다음 요일' 을 반환하는 함수
    public String getNextDay(String day) {
        int index = DAYS.indexOf(day);
        return DAYS.get((index + 1) % DAYS.size());
    }

    // 현재 주말인지 아닌지 판단하는 함수
    public boolean isWeekend(String day) {
        return WEEKENDS.contains(day);
    }

}
