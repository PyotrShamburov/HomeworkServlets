<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UsersList</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="list-group" style="width: 25%" style="text-align: center">
<c:forEach items="${requestScope.users}" var="user">
    <a class="list-group-item list-group-item-action">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">User Id: <b>${user.id}</b></h5>
        </div>
        <p class="mb-1">Name: ${user.userName}<br>
            Login: ${user.login} </p>
        <small class="text-muted">Password: ${user.password}</small>
    </a>
</c:forEach>
</div>
