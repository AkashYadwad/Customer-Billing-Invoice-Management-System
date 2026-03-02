package com.billing.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.billing.util.HibernateUtil;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Total Bills
        Long totalBills = (Long) session.createQuery("select count(b.id) from Bill b").uniqueResult();

        // Total Revenue
        Double totalRevenue = (Double) session.createQuery("select sum(b.totalAmount) from Bill b").uniqueResult();

        // Total Customers
        Long totalCustomers = (Long) session.createQuery("select count(c.id) from Customer c").uniqueResult();

        session.close();

        request.setAttribute("totalBills", totalBills);
        request.setAttribute("totalRevenue", totalRevenue == null ? 0 : totalRevenue);
        request.setAttribute("totalCustomers", totalCustomers);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}