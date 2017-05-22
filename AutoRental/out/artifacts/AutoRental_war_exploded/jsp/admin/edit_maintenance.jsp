<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Maintenance info</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<form action="controller" method="post">
    <c:if test="${maintenance != null}">
        <input type="hidden" name="command" value="update_maintenance"/>
    </c:if>
    <c:if test="${maintenance == null}">
        <input type="hidden" name="command" value="create_maintenance"/>
    </c:if>

    <h2 class="form-heading">
        <c:if test="${maintenance != null}">
            Edit maintenance
        </c:if>
        <c:if test="${maintenance == null}">
            Add new maintenance
        </c:if>
    </h2>

    <table bmaintenance="1" cellpadding="7" cellspacing="1">
        <tr>
            <td>maintenance_id:</td>
            <td><input name="maintenance_id" type="text" class="form-control"
                       value="<c:out value="${maintenance.maintenance_id}"/>" readonly="readonly"/></td>
        <tr>
        <tr>
            <td>maintenance_defect:</td>
            <td><input name="maintenance_defect" type="text"  class="form-control" value="<c:out value="${maintenance.maintenance_defect}"/>"/>
            </td>
        <tr>
        <tr>
            <td>maintenance_cost:</td>
            <td><input name="maintenance_cost" maxlength="8" type="text" class="form-control" value="<c:out value="${maintenance.maintenance_cost}"/>"/></td>
        <tr>
        <tr>
            <td>maintenance_car:</td>
            <td><input name="maintenance_car" type="text"  class="form-control" value="<c:out value="${maintenance.maintenance_car}"/>"/>
            </td>
        <tr>
        <tr>
            <td>maintenance_staff:</td>
            <td><input name="maintenance_staff" type="text"  class="form-control" value="<c:out value="${maintenance.maintenance_staff}"/>"/>
            </td>
        <tr>
        <tr>
            <td>maintenance_date_begin:</td>
            <td><input name="maintenance_date_begin" type="text" class="form-control"
                       value="<c:out value="${maintenance.maintenance_date_begin}"/>"/></td>
        <tr>
        <tr>
            <td>maintenance_date_expir:</td>
            <td><input name="maintenance_date_expir" type="text" class="form-control"
                       value="<c:out value="${maintenance.maintenance_date_expir}"/>"/></td>
        <tr>
    </table>

    <c:if test="${maintenance != null}">
        <input value="Edit" type="submit">
    </c:if>
    <c:if test="${maintenance == null}">
        <input value="Add" type="submit">
    </c:if>
</form>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>
