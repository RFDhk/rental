package ru.rental.model;

import org.springframework.format.annotation.DateTimeFormat;
import ru.rental.constant.Const;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by mikhail on 16.10.2017.
 */
public class Employee {
    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String firstName;
    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String secondName;
    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String middleName;
    @NotNull(message = "Заполните дату рождения")
    @DateTimeFormat(pattern = Const.DATE_JSP_FORMAT)
    private Date birthDay;
    private String phoneNumber;
    private String email;

    public Employee() {
        firstName = "Имя";
        secondName = "Фамилия";
        middleName = "Отчество";
        birthDay = new Date();
        phoneNumber = "89111111111";
        email = "as@as.ru";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
