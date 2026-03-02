package com.billing.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.billing.model.Customer;
import com.billing.util.HibernateUtil;

public class TestHibernate {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer c = new Customer();
        c.setName("Test");
        c.setEmail("test@gmail.com");
        c.setPhone("9999999999");

        session.save(c);

        tx.commit();
        session.close();

        System.out.println("Customer Saved Successfully!");
    }
}