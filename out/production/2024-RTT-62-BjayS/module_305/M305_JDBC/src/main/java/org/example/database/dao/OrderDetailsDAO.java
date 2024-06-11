package org.example.database.dao;

import org.example.database.dao.entity.OrderDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailsDAO {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void insert(OrderDetails orderDetails) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        // this is the only line that changed
        session.save(orderDetails);

        session.getTransaction().commit();
        session.close();
    }
}
