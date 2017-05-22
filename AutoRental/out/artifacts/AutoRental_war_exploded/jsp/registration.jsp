<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AutoRental Registration</title>
</head>

<body>

<jsp:include page="common/_header.jsp"></jsp:include>
<jsp:include page="common/_menu.jsp"></jsp:include>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="register"/>
    <table>
        <tr><td>Login:</td><td><input name="user_login" type="text" maxlength="20"></td></tr>
        <tr><td>Password:</td><td><input name="user_password" type="password" maxlength="20"></tr>
        <tr><td>Email:</td><td><input name="user_email" type="text" maxlength="40"></td></tr>
        <tr><td>Full name:</td><td><input name="client_full_name" type="text" maxlength="40"></tr>
        <tr><td><input value="Join!" type="submit"></td></tr>
    </table>
    <p style="color: red;">${error_login}</p>
    <p style="color: red;">${error_password}</p>
    <p style="color: red;">${error_email}</p>
    <p style="color: red;">${error_message}</p>
</form>

<jsp:include page="common/_footer.jsp"></jsp:include>

</body>
</html>