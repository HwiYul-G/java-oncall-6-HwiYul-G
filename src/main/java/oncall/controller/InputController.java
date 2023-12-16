package oncall.controller;

import oncall.model.Employees;
import oncall.model.Month;
import oncall.view.InputView;
import oncall.view.OutputView;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ApplicationState applicationState;

    public InputController(InputView inputView, OutputView outputView, ApplicationState applicationState) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.applicationState = applicationState;
    }

    public void run(){
        inputMonthData();
        inputWeekdayData();
        inputWeekendData();
    }

    private void inputMonthData(){
        do {
            try {
                Month month = inputView.inputMonthAndStartDay();
                applicationState.setMonth(month);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }

    private void inputWeekdayData(){
        do {
            try {
                Employees weekdayEmployees = inputView.inputWeekdayInfo();
                applicationState.setWeekdayEmployees(inputView.inputWeekdayInfo());
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }

    private void inputWeekendData(){
        do {
            try {
                Employees weekendEmployees = inputView.inputWeekendInfo();
                applicationState.setWeekendEmployees(inputView.inputWeekendInfo());
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }

}
