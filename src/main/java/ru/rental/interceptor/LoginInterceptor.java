package ru.rental.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.rental.db.SecurityDAO;
import ru.rental.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mikhail on 09.10.2017.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final SecurityDAO securityDAO;

    @Autowired
    public LoginInterceptor(SecurityDAO securityDAO) {
        this.securityDAO = securityDAO;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (!request.getRequestURI().contains("login")) {

            if (user == null || !securityDAO.login(user.getLogin(), user.getPassword())) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {

            if (user != null && securityDAO.login(user.getLogin(), user.getPassword())) {
                response.sendRedirect(request.getContextPath() + "/");
            }
        }
    }
}
