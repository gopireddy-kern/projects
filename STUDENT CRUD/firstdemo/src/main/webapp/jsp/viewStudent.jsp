<%@ page import="java.sql.*" %>
<%@ page import="com.example.student.DBConnection" %>

<html>
<head>
     <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>

    <%
response.setContentType("text/html;charset=UTF-8");
request.setCharacterEncoding("UTF-8");
%>

<h2>Student List</h2>

<a href="addStudent.jsp">Add New Student</a>

<br><br>


<table border="1" cellpadding="5" cellspacing="0">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%

Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try{

con = DBConnection.getConnection();

stmt = con.createStatement();

rs = stmt.executeQuery("SELECT * FROM students");

while(rs.next()){
    
%>

<tr>

<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("course")%></td>

<td>
<a href="editStudent.jsp?id=<%=rs.getInt("id")%>">Edit</a>
</td>

<td>
<a href="<%=request.getContextPath()%>/deleteStudent?id=<%=rs.getInt("id")%>">Delete</a>
</td>

</tr>

<%
}

}catch(Exception e){
out.println(e);
}

finally{

try{
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
if(con!=null) con.close();
}catch(Exception e){
out.println(e);
}

}

%>

</table>

</body>
</html>


