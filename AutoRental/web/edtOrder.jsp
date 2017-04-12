<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.03.2017
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Add new orders</title>
</head>
<body>
<form method="post" action="OrderServlet?action=post">
    ID : <label>
    <input
            type="text" name="order_id" readonly="readonly" style="display: hidden"
            value="<c:out value="${order.order_id}" />"/>
</label> <br/>
    Client : <label>
    <input
            type="text" name="order_client"
            value="<c:out value="${order.order_client}" />"/>
</label> <br/>

    Car: <label>
    <input
            type="text" name="order_car"
            value="<c:out value="${order.order_car}" />"/>
</label> <br/>

    Date beginning: <label>
    <input
            type="text" name="order_date_begin"
            value="<c:out value="${order.order_date_begin}" />"/>
</label> <br/>

    Date expiration: <label>
    <input
            type="text" name="order_date_expir"
            value="<c:out value="${order.order_date_expir}" />"/>
</label> <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
