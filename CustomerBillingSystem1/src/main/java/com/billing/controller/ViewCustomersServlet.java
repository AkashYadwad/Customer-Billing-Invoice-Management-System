package com.billing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.hibernate.Session;

import com.billing.model.Customer;
import com.billing.util.HibernateUtil;

public class ViewCustomersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Customer> customers = session
                .createQuery("from Customer", Customer.class)
                .list();

        session.close();

        // VERY IMPORTANT — attribute name must match JSP
        request.setAttribute("customerList", customers);

        RequestDispatcher rd = request.getRequestDispatcher("viewCustomers.jsp");
        rd.forward(request, response);
    }
}