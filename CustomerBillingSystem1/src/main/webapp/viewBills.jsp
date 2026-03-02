<%@ page import="java.util.*,com.billing.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Bills</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="header">
    Customer Billing System
</div>

<div class="container">

    <div class="card">
        <h2>All Bills</h2>

        <table>
            <tr>
                <th>Bill ID</th>
                <th>Customer</th>
                <th>Date</th>
                <th>Total Amount</th>
                <th>Action</th>
            </tr>

            <%
                List<Bill> bills = (List<Bill>) request.getAttribute("bills");

                if(bills != null && !bills.isEmpty()) {
                    for(Bill b : bills) {
            %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getCustomer().getName() %></td>
                <td><%= b.getBillDate() %></td>
                <td>₹ <%= b.getTotalAmount() %></td>
                <td>
                    <a href="billDetails?id=<%= b.getId() %>" class="btn">
                        View
                    </a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No Bills Found</td>
            </tr>
            <%
                }
            %>

        </table>

        <br>
        <a href="index.jsp" class="btn">Go Home</a>

    </div>

</div>

</body>
</html>