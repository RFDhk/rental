package ru.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.rental.db.SecurityDAO;
import ru.rental.models.User;

import javax.validation.Valid;

/**
 * Created by leontevml on 26.09.2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        model.addAttribute("user", user);

        if (SecurityDAO.getInstance().login(user.getLogin(), user.getPassword()))
            return "rental";
        else
            bindingResult.addError(new ObjectError("user", "Неверный логин или пароль"));
            return "login";
    }
}
