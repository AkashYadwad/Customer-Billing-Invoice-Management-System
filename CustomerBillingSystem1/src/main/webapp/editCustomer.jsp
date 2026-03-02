<%@ page import="com.billing.model.Customer" %>
<%
Customer c = (Customer) request.getAttribute("customer");
%>

<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Edit Customer</h2>

<form action="updateCustomer" method="post">
    <input type="hidden" name="id" value="<%= c.getId() %>" />

    Name: <input type="text" name="name" value="<%= c.getName() %>" /><br><br>
    Email: <input type="text" name="email" value="<%= c.getEmail() %>" /><br><br>
    Phone: <input type="text" name="phone" value="<%= c.getPhone() %>" /><br><br>

    <input type="submit" value="Update" />
</form>

</body>
</html>