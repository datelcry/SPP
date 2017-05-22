<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all brands</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="3">
    <thead>
    <tr>
        <th>brand_id</th>
        <th>brand_name</th>
        <th>brand_tariff</th>
        <th>brand_class</th>
        <th>brand_numbers_of_seats</th>
        <th>brand_issue_year</th>
        <th>brand_engine</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${brands}" var="brand">
        <tr>
            <td><c:out value="${brand.brand_id}"/></td>
            <td><c:out value="${brand.brand_name}"/></td>
            <td><c:out value="${brand.brand_tariff}"/></td>
            <td><c:out value="${brand.brand_class}"/></td>
            <td><c:out value="${brand.brand_numbers_of_seats}"/></td>
            <td><c:out value="${brand.brand_issue_year}"/></td>
            <td><c:out value="${brand.brand_engine}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_brand">
                    <input type="hidden" name="brand_id" value="${brand.brand_id}">
                    <input value="Update" type="submit">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_brand">
                    <input type="hidden" name="brand_id" value="${brand.brand_id}">
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
    <input type="hidden" name="command" value="to_create_brand">
    <input value="Add brand" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>