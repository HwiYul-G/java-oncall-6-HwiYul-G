package oncall.view;

import java.util.List;
import oncall.model.BatchResult;
import oncall.model.data.HolidayInformation;

public class OutputView {

    private enum Message {

        BASIC_MESSAGE("%d월 %d일 %s %s" + System.lineSeparator()),
        HOLIDAY_MESSAGE("%d월 %d일 %s(휴일) %s" + System.lineSeparator());

        private final String message;

        Message(final String message) {
            this.message = message;
        }
    }

    public OutputView() {
    }

    public void printBatchResults(List<BatchResult> batchResults) {
        batchResults.forEach(this::printBatchResult);
    }

    private void printBatchResult(BatchResult batchResult) {
        if (HolidayInformation.isHoliday(batchResult.month(), batchResult.date())) {
            System.out.printf(Message.HOLIDAY_MESSAGE.message, batchResult.month(),
                batchResult.date(), batchResult.day(), batchResult.name());
            return;
        }
        System.out.printf(Message.BASIC_MESSAGE.message, batchResult.month(), batchResult.date(), batchResult.day(), batchResult.name());
    }


}
