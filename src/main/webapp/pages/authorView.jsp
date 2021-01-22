<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <p><b>Id:</b> ${requestScope.author.id}</p>
    <p><b>Name:</b> ${requestScope.author.firstName}</p>
    <p><b>Surname:</b> ${requestScope.author.lastName}</p>
    <p><b>Information:</b> ${requestScope.author.description}</p>
    <div class="card" style="width: 18rem;">
        <div class="card-header">
            Books of this author:
        </div>
        <ul>
            <c:forEach items="${requestScope.books}" var="book">
                <li><a href="/book/view?id=${book.id}">${book.title}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
