package oncall.controller;

import java.util.List;
import oncall.model.BatchResult;
import oncall.service.BatchService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OutputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ApplicationState applicationState;
    private final BatchService batchService;

    public OutputController(InputView inputView, OutputView outputView,
        ApplicationState applicationState, BatchService batchService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.applicationState = applicationState;
        this.batchService = batchService;
    }

    public void run() {
        List<BatchResult> batchResults = batchService.getBatchResults(
            applicationState.getMonth(),
            applicationState.getWeekdayEmployees(),
            applicationState.getWeekendEmployees());
        printResult(batchResults);
    }

    private void printResult(List<BatchResult> batchResults) {
        outputView.printBatchResults(batchResults);
    }

}
