package oncall.controller;

import java.util.List;
import oncall.model.BatchResult;
import oncall.model.Employees;
import oncall.model.Month;

public class ApplicationState {
    // 싱글톤 처리
    private static ApplicationState instance;

    private Month month;

    private Employees weekdayEmployees;
    private Employees weekendEmployees;

    public List<BatchResult> getBatchResults() {
        return batchResults;
    }

    public void setBatchResults(List<BatchResult> batchResults) {
        this.batchResults = batchResults;
    }

    private List<BatchResult>  batchResults;

    private ApplicationState() {
    }

    public static ApplicationState getInstance() {
        if (instance == null) {
            instance = new ApplicationState();
        }
        return instance;
    }

    public Employees getWeekdayEmployees() {
        return weekdayEmployees;
    }

    public Employees getWeekendEmployees() {
        return weekendEmployees;
    }

    public Month getMonth() {
        return month;
    }

    public void setWeekdayEmployees(Employees weekdayEmployees) {
        this.weekdayEmployees = weekdayEmployees;
    }

    public void setWeekendEmployees(Employees weekendEmployees) {
        this.weekendEmployees = weekendEmployees;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
