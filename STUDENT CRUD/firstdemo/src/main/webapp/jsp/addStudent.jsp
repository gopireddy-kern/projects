<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>

</head>

<body>

<h2>Add Student</h2>

<form action = "<%= request.getContextPath() %>/addStudent" method="post" autocomplete="off">

    Name: <input type="text" name="name"><br><br>

    Email: <input type="email" name="email"><br><br>

   Course: <input type="text" name="course"><br><br>
   <input type="submit" value="Add Student">
   <input type="reset" value="Clear">

</form>

<br>
<a href="<%=request.getContextPath()%>/viewStudents.jsp">View Students</a>

</body>
</html>