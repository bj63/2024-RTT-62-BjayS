package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.database.dao.entity.Customers;
import java.util.List;

public class CustomersDAO {

    //-----------------------------Method findByCustomerName----------------------

    public List<Customers> findByCustomerName(String customer) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hqlCustomer = "SELECT c FROM Customers c WHERE c.customerName = :xcustomerName";

        TypedQuery<Customers> query = session.createQuery(hqlCustomer, Customers.class);
        query.setParameter("xcustomerName", customer);

        List<Customers> result = query.getResultList();

        session.close();

        return result;

    }
    //--------------------Method fidByContactFirstName-----------------------

    public List<Customers> findByContactFirstName(String contactName) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hqlCustomer = "SELECT c FROM Customers c WHERE c.contactFirstname = :whatever";

        TypedQuery<Customers> query = session.createQuery(hqlCustomer, Customers.class);
        query.setParameter("whatever", contactName);

        List<Customers> result = query.getResultList();

        session.close();

        return result;

    }
//------------------------Method insert------------------------------------------

    public void insert(Customers customers) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.save(customers);
        session.getTransaction().commit();
        session.close();
    }

    //------------------method findById--------------------

    public Customers findById(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customers c where c.id = :xid";
        TypedQuery<Customers> query = session.createQuery(hql, Customers.class);
        query.setParameter("xid", id);

        // we are querying a PK so the result can be found or not
        //this implementation will throw an exception in codes 2010 and under if the record is not found, so we put a
        // try-catch
        try {
            Customers result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }


    //-------------------method update----------------------

    public void update(Customers customers) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(customers);
        session.getTransaction().commit();
        session.close();
    }

    public Customers findById() {
        return null;
    }
}