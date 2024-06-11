package org.example.database.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.example.database.dao.entity.Customers;

public class CustomersDAOTest {

    private CustomersDAO CustomersDAO = new CustomersDAO();

    @AfterAll
    @BeforeAll
    public static void beforeAll() {
        //we could write some code to delete any customer from the database that has the "Test customer" as the name

        //if we were doing an old school jdbc connection, we could create the actual database connection so that
        // all of the methods in the test case already have a database connection they can use

    }

    @Test
    public void findByIdTest() {

        //given
        Integer userId = 103;

        //when
        Customers customers = CustomersDAO.findById(userId);

        //then
        //the expected value should be on the left (first argument)
        // the actual value, which is the value returned or modified by the tested function is on the right (second argument)
        Assertions.assertNotNull(customers);
        Assertions.assertEquals(userId, customers.getId());
        Assertions.assertEquals("Atelier graphique", customers.getCustomerName());
        Assertions.assertEquals("Schmitt", customers.getContactLastName());



    }

    @Test
    public void findByInvalidIdTest() {

        //given
        Integer userId = 103033;

        //when
        Customers customers = CustomersDAO.findById(userId);

        //then
        Assertions.assertNull(customers);

    }

    @Test
    public void createNewCustomer() {
        //given
        Customers given = new Customers();

        given.setCustomerName("TestCustomer");
        given.setContactFirstName("FirstName");
        given.setContactLastName("LastName");
        given.setAddress1("233 Main St");
        given.setCity("Seguinaa");
        given.setCountry("USAAT");
        given.setPhone("123-456-7895");

        //when
        CustomersDAO.insert(given);


        //then
        Customers actual = CustomersDAO.findById(given.getId());

        Assertions.assertEquals(given.getCustomerName(), actual.getCustomerName());




    }

}
