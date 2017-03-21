<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>
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
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.lastName}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.workplace}"></c:out></td>
            <td><c:out value="${user.accessLevel}"></c:out></td>
            <td><a href="/adduser?id=${user.id}">edit</a>
        </tr>
    </table>

    <sec:authorize access="isAuthenticated()">
        <p>Ваш логин: <sec:authentication property="principal.username" /></p>
        <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
    </sec:authorize>

</form>
</body>
</html>
