<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Staff info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${staff != null}">
        <input type="hidden" name="command" value="update_staff"/>
    </c:if>
    <c:if test="${staff == null}">
        <input type="hidden" name="command" value="create_staff"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${staff != null}">
            Edit staff
        </c:if>
        <c:if test="${staff == null}">
            Add new staff
        </c:if>
    </h2>

    <table border="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>staff_id:</td>
            <td><input name="staff_id" type="text" class="form-control"
                       value="<c:out value="${staff.staff_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>staff_full_name:</td>
            <td><input name="staff_full_name" type="text" class="form-control" value="<c:out value="${staff.staff_full_name}"/>"/>
            </td>
        <tr>
        <tr>
            <td>staff_post:</td>
            <td><input name="staff_post" type="text" class="form-control" value="<c:out value="${staff.staff_post}"/>"/></td>
        <tr>
        <tr>
            <td>staff_salary:</td>
            <td><input name="staff_salary" type="text" class="form-control" value="<c:out value="${staff.staff_salary}"/>"/></td>
        <tr>
    </table>

    <c:if test="${staff != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${staff == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
