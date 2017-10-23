package ru.rental.service;

import org.springframework.stereotype.Service;
import ru.rental.interfaces.EmployeeService;
import ru.rental.model.Employee;
import ru.rental.model.form.EmployeeRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikhail on 16.10.2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void create(Employee employee, String login, String password) {
        System.out.println("Добавим: " + login + "/" + password );
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>(2);
        list.add(new EmployeeRow());
        list.add(new EmployeeRow());

        return list;
    }
}
