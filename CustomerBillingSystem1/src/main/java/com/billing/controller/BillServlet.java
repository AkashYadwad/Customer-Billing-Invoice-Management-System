package com.billing.controller;

import com.billing.dao.BillDAO;
import com.billing.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/createBill")
public class BillServlet extends HttpServlet {

    private static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(Bill.class)
            .addAnnotatedClass(BillItem.class)
            .buildSessionFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = factory.openSession();
        session.beginTransaction();

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String[] productIds = request.getParameterValues("productId");
        String[] quantities = request.getParameterValues("quantity");

        Customer customer = session.get(Customer.class, customerId);

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setBillDate(new Date());

        List<BillItem> items = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < productIds.length; i++) {

            int pid = Integer.parseInt(productIds[i]);
            int qty = Integer.parseInt(quantities[i]);

            Product product = session.get(Product.class, pid);

            BillItem item = new BillItem();
            item.setBill(bill);
            item.setProduct(product);
            item.setQuantity(qty);
            item.setPrice(product.getPrice());

            total += product.getPrice() * qty;

            items.add(item);
        }

        bill.setTotalAmount(total);
        bill.setItems(items);

        session.save(bill);
        session.getTransaction().commit();
        session.close();

        response.sendRedirect("success.jsp");
    }
}