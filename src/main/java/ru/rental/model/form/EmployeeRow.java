package ru.rental.model.form;

import ru.rental.model.Employee;

/**
 * Created by mikhail on 23.10.2017.
 */
public class EmployeeRow extends Employee {
    private boolean check;

    public EmployeeRow() {
        check = false;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
