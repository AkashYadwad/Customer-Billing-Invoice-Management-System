<%@ page import="com.billing.model.Product" %>
<%
Product p = (Product) request.getAttribute("product");
%>

<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Edit Product</h2>

<form action="updateProduct" method="post">
    <input type="hidden" name="id" value="<%= p.getId() %>" />

    Name: <input type="text" name="name" value="<%= p.getName() %>" /><br><br>
    Price: <input type="number" step="0.01" name="price" value="<%= p.getPrice() %>" /><br><br>
    Quantity: <input type="number" name="quantity" value="<%= p.getQuantity() %>" /><br><br>

    <input type="submit" value="Update" />
</form>

</body>
</html>