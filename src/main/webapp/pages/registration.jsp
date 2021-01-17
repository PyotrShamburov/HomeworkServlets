<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form class="row g-3 needs-validation" novalidate action="/reg" method="post">
    <div class="col-md-3" style="width: 15%">
        <label class="form-label">Name: </label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="col-md-3" style="width: 15%">
        <label class="form-label" >Login: </label>
        <input type="text" class="form-control" name="login">
    </div>
    <div class="col-md-3" style="width: 15%">
        <label class="form-label" >Password: </label>
        <input type="text" class="form-control" name="password">
    </div>
    <label style="color: red">${requestScope.result}</label>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Register</button>
    </div>
    <p class="text-start">After registration you will redirect to authorisation page!</p>
</form>
</body>
</html>
