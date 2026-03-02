<%@ page import="java.util.*,org.hibernate.*,org.hibernate.cfg.Configuration,com.billing.model.*" %>

<%
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    Session session1 = factory.openSession();
    session1.beginTransaction();

    List<Customer> customers = session1.createQuery("from Customer", Customer.class).list();
    List<Product> products = session1.createQuery("from Product", Product.class).list();

    session1.getTransaction().commit();
    session1.close();
%>

<!DOCTYPE html>
<html>
<head>
<title>Create Bill</title>
<link rel="stylesheet" href="css/style.css">

<style>
body {
    font-family: Arial;
    margin: 40px;
    background-color: #f4f6f9;
}
h2 {
    color: #333;
}
table {
    border-collapse: collapse;
    width: 80%;
    background: white;
}
th {
    background-color: #4CAF50;
    color: white;
}
th, td {
    padding: 10px;
    text-align: center;
}
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    font-size: 16px;
}
.total-box {
    margin-top: 15px;
    font-size: 20px;
    font-weight: bold;
}
</style>

<script>
function calculateTotal() {
    let checkboxes = document.querySelectorAll(".product-check");
    let quantities = document.querySelectorAll(".qty");
    let total = 0;

    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            let price = parseFloat(checkboxes[i].dataset.price);
            let qty = parseInt(quantities[i].value) || 0;
            total += price * qty;
        }
    }

    document.getElementById("totalAmount").innerText = total.toFixed(2);
}
</script>

</head>
<body>

<h2>Create Bill</h2>

<form action="createBill" method="post">

    <label><b>Select Customer:</b></label>
    <select name="customerId" required>
        <option value="">--Select--</option>
        <% for(Customer c : customers) { %>
            <option value="<%= c.getId() %>">
                <%= c.getName() %>
            </option>
        <% } %>
    </select>

    <br><br>

    <h3>Select Products</h3>

    <table border="1">
        <tr>
            <th>Select</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>

        <% for(Product p : products) { %>
        <tr>
            <td>
                <input type="checkbox"
                       class="product-check"
                       name="productId"
                       value="<%= p.getId() %>"
                       data-price="<%= p.getPrice() %>"
                       onclick="calculateTotal()">
            </td>
            <td><%= p.getName() %></td>
            <td>₹ <%= p.getPrice() %></td>
            <td>
                <input type="number"
                       class="qty"
                       name="quantity"
                       min="1"
                       value="1"
                       onchange="calculateTotal()">
            </td>
        </tr>
        <% } %>
    </table>

    <div class="total-box">
        Total: ₹ <span id="totalAmount">0.00</span>
    </div>

    <br>
    <input type="submit" value="Generate Bill">

</form>

</body>
</html>