package com.billing.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.billing.model.Customer;
import com.billing.util.HibernateUtil;

public class UpdateCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

        session.update(customer);

        tx.commit();
        session.close();

        response.sendRedirect("viewCustomers");
    }
}