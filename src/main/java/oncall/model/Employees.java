package oncall.model;

import java.util.List;
import oncall.model.data.WorkDay;
import oncall.util.ExceptionMessage;

public record Employees(List<Employee> employees) {

    // 검사 로직
    // employees의 개별 item인 employee의 이름이 중복되면 안됨
    private void validateDuplication() {
        long distinctCount = employees.stream()
            .map(Employee::name)
            .distinct()
            .count();
        if (distinctCount != employees.size()) {
            // TODO : exception message 나중에 처리
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    // employee의 String name을 이용해서 해당 employee의 index를 반환하는 함수 필요
    public int findEmployeeIndexByName(String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).name().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // employees의 데이터 위치를 교환하는 함수 필요
    public void swapEmployee(int index1, int index2) {
        Employee temp = employees.get(index1);
        employees.set(index1, employees.get(index2));
        employees.set(index2, temp);
    }


    // List<Stirng> names를 받아서 해당 names의 순서대로 '평일' 노동자 생성
    public static Employees of(List<String> names, WorkDay workDay){
        List<Employee> employees = names.stream()
            .map(name -> new Employee(name ,workDay))
            .toList();
        return new Employees(employees);
    }
}
