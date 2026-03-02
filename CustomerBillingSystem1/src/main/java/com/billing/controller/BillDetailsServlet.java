package com.billing.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.billing.model.Bill;
import com.billing.util.HibernateUtil;

@WebServlet("/billDetails")
public class BillDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Bill bill = session.get(Bill.class, id);

     // Force initialize items BEFORE session closes
     bill.getItems().size();
        session.close();

        request.setAttribute("bill", bill);
        RequestDispatcher rd = request.getRequestDispatcher("billDetails.jsp");
        rd.forward(request, response);
    }
}