<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align:left">
    <form novalidate action="/admin/author/add" method="post" >
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >Name: </label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >Surname: </label>
            <input type="text" class="form-control" name="surname">
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleFormControlTextarea1" class="form-label">Description:</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="bio" rows="3"></textarea>
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >URL photo:  </label>
            <input type="text" class="form-control" name="url">
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Add author</button>
        </div>
    </form>
    <label style="color: red">${requestScope.result}</label>
</div>
</body>
</html>
