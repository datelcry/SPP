<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.03.2017
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show all orders</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>order_id</th>
        <th>order_client</th>
        <th>order_car</th>
        <th>order_date_begin</th>
        <th>order_date_expir</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td><c:out value="${order.order_id}" /></td>
            <td><c:out value="${order.order_client}" /></td>
            <td><c:out value="${order.order_car}" /></td>
            <td><c:out value="${order.order_date_begin}" /></td>
            <td><c:out value="${order.order_date_expir}" /></td>
            <td><a href="OrderServlet?action=edit&order_id=<c:out value="${order.order_id}"/>">Update</a></td>
            <td><a href="OrderServlet?action=delete&order_id=<c:out value="${order.order_id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="OrderServlet?action=insert">Add order</a></p>
</body>
</html>
