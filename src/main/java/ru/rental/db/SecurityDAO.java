package ru.rental.db;

/**
 * Created by mikhail on 01.10.2017.
 */
public class SecurityDAO {

    private static final SecurityDAO securityDAO = new SecurityDAO();

    private SecurityDAO() {
    }

    public boolean login(String login, String password) {
        return login.equals("login") && password.equals("password");
    }

    public static SecurityDAO getInstance() {
        return securityDAO;
    }

}
