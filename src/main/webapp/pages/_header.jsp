<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
<ul class="nav nav-pills">
    <c:if test="${sessionScope.user == null}">
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/reg">Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/enter">Sing in!</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello, Guest!</a>
        </li>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/user/account">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/user/all">Users</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/user/calc">Calculator</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="font-size: medium" href="/user/out">Logout</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" style="font-size: medium" href="#" tabindex="-1" aria-disabled="true">Hello, ${sessionScope.user.userName}!</a>
        </li>
    </c:if>
</ul>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
