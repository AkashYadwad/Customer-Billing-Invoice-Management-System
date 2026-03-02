<%@ page import="com.billing.model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Details</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="header">
    Customer Billing System
</div>

<div class="container">

<%
    Bill bill = (Bill) request.getAttribute("bill");
%>

<div class="card">
    <h2>Bill Details</h2>

    <p><strong>Bill ID:</strong> <%= bill.getId() %></p>
    <p><strong>Customer:</strong> <%= bill.getCustomer().getName() %></p>
    <p><strong>Date:</strong> <%= bill.getBillDate() %></p>

    <h3>Purchased Items</h3>

    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
        </tr>

<%
    double grandTotal = 0;

    for(BillItem item : bill.getItems()) {
        double subtotal = item.getPrice() * item.getQuantity();
        grandTotal += subtotal;
%>
        <tr>
            <td><%= item.getProduct().getName() %></td>
            <td>₹ <%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td>₹ <%= subtotal %></td>
        </tr>
<%
    }
%>

    </table>

    <div class="total-box">
        Grand Total: ₹ <%= grandTotal %>
    </div>

    <br>
    <a href="viewBills" class="btn">Back</a>

</div>

</div>

</body>
</html>