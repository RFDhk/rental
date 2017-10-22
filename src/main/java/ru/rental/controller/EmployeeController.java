package ru.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.rental.constant.ModelConstant;
import ru.rental.interfaces.EmployeeService;
import ru.rental.model.Employee;

import javax.validation.Valid;

/**
 * Created by mikhail on 16.10.2017.
 */
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping(value = "/employee/create", method = RequestMethod.GET)
    public ModelAndView createGet(ModelAndView modelAndView) {
        modelAndView.addObject(ModelConstant.EMPLOYEE, new Employee());
        modelAndView.setViewName("/employee/create");
        return modelAndView;
    }

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public ModelAndView
    createPost(@Valid @ModelAttribute(ModelConstant.EMPLOYEE) Employee employee, BindingResult bindingResult, ModelAndView modelAndView,
               @RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("repeatPassword") String repeatPassword) {

        if (login.length() <3) {
            modelAndView.addObject("loginError", "Логин должен содержать не менее 3 символов");
            bindingResult.addError(new FieldError("","login", ""));
        }

        if (password.length() < 6 ) {
            modelAndView.addObject("passwordError", "Пароль должен содержать не менее 6 символов");
            bindingResult.addError(new FieldError("","password", ""));
        } else if (!password.equals(repeatPassword)) {
            modelAndView.addObject("repeatPasswordError", "Повторно пароль введен неверно");
            bindingResult.addError(new FieldError("","repeatPassword", ""));
        }

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("login", login);
            modelAndView.setViewName("/employee/create");
        } else {
            employeeService.create(employee, login, password);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
}
