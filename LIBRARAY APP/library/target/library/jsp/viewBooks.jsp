<%@ page import="java.sql.*" %>
<%@ page import="com.example.util.DBConnection" %>

<a href= "jsp/addBook.jsp">Add Book</a>

<form action="../searchBook" method="get">
    Search Title: <input type="text" name="title">
    <input type="submit" value="Search">
</form>

<table border="1">
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Category</th>
    <th>Quantity</th>
    <th>Actions</th>
</tr>

<%
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement("SELECT * FROM books");
ResultSet rs = ps.executeQuery();

while(rs.next()){
%>
<tr>
<td><%=rs.getInt("book_id")%></td>
<td><%=rs.getString("title")%></td>
<td><%=rs.getString("author")%></td>
<td><%=rs.getString("category")%></td>
<td><%=rs.getInt("quantity")%></td>

<td>
<a href="editBook.jsp?id=<%=rs.getInt("book_id")%>">Edit</a>
<a href="../deleteBook?id=<%=rs.getInt("book_id")%>">Delete</a>
</td>
</tr>
<%
}
%>

</table>