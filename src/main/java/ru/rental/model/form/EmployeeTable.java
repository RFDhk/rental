package ru.rental.model.form;

import ru.rental.model.Employee;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by mikhail on 23.10.2017.
 */
public class EmployeeTable {
    private List<EmployeeRow> employeeRows;

    public List<EmployeeRow> getEmployeeRows() {
        return employeeRows;
    }

    public void setEmployeeRows(List<EmployeeRow> employeeRows) {
        this.employeeRows = employeeRows;
    }

    public void setEmployees(List<Employee> employees) {
        this.employeeRows = employees.stream().map(employee -> (EmployeeRow) employee).collect(Collectors.toList());
    }
}
