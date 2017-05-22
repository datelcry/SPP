<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="common/_header.jsp"></jsp:include>
<jsp:include page="common/_menu.jsp"></jsp:include>

<form method="post" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="login"/>
    <table>
        <tr>
            <td>Login:</td>
            <td><input name="user_login" type="text" maxlength="10"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input name="user_password" type="password" maxlength="20"></td>
        </tr>
        <tr>
            <td><input value="Login" type="submit"></td>
            <td><p style="color: red;">${error}</p></td>
        </tr>
    </table>
</form>

<form method="post" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="to_register">
</form>

<jsp:include page="common/_footer.jsp"></jsp:include>
</body>
</html>
