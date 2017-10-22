package ru.rental.interfaces;

import ru.rental.model.Employee;

/**
 * Created by mikhail on 16.10.2017.
 */
public interface EmployeeService {
    void create(Employee employee, String login, String password);
}
