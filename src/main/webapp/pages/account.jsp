<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
