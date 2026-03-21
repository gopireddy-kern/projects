<%@ page import="java.sql.*" %>
<%@ page import="com.example.student.DBConnection" %>

<html>
<body>

<%
String sid = request.getParameter("id");

if(sid == null){
    out.println("Invalid Student ID");
    return;
}

int id = Integer.parseInt(sid);

Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

try{

con = DBConnection.getConnection();

ps = con.prepareStatement(
"SELECT * FROM students WHERE id=?");

ps.setInt(1,id);

rs = ps.executeQuery();

if(rs.next()){
%>

<h2>Edit Student</h2>

<form action ="<%= request.getContextPath() %>/updateStudent" method="post">

<input type="hidden" name="id" value="<%= rs.getInt("id") %>">

Name: <input type="text" name="name" value="<%= rs.getString("name") %>"><br>
Email: <input type="email" name="email" value="<%= rs.getString("email") %>"><br>
Course: <input type="text" name="course" value="<%= rs.getString("course") %>"><br>

<input type="submit" value="Update Student">

</form>

<br>
<a href="<%=request.getContextPath()%>/viewStudents.jsp">Back to Student List</a>
<%
}else{
out.println("Student not found");
}

}catch(Exception e){
out.println(e);
}

finally{
if(rs!=null) rs.close();
if(ps!=null) ps.close();
if(con!=null) con.close();
}
%>

</body>
</html>