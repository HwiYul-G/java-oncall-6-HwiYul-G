package oncall.model;

import oncall.model.data.WorkDay;
import oncall.util.ExceptionMessage;

public record Employee(String name, WorkDay workDay) {
    private final static int MAX_NAME_LENGTH = 5;

    public Employee {
        validateName(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            // TODO : error message 추후 정리
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

}
