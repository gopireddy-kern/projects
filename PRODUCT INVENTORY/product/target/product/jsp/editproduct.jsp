<%@ page import="java.sql.*" %>
<%@ page import="com.example.util.DBConnection" %>

<%
String id = request.getParameter("id");

Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement(
    "SELECT * FROM products WHERE product_id=?"
);

ps.setInt(1, Integer.parseInt(id));
ResultSet rs = ps.executeQuery();
rs.next();
%>

<form action="updateProduct" method="post">
     <input type="hidden" name="id" value="${product.productId}">

    Name: <input type="text" name="name" value="${product.productName}"><br>
    Price: <input type="text" name="price" value="${product.price}"><br>
    Quantity: <input type="text" name="quantity" value="${product.quantity}"><br>
    Category: <input type="text" name="category" value="${product.category}"><br>

    <input type="submit" value="Update">
</form>
