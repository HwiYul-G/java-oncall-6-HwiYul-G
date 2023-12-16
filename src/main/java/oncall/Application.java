package oncall;

import oncall.controller.ApplicationState;
import oncall.controller.InputController;
import oncall.controller.OutputController;
import oncall.model.service.BatchService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BatchService batchService = new BatchService();

        ApplicationState applicationState = ApplicationState.getInstance();

        InputController inputController = new InputController(inputView, outputView, applicationState, batchService);
        OutputController outputController = new OutputController(inputView, outputView, applicationState, batchService);

        inputController.run();
        outputController.run();
    }
}
