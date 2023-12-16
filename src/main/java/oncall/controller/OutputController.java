package oncall.controller;

import java.util.List;
import oncall.model.BatchResult;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OutputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ApplicationState applicationState;

    public OutputController(InputView inputView, OutputView outputView, ApplicationState applicationState) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.applicationState = applicationState;
    }

    public void run() {
        List<BatchResult> batchResults = applicationState.getBatchResults();
        printResult(batchResults);
    }

    private void printResult(List<BatchResult> batchResults){
        outputView.printBatchResults(batchResults);
    }

}
