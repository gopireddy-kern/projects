<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<a href="${pageContext.request.contextPath}/jsp/add.jsp">

<table border="1">
<tr>
    <th>ID</th><th>Name</th><th>Dept</th><th>Salary</th><th>Action</th>
</tr>

<c:forEach var="e" items="${list}">
<tr>
    <td>${e.empId}</td>
    <td>${e.empName}</td>
    <td>${e.department}</td>
    <td>${e.salary}</td>
    <td>
          <c:url var="delUrl" value="/delete">
            <c:param name="id" value="${e.empId}" />
        </c:url>

        <a href="${pageContext.request.contextPath}/delete?id=${emp.empId}"></a>
    </td>
</tr>
</c:forEach>
</table>
       