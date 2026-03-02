<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Add Product</h2>

<form action="addProduct" method="post">
    Name: <input type="text" name="name" required /><br><br>
    Price: <input type="number" step="0.01" name="price" required /><br><br>
    Quantity: <input type="number" name="quantity" required /><br><br>

    <input type="submit" value="Save Product" />
</form>

<br>
<a href="viewProducts">View Products</a>

</body>
</html>