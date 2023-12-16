package oncall.controller;

import oncall.model.Employees;
import oncall.model.Month;
import oncall.service.BatchService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ApplicationState applicationState;
    private final BatchService batchService;

    public InputController(InputView inputView, OutputView outputView,
        ApplicationState applicationState, BatchService batchService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.applicationState = applicationState;
        this.batchService = batchService;
    }

    public void run() {
        Month month = inputMonthData();
        applicationState.setMonth(month);

        Employees weekdayEmployees = inputWeekdayData();
        applicationState.setWeekdayEmployees(weekdayEmployees);

        Employees weekendEmployees = inputWeekendData();
        applicationState.setWeekendEmployees(weekendEmployees);
    }

    private Month inputMonthData() {
        do {
            try {
                return inputView.inputMonthAndStartDay();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private Employees inputWeekdayData() {
        do {
            try {
                return inputView.inputWeekdayInfo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private Employees inputWeekendData() {
        do {
            try {
                return inputView.inputWeekendInfo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
