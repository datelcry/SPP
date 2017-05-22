<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all cars</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="3">
    <thead>
    <tr>
        <th>car_id</th>
        <th>car_number</th>
        <th>car_category</th>
        <th>car_brand</th>
        <th>car_staff</th>
        <th>car_available</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.car_id}"/></td>
            <td><c:out value="${car.car_number}"/></td>
            <td><c:out value="${car.car_category}"/></td>
            <td><c:out value="${car.car_brand}"/></td>
            <td><c:out value="${car.car_staff}"/></td>
            <td><c:out value="${car.car_available}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_car">
                    <input type="hidden" name="car_id" value="${car.car_id}">
                    <input value="Update" type="submit">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_car">
                    <input type="hidden" name="car_id" value="${car.car_id}">
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
    <input type="hidden" name="command" value="to_create_car">
    <input value="Add car" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>