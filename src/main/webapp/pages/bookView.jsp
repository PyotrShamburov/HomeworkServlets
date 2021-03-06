<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <img src="${requestScope.book.url}" style="height: 40%" align="left">
    <p><b>Id:</b> ${requestScope.book.id}</p>
    <p><b>Title:</b> ${requestScope.book.title}</p>
    <p><b>Description:</b> ${requestScope.book.description}</p>
    <p><b>Author:</b> <a href="/author/view?id=${book.author.id}">${requestScope.book.author.firstName} ${requestScope.book.author.lastName}</a> </p>
    <p><b>Year of publishing:</b> ${requestScope.book.yearOfPublishing}</p>
    <p><b>Price:</b> ${requestScope.book.price} byn.</p>
    <c:if test="${sessionScope.isUser}">
        <form action="/user/basket" method="post">
            <input type="hidden" name="id" value="${requestScope.book.id}">
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </c:if>
    <c:if test="${sessionScope.isGuest}">
        <p class="fs-6">Add books to basket can authorized users only!</p>
    </c:if>
    <c:if test="${sessionScope.isAdmin}">
        <form action="/admin/book/remove" method="post">
            <input type="hidden" name="id" value="${requestScope.book.id}">
            <button type="submit" class="btn btn-primary">Delete</button>
        </form>
    </c:if>

</div>
</body>
</html>
