<%@ page session="true" %>

<%
    String user = (String) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h2>Welcome, <%= user %></h2>

<a href="logout">Logout</a>

</body>
</html>