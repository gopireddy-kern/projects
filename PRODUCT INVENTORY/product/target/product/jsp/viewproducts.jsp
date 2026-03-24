<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<a href="addProduct.jsp">Add Product</a>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Qty</th>
<th>Category</th>
<th>Action</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
<td>${p.productId}</td>
<td>${p.productName}</td>
<td>${p.price}</td>
<td>${p.quantity}</td>
<td>${p.category}</td>
<td>
<a href="editProduct.jsp?id=${p.productId}">Edit</a>
<a href="deleteProduct?id=${p.productId}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
