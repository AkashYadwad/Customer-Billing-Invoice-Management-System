package com.billing.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.billing.model.Product;
import com.billing.util.HibernateUtil;

public class UpdateProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        session.update(product);

        tx.commit();
        session.close();

        response.sendRedirect("viewProducts");
    }
}