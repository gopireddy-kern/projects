<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="../login" method="post">
    Email: <input type="email" name="email"/>
    Password: <input type="password" name="password" />
      <input type="submit" value="Login" />
</form>

<%
    String error = request.getParameter("error");
    if (error != null) {
%>
    <p style="color:red;">Invalid Credentials</p>
<%
    }
%>

<a href="register.jsp">Register</a>

</body>
</html>