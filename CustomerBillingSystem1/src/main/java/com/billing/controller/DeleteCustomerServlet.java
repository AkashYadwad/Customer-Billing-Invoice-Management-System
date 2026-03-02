package com.billing.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.billing.model.Customer;
import com.billing.util.HibernateUtil;

public class DeleteCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);

        if (customer != null) {
            session.delete(customer);
        }

        tx.commit();
        session.close();

        response.sendRedirect("viewCustomers");
    }
}