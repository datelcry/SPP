<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Bill info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${bill != null}">
        <input type="hidden" name="command" value="update_bill"/>
    </c:if>
    <c:if test="${bill == null}">
        <input type="hidden" name="command" value="create_bill"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${bill != null}">
            Edit bill
        </c:if>
        <c:if test="${bill == null}">
            Add new bill
        </c:if>
    </h2>

    <table bbill="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>bill_id:</td>
            <td><input name="bill_id" type="text" class="form-control"
                       value="<c:out value="${bill.bill_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>bill_code:</td>
            <td><input name="bill_code" type="text"  class="form-control" value="<c:out value="${bill.bill_code}"/>"/>
            </td>
        <tr>
        <tr>
            <td>bill_cost:</td>
            <td><input name="bill_cost" type="text"  class="form-control" value="<c:out value="${bill.bill_cost}"/>"/>
            </td>
        <tr>
        <tr>
            <td>bill_discount:</td>
            <td><input name="bill_discount" type="text" class="form-control" value="<c:out value="${bill.bill_discount}"/>"/></td>
        <tr>
        <tr>
            <td>bill_order:</td>
            <td><input name="bill_order" type="text" class="form-control" value="<c:out value="${bill.bill_order}"/>"/></td>
        <tr>
    </table>

    <c:if test="${bill != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${bill == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
