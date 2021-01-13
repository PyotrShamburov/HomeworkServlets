<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorisation</title>
</head>
<body>
<h1 style="font-size: medium">Enter your login and password for enter to system!</h1>
<form action="/enter" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="text" name="password" placeholder="Password">
    <br>
    <button>Sing in!</button>
</form>
${requestScope.result}<br>
<a href="/">Return to homepage!</a>
</body>
</html>
