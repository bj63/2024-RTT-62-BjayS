package com.example.Springboot.controller;

import com.example.Springboot.database.dao.ProductDAO;
import com.example.Springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ProductDAO productDao;


    // this function is for the home page of the website which is express as just a plain slash "/"
    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) Integer id) {
        // by default, the @RequestParam is required, meaning if it is missing in the URL spring will send you to the error page
        // if the id parameter is not present on the URL then the incoming id will be null
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        // by default the logging level is set to info so the debug message will not be printed in the terminal
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        // NEVER EVER use System.out.println in a spring application
        System.out.println("This is forbidden at all times");

        response.addObject("message", "Hello World!");

        return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable(name = "id") Integer productId) {
        // by default, the @PathVariable is required, meaning if it is missing in the URL spring will send you to the error page
        // by using the name attribute in the @PathVariable annotation, you can change the name of the variable
        // so in this case it is mapping the id in the URL to the productId variable
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(productId);
        response.addObject("productKey", product);

        response.addObject("message", "Hello World!");

        return response;
    }


    @GetMapping("/page-url")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("another-page");

        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search);

        // I am going to add the user input back to the model, so that
        // we can display the search term in the input field
        response.addObject("search", search);


        List<Product> products = productDao.findByNameOrCode(search);
        response.addObject("products", products);

        return response;
    }

}

