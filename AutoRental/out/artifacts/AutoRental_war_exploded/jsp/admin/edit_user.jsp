<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${user != null}">
        <input type="hidden" name="command" value="update_user"/>
    </c:if>
    <c:if test="${user == null}">
        <input type="hidden" name="command" value="create_user"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${user != null}">
            Edit user
        </c:if>
        <c:if test="${user == null}">
            Add new user
        </c:if>
    </h2>

    <table buser="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>user_id:</td>
            <td><input name="user_id" type="text" class="form-control"
                       value="<c:out value="${user.user_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>user_login:</td>
            <td><input name="user_login" type="text"  class="form-control" value="<c:out value="${user.user_login}"/>"/>
            </td>
        <tr>
        <tr>
            <td>user_password:</td>
            <td><input name="user_password" type="text" class="form-control" value="<c:out value="${user.user_password}"/>"/></td>
        <tr>
        <tr>
            <td>user_email:</td>
            <td><input name="user_email" type="text" class="form-control" value="<c:out value="${user.user_email}"/>"/></td>
        <tr>
        <tr>
            <td>user_role:</td>
            <td><input name="user_role" type="text" class="form-control" value="<c:out value="${user.user_role}"/>"/></td>
        <tr>
    </table>

    <c:if test="${user != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${user == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<p style="color: red;">${error_login}</p>
<p style="color: red;">${error_password}</p>
<p style="color: red;">${error_email}</p>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
