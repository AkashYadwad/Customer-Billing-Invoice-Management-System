package com.billing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;

import com.billing.model.Product;
import com.billing.util.HibernateUtil;

public class ViewProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> products = session
                .createQuery("from Product", Product.class)
                .list();

        session.close();

        request.setAttribute("productList", products);

        RequestDispatcher rd = request.getRequestDispatcher("viewProducts.jsp");
        rd.forward(request, response);
    }
}