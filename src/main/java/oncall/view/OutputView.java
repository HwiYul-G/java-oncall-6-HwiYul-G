package oncall.view;

public class OutputView {

    public OutputView() {
    }


    // TODO : printf로 출력하는 것을 기본으로 할 것
    private enum Message {

        BASIC_MESSAGE("%d월 %d일 %s %s"),
        HOLIDAY_MESSAGE("%d월 %d일 %s(휴일) %s");

        private final String message;

        Message(final String message) {
            this.message = message;
        }
    }

}
