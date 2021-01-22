<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <h1 style="font-size: medium">
        Available books in store:
    </h1>
    <ul>
        <c:forEach items="${requestScope.books}" var="book">
            <li><a href="/book/view?id=${book.id}">${book.title}</a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
