<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all discounts</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="1">
    <thead>
    <tr>
        <th>discount_id</th>
        <th>discount_name</th>
        <th>discount_value</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${discounts}" var="discount">
        <tr>
            <td><c:out value="${discount.discount_id}"/></td>
            <td><c:out value="${discount.discount_name}"/></td>
            <td><c:out value="${discount.discount_value}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_discount">
                    <input type="hidden" name="discount_id" value="${discount.discount_id}">
                    <input value="Update" type="submit">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_discount">
                    <input type="hidden" name="discount_id" value="${discount.discount_id}">
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
    <input type="hidden" name="command" value="to_create_discount">
    <input value="Add discount" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>