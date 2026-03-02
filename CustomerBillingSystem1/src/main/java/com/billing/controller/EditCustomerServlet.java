package com.billing.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;

import com.billing.model.Customer;
import com.billing.util.HibernateUtil;

public class EditCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();

        request.setAttribute("customer", customer);
        RequestDispatcher rd = request.getRequestDispatcher("editCustomer.jsp");
        rd.forward(request, response);
    }
}