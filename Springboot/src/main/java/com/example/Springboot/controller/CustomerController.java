package com.example.Springboot.controller;
import com.example.Springboot.database.entity.Customer;
import com.example.Springboot.database.entity.Employee;
import com.example.Springboot.database.entity.Office;
import com.example.Springboot.database.entity.Product;
import com.example.Springboot.form.CreateCustomerFormBean;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.example.Springboot.database.dao.CustomerDAO;
import com.example.Springboot.database.dao.EmployeeDAO;
import com.example.Springboot.database.dao.OfficeDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDao;
    @Autowired
    private EmployeeDAO employeeDao;
    @Autowired
    private OfficeDAO officeDao;

@GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer customerId) {
        ModelAndView response = new ModelAndView("customer/detail");

        List<Customer> customers = customerDao.findBySalesRepEmployeeId(customerId);
        response.addObject("customers", customers);

        // Get the customer object from the database

        Customer customer = customerDao.findById(customerId).get();
        response.addObject("customer", customer);

        return response;
    }


@GetMapping("/create")
    public ModelAndView create() {
        // Setting up the view for rendering
        ModelAndView response = new ModelAndView("customer/create");

        // List of employees for the Sales Representative dropdown
        List<Employee> salesReps = employeeDao.findAll();
        response.addObject("salesReps", salesReps);

        // List of offices for the Office dropdown
        List<Office> offices = officeDao.findAll();
        response.addObject("offices", offices);

        // Adding a blank customer object for the form binding
        response.addObject("customer", new Customer());

        return response;
    }


    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            // If there are validation errors, log them and prepare to show the form again
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error: " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // Add necessary model attributes for the form view
            response.addObject("bindingResult", bindingResult);
            List<Employee> salesReps = employeeDao.findAll(); // Assuming this fetches all employees who can be sales reps
            response.addObject("salesReps", salesReps); // Add employees for the dropdown
            List<Office> offices = officeDao.findAll(); // Fetch all offices
            response.addObject("offices", offices); // Add offices for the dropdown

            // Set the view name to return to the form with errors
            response.setViewName("customer/create");

            // Add the form bean to the model to repopulate the form with user-entered data
            response.addObject("form", form);

            return response;
        } else {
            // If no validation errors, proceed to create the customer

            // Create a new Customer object and populate it with form data
            Customer customer = new Customer();
            customer.setCustomerName(form.getCustomerName());
            customer.setContactFirstname(form.getContactFirstname());
            customer.setContactLastname(form.getContactLastname());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setAddressLine2(form.getAddressLine2());
            customer.setCity(form.getCity());
            customer.setState(form.getState());
            customer.setPostalCode(form.getPostalCode());
            customer.setCountry(form.getCountry());

            // Fetch the sales representative employee from the database and set it
            Employee salesRep = employeeDao.findById(form.getSalesRepEmployeeId());
            customer.setEmployee(salesRep);

            // Save the customer entity to the database
            customer = customerDao.save(customer);

            // Redirect to the customer detail page after successful creation
            response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());

            return response;
        }
    }
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(required = false) String search) {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("list");

        log.debug("The user searched for the term: " + search);


        List<Customer> customers = customerDao.findByNameOrId(search);
        response.addObject("customers", customers);
        return response;
    }
}