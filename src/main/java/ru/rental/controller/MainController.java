package ru.rental.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.rental.constant.ViewConstant;

/**
 * Created by mikhail on 15.10.2017.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.addObject("userName",
                ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        modelAndView.setViewName(ViewConstant.MAIN);
        return modelAndView;
    }

}
