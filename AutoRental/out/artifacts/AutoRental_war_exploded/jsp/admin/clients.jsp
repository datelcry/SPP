<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all clients</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="3">
    <thead>
    <tr>
        <th>client_id</th>
        <th>client_full_name</th>
        <th>client_number_passport</th>
        <th>client_number_license</th>
        <th>client_location</th>
        <th>client_number_phone</th>
        <th>client_account</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td><c:out value="${client.client_id}"/></td>
            <td><c:out value="${client.client_full_name}"/></td>
            <td><c:out value="${client.client_number_passport}"/></td>
            <td><c:out value="${client.client_number_license}"/></td>
            <td><c:out value="${client.client_location}"/></td>
            <td><c:out value="${client.client_number_phone}"/></td>
            <td><c:out value="${client.client_account}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_client">
                    <input type="hidden" name="client_id" value="${client.client_id}">
                    <input value="Update" type="submit">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_client">
                    <input type="hidden" name="client_id" value="${client.client_id}">
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
    <input type="hidden" name="command" value="to_create_client">
    <input value="Add client" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>