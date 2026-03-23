<%@ page import="java.sql.*" %>
<%@ page import="com.example.util.DBConnection" %>

<%
String id = request.getParameter("id");
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE book_id=?");
ps.setInt(1, Integer.parseInt(id));
ResultSet rs = ps.executeQuery();
rs.next();
%>

<form action="../updateBook" method="post">
<input type="hidden" name="id" value="<%=rs.getInt("book_id")%>">

Title: <input type="text" name="title" value="<%=rs.getString("title")%>"><br>
Author: <input type="text" name="author" value="<%=rs.getString("author")%>"><br>
Category: <input type="text" name="category" value="<%=rs.getString("category")%>"><br>
Quantity: <input type="number" name="quantity" value="<%=rs.getInt("quantity")%>"><br>

<input type="submit" value="Update">
</form>