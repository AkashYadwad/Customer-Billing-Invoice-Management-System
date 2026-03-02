package com.billing.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.billing.model.Product;
import com.billing.util.HibernateUtil;

public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }

        tx.commit();
        session.close();

        response.sendRedirect("viewProducts");
    }
}