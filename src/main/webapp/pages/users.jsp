<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsersList</title>
</head>
<body>
<h1 style="font-size: medium">List users of system!</h1>
<form action="/all" method="get"></form>
<p>${requestScope.result}</p>
<a href="/">Return to homepage</a><br>
</body>
</html>
