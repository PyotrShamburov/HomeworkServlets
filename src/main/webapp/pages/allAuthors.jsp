<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
        <c:forEach items="${requestScope.authors}" var="author">
            <div class="col">
                <div class="card h-100" style="mso-height-source: auto">
                    <img src="${author.urlPhoto}" class="card-img-top" alt="..." >
                    <div class="card-body">
                        <h5 class="card-title">
                            <a href="/author/view?id=${author.id}">
                                <p class="fs-5">${author.firstName} ${author.lastName}</p>
                            </a>
                        </h5>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
