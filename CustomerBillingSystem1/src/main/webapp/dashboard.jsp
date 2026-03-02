<%@ page contentType="text/html;charset=UTF-8" %>

<h2 style="color:blue;">Billing Dashboard</h2>

<div style="display:flex; gap:20px;">

    <div style="padding:20px; border:1px solid gray;">
        <h3>Total Bills</h3>
        <h2>${totalBills}</h2>
    </div>

    <div style="padding:20px; border:1px solid gray;">
        <h3>Total Revenue</h3>
        <h2>₹ ${totalRevenue}</h2>
    </div>

    <div style="padding:20px; border:1px solid gray;">
        <h3>Total Customers</h3>
        <h2>${totalCustomers}</h2>
    </div>

</div>

<br>
<a href="index.jsp">Go Home</a>