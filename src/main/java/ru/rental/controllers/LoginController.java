package ru.rental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.rental.models.User;

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
    public ModelAndView login(@ModelAttribute("user") User user) {
        if ("login".equals(user.getLogin()) && "password".equals(user.getPassword()) )
            return new ModelAndView("rental", "user", user);
        else
            return new ModelAndView("login", "user", user);
    }
}
