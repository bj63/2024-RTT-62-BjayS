package com.example.Springboot.controller;
import com.example.Springboot.database.dao.UserDAO;
import com.example.Springboot.form.CreateAccountFormBean;
import com.example.Springboot.servive.AuthenticatedUserUtilities;
import com.example.Springboot.servive.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Slf4j
@Controller
@RequestMapping("/account")
public class LoginController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/loginPageUrl")
    public ModelAndView loginPage(@RequestParam(required = false) String error) {
        // this was the homework from friday to crate your own login page
        ModelAndView response = new ModelAndView("auth/login");

        return response;
    }


    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/create-account");

        return response;
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("auth/create-account");

        // homework if you want - check to make sure the email does not already exist
        // this is a great case the custom annotation that we made

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            // there were no errors so we can create the new user in the database
            userService.createUser(form);
            authenticatedUserUtilities.manualAuthentication(httpSession, form.getEmail(), form.getPassword());
        }

        return response;
    }


}