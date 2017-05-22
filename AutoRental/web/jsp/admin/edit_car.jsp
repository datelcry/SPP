<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Car info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${car != null}">
        <input type="hidden" name="command" value="update_car"/>
    </c:if>
    <c:if test="${car == null}">
        <input type="hidden" name="command" value="create_car"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${car != null}">
            Edit car
        </c:if>
        <c:if test="${car == null}">
            Add new car
        </c:if>
    </h2>

    <table bcar="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>car_id:</td>
            <td><input name="car_id" type="text" class="form-control"
                       value="<c:out value="${car.car_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>car_number:</td>
            <td><input name="car_number" type="text"  class="form-control" value="<c:out value="${car.car_number}"/>"/>
            </td>
        <tr>
        <tr>
            <td>car_category:</td>
            <td><input name="car_category" type="text" class="form-control" value="<c:out value="${car.car_category}"/>"/></td>
        <tr>
        <tr>
            <td>car_brand:</td>
            <td><input name="car_brand" type="text" class="form-control" value="<c:out value="${car.car_brand}"/>"/></td>
        <tr>
        <tr>
            <td>car_staff:</td>
            <td><input name="car_staff" type="text" class="form-control" value="<c:out value="${car.car_staff}"/>"/></td>
        <tr>
        <tr>
            <td>car_available:</td>
            <td><input name="car_available" type="text" class="form-control" value="<c:out value="${car.car_available}"/>"/></td>
        <tr>
    </table>

    <c:if test="${car != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${car == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
