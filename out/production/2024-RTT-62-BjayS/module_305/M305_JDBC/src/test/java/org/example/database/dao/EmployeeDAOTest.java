package org.example.database.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.example.database.dao.entity.Orders;
import org.example.database.dao.entity.Employee;


import java.util.List;

public class EmployeeDAOTest {

    private static EmployeeDAO employeeDAO = new EmployeeDAO();


    @BeforeAll
    @AfterAll
    public static void beforeAll() {
        List<org.example.database.dao.Employee> employees = EmployeeDAO.findByFirstName("firstName");

        for (org.example.database.dao.Employee employee : employees) {
            EmployeeDAO.delete((org.example.database.dao.Employee) employees);
        }

    }


    @Test
    public void findByIdTest() {
        //given

        Integer userId = 1002;


        //when

        org.example.database.dao.Employee employee = EmployeeDAO.findById(userId);

        //then

        Assertions.assertNotNull(employee);
        Assertions.assertEquals(userId, employee.getId());

    }

    @Test
    public void findByFirstNameTest() {
        //given

        //when
        List<org.example.database.dao.Employee> employee = EmployeeDAO.findByFirstName("firstName");

        //then
        Assertions.assertNotNull(employee);
        Assertions.assertTrue(employee.size() > 0);
        Assertions.assertTrue(employee.stream().anyMatch(employees -> employees.getFirstName().equals("firstName")));

    }

    @Test
    public void createNewEmployee() {

        //given

        Employee given = new Employee();

        given.setOfficeId(2);
        given.setLastName("lastName");
        given.setFirstName("firstName");
        given.setExtension("1234");
        given.setEmail("f.nnn@yourwebsite.com");
        given.setJobTitle("Sales");

        //when
        EmployeeDAO.insert(given);

        //then

        Employee actual = EmployeeDAO.findById(given.getId());

        Assertions.assertEquals(given.getFirstName(),
                actual.getFirstName());


    }


}