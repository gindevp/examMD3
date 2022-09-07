<%--
  Created by IntelliJ IDEA.
  User: Huu Quyet
  Date: 9/6/2022
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<h1 style="text-align: center">List Students</h1>

<div>

    <form class="d-flex" role="search" action="/students" method="get">
        <a  class="btn btn-success" href="/students?action=add" >add</a>
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search " name="search" style="width: 40%">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>

<table class="table">
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Date of birth</td>
        <td>Address</td>
        <td>Phone</td>
        <td>Emai</td>
        <td>Classroom</td>
        <td colspan="2" style="text-align: center">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="students" items="${students}">
        <tr>
            <td>${students.id}</td>
            <td>${students.name}</td>
            <td>${students.dateOfBirth}</td>
            <td>${students.address}</td>
            <td>${students.phone}</td>
            <td>${students.email}</td>
            <td>${students.classroom_name}</td>
            <td style="text-align: center"><a type="button" class="btn btn-primary" href="/students?action=edit&id=${students.id}">edit</a></td>
            <td style="text-align: center"><a type="button" class="btn btn-danger" href="/students?action=remove&id=${students.id}">remote</a></td>
        </tr>
    </c:forEach></tbody>
</table>

</body>
</html>
