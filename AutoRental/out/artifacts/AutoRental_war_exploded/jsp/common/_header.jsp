<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="../../resources/css/style.css" media="all">

<div class="col-md-12">
    <div style="float: left">
        <h1>AutoRental</h1>
    </div>
    <c:if test="${user_login != null}">
        <c:if test="${user_role == 1}">
        <hr/>
            Hello, ${user_login}(admin)!
        <hr/>
        </c:if>
        <c:if test="${user_role != 1}">
            <hr/>
            Hello, ${user_login}!
            <hr/>
        </c:if>
    </c:if>
    <c:if test="${user_login == null}">
        <hr/>
            Hello, unknown user!
        <hr/>
    </c:if>
</div>
