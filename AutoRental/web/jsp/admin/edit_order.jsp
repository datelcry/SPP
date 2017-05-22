<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${order != null}">
        <input type="hidden" name="command" value="update_order"/>
    </c:if>
    <c:if test="${order == null}">
        <input type="hidden" name="command" value="create_order"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${order != null}">
            Edit order
        </c:if>
        <c:if test="${order == null}">
            Add new order
        </c:if>
    </h2>

    <table border="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>order_id:</td>
            <td><input name="order_id" type="text" class="form-control"
                       value="<c:out value="${order.order_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>order_client:</td>
            <td><input name="order_client" type="text"  class="form-control" value="<c:out value="${order.order_client}"/>"/>
            </td>
        <tr>
        <tr>
            <td>order_car:</td>
            <td><input name="order_car" maxlength="8" type="text" class="form-control"
                       value="<c:out value="${order.order_car}"/>"/></td>
        <tr>
        <tr>
            <td>order_date_begin:</td>
            <td><input name="order_date_begin" type="text" class="form-control"
                       value="<c:out value="${order.order_date_begin}"/>"/></td>
        <tr>
        <tr>
            <td>order_date_expir:</td>
            <td><input name="order_date_expir" type="text" class="form-control"
                       value="<c:out value="${order.order_date_expir}"/>"/></td>
        <tr>
    </table>

    <c:if test="${order != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${order == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
