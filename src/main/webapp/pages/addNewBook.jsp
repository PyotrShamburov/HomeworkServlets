<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container" style="text-align: left" style="width: 50%">
    <form novalidate action="/admin/book/add" method="post" >
        <div class="mb-3" style="width: 50%">
            <label class="form-label">Title: </label>
            <input type="text" class="form-control" name="title">
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleFormControlTextarea1" class="form-label">Description:</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="info" rows="3"></textarea>
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >Author name: </label>
            <input type="text" class="form-control" name="authorName">
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >Author surname: </label>
            <input type="text" class="form-control" name="authorSurname">
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >Year of publishing: </label>
            <input type="text" class="form-control" name="year">
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >Price: </label>
            <input type="text" class="form-control" name="price">
        </div>
        <div class="mb-3" style="width: 50%">
            <label class="form-label" >URL photo:  </label>
            <input type="text" class="form-control" name="url">
        </div>

        <div class="col-12">
            <button class="btn btn-primary" type="submit">Add book</button>
        </div>
    </form>
    <label style="color: red">${requestScope.result}</label>
</div>
</body>
</html>
