<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all maintenances</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="1">
    <thead>
    <tr>
        <th>maintenance_id</th>
        <th>maintenance_defect</th>
        <th>maintenance_cost</th>
        <th>maintenance_car</th>
        <th>maintenance_staff</th>
        <th>maintenance_date_begin</th>
        <th>maintenance_date_expir</th>
        <c:if test="${user_role == 1}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${maintenances}" var="maintenance">
        <tr>
            <td><c:out value="${maintenance.maintenance_id}"/></td>
            <td><c:out value="${maintenance.maintenance_defect}"/></td>
            <td><c:out value="${maintenance.maintenance_cost}"/></td>
            <td><c:out value="${maintenance.maintenance_car}"/></td>
            <td><c:out value="${maintenance.maintenance_staff}"/></td>
            <td><c:out value="${maintenance.maintenance_date_begin}"/></td>
            <td><c:out value="${maintenance.maintenance_date_expir}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_maintenance">
                    <input type="hidden" name="maintenance_id" value="${maintenance.maintenance_id}">
                    <input value="Update" type="submit">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_maintenance">
                    <input type="hidden" name="maintenance_id" value="${maintenance.maintenance_id}">
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
    <input type="hidden" name="command" value="to_create_maintenance">
    <input value="Add maintenance" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>