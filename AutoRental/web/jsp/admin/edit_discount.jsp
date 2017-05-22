<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Discount info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${discount != null}">
        <input type="hidden" name="command" value="update_discount"/>
    </c:if>
    <c:if test="${discount == null}">
        <input type="hidden" name="command" value="create_discount"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${discount != null}">
            Edit discount
        </c:if>
        <c:if test="${discount == null}">
            Add new discount
        </c:if>
    </h2>

    <table border="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>discount_id:</td>
            <td><input name="discount_id" type="text" class="form-control"
                       value="<c:out value="${discount.discount_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>discount_name:</td>
            <td><input name="discount_name" type="text" class="form-control" value="<c:out value="${discount.discount_name}"/>"/>
            </td>
        <tr>
        <tr>
            <td>discount_value:</td>
            <td><input name="discount_value" maxlength="8" type="text" class="form-control"
                       value="<c:out value="${discount.discount_value}"/>"/></td>
        <tr>
    </table>

    <c:if test="${discount != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${discount == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
