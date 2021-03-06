<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
        <c:forEach items="${requestScope.books}" var="book">
            <div class="col">
                <div class="card h-100" style="mso-height-source: auto">
                    <img src="${book.url}" class="card-img-top" alt="..." >
                    <div class="card-body">
                        <h5 class="card-title">
                            <a href="/book/view?id=${book.id}">
                                <p class="fs-5">${book.title}</p>
                            </a>
                            <p class="fs-6">${book.author.firstName} ${book.author.lastName}</p>
                            <p class="fs-6">${book.price} byn.</p>
                        </h5>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
