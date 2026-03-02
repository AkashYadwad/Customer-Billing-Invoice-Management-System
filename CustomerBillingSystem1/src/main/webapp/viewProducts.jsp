<%@ page import="java.util.*, com.billing.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Products</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Product List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>

<%
    List<Product> list = (List<Product>) request.getAttribute("productList");
    if(list != null){
        for(Product p : list){
%>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getQuantity() %></td>
        <td>
    <a href="editProduct?id=<%= p.getId() %>">Edit</a> |
    <a href="deleteProduct?id=<%= p.getId() %>">Delete</a>
</td>
<%
        }
    }
%>

</table>

<br>
<a href="addProduct.jsp">Add New Product</a>

</body>
</html>