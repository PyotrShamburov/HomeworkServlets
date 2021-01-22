<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="card" style="width: 18rem;">
    <div class="card-header">
        Profile information:
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">ID: ${requestScope.userId}</li>
        <li class="list-group-item">Name: ${requestScope.userName}</li>
        <li class="list-group-item">Login: ${requestScope.userLogin}</li>
        <li class="list-group-item">Password: ${requestScope.userPassword}</li>
    </ul>
</div>
<br>
<div class="card" style="width: 18rem;">
<div class="card-header">
    Basket:
</div>
    <ul>
        <c:forEach items="${sessionScope.basket.getAll()}" var="book">
            <li><a href="/book/view?id=${book.id}">${book.title}</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
