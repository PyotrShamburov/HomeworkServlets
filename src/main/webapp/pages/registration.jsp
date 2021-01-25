<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align: -webkit-center">
    <form novalidate action="/reg" method="post" >
        <div class="mb-3" style="width: 25%">
            <label class="form-label">Name: </label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="mb-3" style="width: 25%">
            <label class="form-label" >Login: </label>
            <input type="text" class="form-control" name="login">
        </div>
        <div class="mb-3" style="width: 25%">
            <label class="form-label" >Password: </label>
            <input type="password" class="form-control" name="password">
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Register</button>
        </div>
        <label style="color: red">${requestScope.result}</label>
    </form>
</div>
</body>
</html>
