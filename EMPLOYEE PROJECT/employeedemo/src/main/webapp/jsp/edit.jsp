<form action="update" method="post">
    <input type="hidden" name="id" value="${emp.empId}">
    Name: <input type="text" name="name" value="${emp.empName}"><br>
    Dept: <input type="text" name="dept" value="${emp.department}"><br>
    Salary: <input type="text" name="salary" value="${emp.salary}"><br>
    <input type="submit" value="Update">
</form>