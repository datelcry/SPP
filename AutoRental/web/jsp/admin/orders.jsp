<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all orders</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="1">
    <thead>
    <tr>
        <th>order_id</th>
        <th>order_client</th>
        <th>order_car</th>
        <th>order_date_begin</th>
        <th>order_date_expir</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td><c:out value="${order.order_id}"/></td>
            <td><c:out value="${order.order_client}"/></td>
            <td><c:out value="${order.order_car}"/></td>
            <td><c:out value="${order.order_date_begin}"/></td>
            <td><c:out value="${order.order_date_expir}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_order">
                    <input type="hidden" name="order_id" value="${order.order_id}">
                    <input value="Update" type="submit">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_order">
                    <input type="hidden" name="order_id" value="${order.order_id}">
                    <input value="Delete" type="submit">
                </form>
            </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${user_role == 1}">
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="to_create_order">
    <input value="Add order" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>