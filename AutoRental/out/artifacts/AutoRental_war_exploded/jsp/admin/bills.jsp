<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all bills</title>
</head>
<body>

<jsp:include page="/jsp/common/_header.jsp"></jsp:include>
<jsp:include page="/jsp/common/_menu.jsp"></jsp:include>

<table border="1" cellpadding="7" cellspacing="3">
    <thead>
    <tr>
        <th>bill_id</th>
        <th>bill_code</th>
        <th>bill_cost</th>
        <th>bill_discount</th>
        <th>bill_order</th>
        <c:if test="${user_role == 1}">
        <th>Edit</th>
        <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${bills}" var="bill">
        <tr>
            <td><c:out value="${bill.bill_id}"/></td>
            <td><c:out value="${bill.bill_code}"/></td>
            <td><c:out value="${bill.bill_cost}"/></td>
            <td><c:out value="${bill.bill_discount}"/></td>
            <td><c:out value="${bill.bill_order}"/></td>
            <c:if test="${user_role == 1}">
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="to_update_bill">
                    <input type="hidden" name="bill_id" value="${bill.bill_id}">
                    <input value="Update" type="submit">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="POST">
                    <input type="hidden" name="command" value="delete_bill">
                    <input type="hidden" name="bill_id" value="${bill.bill_id}">
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
    <input type="hidden" name="command" value="to_create_bill">
    <input value="Add bill" type="submit">
</form>
</c:if>
<jsp:include page="/jsp/common/_footer.jsp"></jsp:include>

</body>
</html>