package ru.rental.model;

import javax.validation.constraints.Size;

/**
 * Created by mikhail on 01.10.2017.
 */
public class User {

    @Size(min = 3, message = "Логин должен быть не менее 3 символов")
    private String login;
    @Size(min = 6, message = "Пароль должен быть не менее 6 символов")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
