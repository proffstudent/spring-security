<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Пользователи</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>Users</h1>
<form action="users" method="post">
    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th><a href="/user?id=${user.id}">USER</a></th>
            <th><a href="/articles?id=${user.id}">ARTICLES</a></th>
            <th><a href="/users">USERS</a></th>
            <th><a href="/adduser?id=${user.id}">REVIEWERS</a></th>
            <th><a href="/adduser?id=${user.id}">REVIEWERS</a></th>
        </tr>
    </table>

    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>LASTNAME</th>
            <th>EMAIL</th>
            <th>WORKPLACE</th>
            <th>ACCESSLEVEL</th>
            <th>OPERATION</th>
        </tr>
        <c:forEach items="${users}" var="user">

            <tr>
                <td><c:out value="${user.id}"></c:out></td>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.lastName}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.workplace}"></c:out></td>
                <td><c:out value="${user.accessLevel}"></c:out></td>
                <td><a href="/adduser?id=${user.id}">edit</a>
                    /
                    <a href="/deleteuser?id=${user.id}">del</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/adduser?id=${0}">Добавить</a>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
