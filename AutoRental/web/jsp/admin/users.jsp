<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all users</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="3">
    <thead>
    <tr>
        <th>user_id</th>
        <th>user_login</th>
        <th>user_password</th>
        <th>user_email</th>
        <th>user_role</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.user_id}"/></td>
            <td><c:out value="${user.user_login}"/></td>
            <td><c:out value="${user.user_password}"/></td>
            <td><c:out value="${user.user_email}"/></td>
            <td><c:out value="${user.user_role}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_user">
                    <input type="hidden" name="user_id" value="${user.user_id}">
                    <input value="Update" type="submit">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_user">
                    <input type="hidden" name="user_id" value="${user.user_id}">
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
    <input type="hidden" name="command" value="to_create_user">
    <input value="Add user" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>