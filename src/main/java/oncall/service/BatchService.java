package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.model.BatchResult;
import oncall.model.Employee;
import oncall.model.Employees;
import oncall.model.Month;
import oncall.model.data.HolidayInformation;

public class BatchService {

    public List<BatchResult> getBatchResults(Month month, Employees weekdayEmployees,
        Employees weekendEmployees) {
        List<BatchResult> batchResults = new ArrayList<>();
        String currentDay = month.startDay();

        for (int date = 1; date <= month.maxDate(); date++) {
            Employees currentEmployees = getCurrentEmployees(month, currentDay, date, weekdayEmployees, weekendEmployees);

            Employee currentEmployee = currentEmployees.getNextEmployee();
            handleConsecutiveWork(currentEmployees, currentEmployee);

            batchResults.add(new BatchResult(month.month(), date, currentDay, currentEmployee.name()));
            currentDay = month.getNextDay(currentDay);
        }
        return batchResults;
    }

    private void handleConsecutiveWork(Employees employees, Employee currentEmployee) {
        int currentIndex = employees.findEmployeeIndexByName(currentEmployee.name());
        int nextIndex = employees.nextIndex(currentIndex);

        // 연속 근무자인 경우 위치 교환
        if (nextIndex == currentIndex) {
            employees.swapEmployee(currentIndex, nextIndex);
        }
    }

    private Employees getCurrentEmployees(Month month, String currentDay, int currentDate,
        Employees weekdayEmployees, Employees weekendEmployees) {
        if (month.isWeekend(currentDay) || HolidayInformation.isHoliday(month.month(),
            currentDate)) {
            return weekendEmployees;
        }
        return weekdayEmployees;
    }

}
