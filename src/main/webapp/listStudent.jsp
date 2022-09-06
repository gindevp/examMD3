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
</head>
<body>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Date of birth</td>
        <td>Address</td>
        <td>Phone</td>
        <td>Emai</td>
        <td>Classroom</td>
        <td colspan="2">Action</td>
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
            <td>${students.classroom_id}</td>
            <td><a type="button" href="/students?action=edit&id=${students.id}">edit</a></td>
            <td><a type="button" href="/students?action=remove&id=${students.id}">remote</a></td>
        </tr>
    </c:forEach></tbody>
</table>

</body>
</html>
