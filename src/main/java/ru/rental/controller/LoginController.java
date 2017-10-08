package ru.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.rental.db.SecurityDAO;
import ru.rental.model.User;

import javax.validation.Valid;

/**
 * Created by leontevml on 26.09.2017.
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    private final SecurityDAO securityDAO;

    @Autowired
    public LoginController(SecurityDAO securityDAO) {
        this.securityDAO = securityDAO;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors() && securityDAO.login(user.getLogin(), user.getPassword())) {
            return "rental";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (!bindingResult.hasErrors()) {
            if (securityDAO.login(user.getLogin(), user.getPassword())) {
                modelAndView.setView(redirectView());
            } else {
                bindingResult.addError(new ObjectError("user", "Неверный логин или пароль"));
                modelAndView.setViewName("login");
            }
        } else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(SessionStatus sessionStatus, ModelAndView modelAndView) {
        sessionStatus.setComplete();
        modelAndView.setView(redirectView());
        return modelAndView;

    }

    @ModelAttribute
    public User createNewUser() {
        return new User();
    }

    private RedirectView redirectView() {
        RedirectView redirectView = new RedirectView("/");
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);

        return redirectView;
    }
}
