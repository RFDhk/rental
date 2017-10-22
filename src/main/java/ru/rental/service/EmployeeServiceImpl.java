package ru.rental.service;

import org.springframework.stereotype.Service;
import ru.rental.interfaces.EmployeeService;
import ru.rental.model.Employee;

/**
 * Created by mikhail on 16.10.2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void create(Employee employee, String login, String password) {
        System.out.println("Добавим: " + login + "/" + password );
    }
}
