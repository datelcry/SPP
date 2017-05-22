<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${client != null}">
        <input type="hidden" name="command" value="update_client"/>
    </c:if>
    <c:if test="${client == null}">
        <input type="hidden" name="command" value="create_client"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${client != null}">
            Edit client
        </c:if>
        <c:if test="${client == null}">
            Add new client
        </c:if>
    </h2>

    <table bclient="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>client_id:</td>
            <td><input name="client_id" type="text" class="form-control"
                       value="<c:out value="${client.client_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>client_full_name:</td>
            <td><input name="client_full_name" type="text" class="form-control" value="<c:out value="${client.client_full_name}"/>"/>
            </td>
        <tr>
        <tr>
            <td>client_number_passport:</td>
            <td><input name="client_number_passport" type="text" class="form-control" value="<c:out value="${client.client_number_passport}"/>"/></td>
        <tr>
        <tr>
            <td>client_number_license:</td>
            <td><input name="client_number_license" type="text" class="form-control" value="<c:out value="${client.client_number_license}"/>"/></td>
        <tr>
        <tr>
            <td>client_location:</td>
            <td><input name="client_location" type="text" class="form-control" value="<c:out value="${client.client_location}"/>"/></td>
        <tr>
        <tr>
            <td>client_number_phone:</td>
            <td><input name="client_number_phone" type="text" class="form-control" value="<c:out value="${client.client_number_phone}"/>"/></td>
        <tr>
        <tr>
            <td>client_account:</td>
            <td><input name="client_account" type="text" class="form-control" value="<c:out value="${client.client_account}"/>"/></td>
        <tr>
    </table>

    <c:if test="${client != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${client == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
