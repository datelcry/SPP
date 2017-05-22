<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all staff</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="1">
    <thead>
    <tr>
        <th>staff_id</th>
        <th>staff_full_name</th>
        <th>staff_post</th>
        <th>staff_salary</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${staff}" var="staff">
        <tr>
            <td><c:out value="${staff.staff_id}"/></td>
            <td><c:out value="${staff.staff_full_name}"/></td>
            <td><c:out value="${staff.staff_post}"/></td>
            <td><c:out value="${staff.staff_salary}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_staff">
                    <input type="hidden" name="staff_id" value="${staff.staff_id}">
                    <input value="Update" type="submit">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_staff">
                    <input type="hidden" name="staff_id" value="${staff.staff_id}">
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
    <input type="hidden" name="command" value="to_create_staff">
    <input value="Add staff" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>