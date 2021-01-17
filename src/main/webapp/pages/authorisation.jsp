<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorisation</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form class="row g-3 needs-validation" novalidate action="/enter" method="post">
    <div class="col-md-3" style="width: 15%">
        <label class="form-label">Login: </label>
        <input type="text" class="form-control" name="login">
    </div>
    <div class="col-md-3" style="width: 15%">
        <label class="form-label">Password: </label>
        <input type="text" class="form-control" name="password">
    </div>
    <label style="color: red">${requestScope.result}</label>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Sing in!</button>
    </div>
</form>
</body>
</html>
