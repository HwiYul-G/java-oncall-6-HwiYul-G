package oncall.model;

import java.util.List;
import oncall.util.ExceptionMessage;

public record Month(int month, String startDay) {

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final List<String> DAYS = List.of("월", "화", "수", "목", "금", "토", "일");

    public Month {
        validateMonth();
        validateStartDay();
    }

    private void validateMonth() {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            // TODO : error message 추후 정리
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private void validateStartDay() {
        if (!DAYS.contains(startDay)) {
            // TODO : error message 추후 정리
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

}
