package ru.rental.db;

import org.springframework.stereotype.Repository;

/**
 * Created by mikhail on 01.10.2017.
 */
@Repository()
public class SecurityDAO {

    private static final SecurityDAO securityDAO = new SecurityDAO();

    public SecurityDAO() {
    }

    public boolean login(String login, String password) {
        return "login".equals(login) && "password".equals(password);
    }
}
