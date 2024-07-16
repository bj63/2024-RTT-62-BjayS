package com.example.Springboot.controller;

import com.example.Springboot.database.dao.OrderDAO;
import com.example.Springboot.database.dao.CustomerDAO;
import com.example.Springboot.database.entity.Customer;
import com.example.Springboot.database.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // this URL is going to be localhost:8080/customer/list
    @GetMapping("/search")
    public ModelAndView list() {
        return null;
    }

    @GetMapping("/detail")
    public ModelAndView detail() {
        return null;
    }

}