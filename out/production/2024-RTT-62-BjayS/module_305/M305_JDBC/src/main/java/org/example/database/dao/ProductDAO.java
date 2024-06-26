package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.dao.entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

    private SessionFactory factory;

    {
        Configuration configuration = new Configuration();
        configuration.configure();
        factory = configuration.buildSessionFactory();
    }


    public Products findById(Integer id) {
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        String hql = "select p from Products p where p.id = :id";

        // this is setting up the query (essentially this is using a prepared statement inside)
        TypedQuery<Products> query = session.createQuery(hql,Products.class);
        // this is substituting the incoming id variable into the query string above
        // select * from products where id = 100;
        query.setParameter("id", id);

        try {
            // getSingleResult will throw an exception if no records are found
            Products products = query.getSingleResult();

            // if we get here then a record was found so we can return it
            return products;
        } catch( NoResultException e ) {
            // if we land here it is because there was an exception where there was no result
            // the standard design pattern is to return null when no record was found
            return null;
        } finally {
            // no matter what happens we want to close the hibernate session
            session.close();
        }
    }

    public List<Products> findByName( String productName ) {
        Session session = factory.openSession();

        // this is refered to HQL or to JQL both mean the same thing
        // HQL USES THE JAVA CLASS NAMES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // HQL USES THE JAVA CLASS NAMES !!!
        // HQL USES THE JAVA CLASS NAMES !!!!!!!!
        // HQL USES THE JAVA CLASS NAMES
        String hql = "select p from Products p where p.productName = :productName";

        TypedQuery<Products> query = session.createQuery(hql,Products.class);
        query.setParameter("productName", productName);

        // this will always return a list.  So we do not have to worry about it being null
        // if there were no results found then the list will be empty
        List<Products> products = query.getResultList();

        session.close();

        return products;
    }

    public List<Products> findLikeName(String productName ) {
        Session session = factory.openSession();

        // create the query to be ... select * from products where product_name like '%name%';
        // basically the CONCAT adds the % to the beginning and the end of the incoming variable
        // % is a wildcard meaning match any character any number of times
        // by adding the lower function to the product names and the incoming variable you make this query case insensitive
        String hql = "select p from Products p where lower(p.productName) like lower(CONCAT('%', :productName, '%'))";

        TypedQuery<Products> query = session.createQuery(hql,Products.class);
        query.setParameter("productName", productName);

        List<Products> products = query.getResultList();

        session.close();

        return products;
    }

    public void update(Products product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.merge(product);

        session.getTransaction().commit();
        session.close();
    }

}
