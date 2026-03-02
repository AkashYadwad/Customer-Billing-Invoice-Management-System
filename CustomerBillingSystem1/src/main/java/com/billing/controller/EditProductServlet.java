package com.billing.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;

import com.billing.model.Product;
import com.billing.util.HibernateUtil;

public class EditProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();

        request.setAttribute("product", product);
        RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
        rd.forward(request, response);
    }
}