package com.billing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.billing.model.Customer;
import com.billing.util.HibernateUtil;

public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);

        session.save(c);

        tx.commit();
        session.close();

        response.sendRedirect("viewCustomers");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.getWriter().println("Servlet running. Use POST to save customer.");
    }
}