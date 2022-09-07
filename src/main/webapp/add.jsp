<%--
  Created by IntelliJ IDEA.
  User: Huu Quyet
  Date: 9/6/2022
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<form  method="post">
    <h1>Add student</h1>
    <a type="button" class="btn btn-primary" href="/students">Quay lại trang list students</a>
    <c:if test="${message!=null}">
        <h5 style="color: green"> ${message}</h5>
    </c:if>
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" class="form-control" id="name" placeholder="Name" name="name">
    </div>
    <div class="mb-3">
        <label for="dateOfBirth" class="form-label">DateOfBirth:</label>
        <input type="date" class="form-control" id="dateOfBirth" placeholder="dateOfBirth" name="dateOfBirth">
    </div>
    <div class="mb-3 mt-3">
        <label for="address" class="form-label">Address:</label>
        <input type="text" class="form-control" id="address" placeholder="address" name="address">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone:</label>
        <input type="text" class="form-control" id="phone" placeholder="phone" name="phone">
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" id="email" placeholder="email" name="email">
    </div>
    <select class="form-select" name="classroom_id">
        <c:forEach items="${studentsC}" var="studentsC">
        <option value="${studentsC.id}">${studentsC.classroom_name}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
