<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Brand info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${brand != null}">
        <input type="hidden" name="command" value="update_brand"/>
    </c:if>
    <c:if test="${brand == null}">
        <input type="hidden" name="command" value="create_brand"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${brand != null}">
            Edit brand
        </c:if>
        <c:if test="${brand == null}">
            Add new brand
        </c:if>
    </h2>

    <table bbrand="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>brand_id:</td>
            <td><input name="brand_id" type="text" class="form-control"
                       value="<c:out value="${brand.brand_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
        <td>brand_name:</td>
        <td><input name="brand_name" type="text"  class="form-control" value="<c:out value="${brand.brand_name}"/>"/>
        </td>
        <tr>
        <tr>
            <td>brand_tariff:</td>
            <td><input name="brand_tariff" type="text"  class="form-control" value="<c:out value="${brand.brand_tariff}"/>"/>
            </td>
        <tr>
        <tr>
            <td>brand_class:</td>
            <td><input name="brand_class" type="text" class="form-control" value="<c:out value="${brand.brand_class}"/>"/></td>
        <tr>
        <tr>
            <td>brand_numbers_of_seats:</td>
            <td><input name="brand_numbers_of_seats" type="text" maxlength="2" class="form-control" value="<c:out value="${brand.brand_numbers_of_seats}"/>"/></td>
        <tr>
        <tr>
            <td>brand_issue_year:</td>
            <td><input name="brand_issue_year" type="text" maxlength="4" class="form-control" value="<c:out value="${brand.brand_issue_year}"/>"/></td>
        <tr>
        <tr>
            <td>brand_engine:</td>
            <td><input name="brand_engine" type="text" class="form-control" value="<c:out value="${brand.brand_engine}"/>"/></td>
        <tr>
    </table>

    <c:if test="${brand != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${brand == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
