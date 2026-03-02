<%@ page import="java.util.*, com.billing.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Customers</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Customer List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
<%
String msg = request.getParameter("msg");
if(msg != null){
%>
    <p style="color:green;"><%= msg %></p>
<%
}
%>
<%
List<Customer> list = (List<Customer>) request.getAttribute("customerList");
    if(list != null){
        for(Customer c : list){
%>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getName() %></td>
        <td><%= c.getEmail() %></td>
        <td><%= c.getPhone() %></td>
        
<td>
    <a href="editCustomer?id=<%= c.getId() %>">Edit</a> |
    <a href="deleteCustomer?id=<%= c.getId() %>">Delete</a>
</td>
    </tr>
<%
        }
    }
%>

</table>

<br>
<a href="addCustomer.jsp">Add New Customer</a>

</body>
</html>