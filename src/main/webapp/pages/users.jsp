<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UsersList</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" >
    <ul class="list-group" style="width: 30%">
        <h4><span class="badge bg-secondary">Users of system: </span></h4>
        <c:forEach items="${requestScope.users}" var="user">
            <li class="list-group-item" style="text-align: center">
                ${user.userName} (${user.login})
            </li>
        </c:forEach>
    </ul>
</div>
<p>${requestScope.result}</p>
</body>
</html>
