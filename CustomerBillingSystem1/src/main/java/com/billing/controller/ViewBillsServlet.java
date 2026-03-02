package com.billing.controller;

import com.billing.model.Bill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewBills")
public class ViewBillsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bill.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        List<Bill> bills = session.createQuery("from Bill", Bill.class).list();

        session.getTransaction().commit();
        session.close();

        request.setAttribute("bills", bills);
        request.getRequestDispatcher("viewBills.jsp").forward(request, response);
    }
}