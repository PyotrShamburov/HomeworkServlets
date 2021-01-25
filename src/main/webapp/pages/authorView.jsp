<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <img src="${requestScope.author.urlPhoto}" style="height: 40%" align="left">
    <p><b>Id:</b> ${requestScope.author.id}</p>
    <p><b>Name:</b> ${requestScope.author.firstName}</p>
    <p><b>Surname:</b> ${requestScope.author.lastName}</p>
    <p><b>Information:</b> ${requestScope.author.description}</p>
    <div class="card" style="width: 18rem;">
        <div class="card-header">
            Books of author:
            ${requestScope.author.books.size()}
        </div>
        <ul>
            <c:forEach items="${requestScope.author.books}" var="book">
                <li><a href="/book/view?id=${book.id}">${book.title}</a></li>
            </c:forEach>
        </ul>
    </div>
    <c:if test="${sessionScope.isAdmin}">
        <form action="/admin/author/remove" method="post">
            <input type="hidden" name="id" value="${requestScope.author.id}">
            <button type="submit" class="btn btn-primary">Delete</button>
        </form>
        <c:if test="${requestScope.author.books.size()!=0}">
            <p style="color: red">You can remove author if his storage of books will empty!</p>
        </c:if>
    </c:if>
</div>
</body>
</html>
