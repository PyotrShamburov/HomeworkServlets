<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1 style="font-size: medium">Registration new user!</h1>
<form action="/reg" method="post">
    <input type="text" name="name" placeholder="Name">
    <br>
    <input type="text" name="login" placeholder="Login">
    <br>
    <input type="text" name="password" placeholder="Password">
    <br>
    <button>Register</button>
</form>
${requestScope.result}<br>
<a href="/">Return to homepage!</a>
</body>
</html>
