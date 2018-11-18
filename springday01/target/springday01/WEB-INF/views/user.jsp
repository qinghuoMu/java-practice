<%--
  Created by IntelliJ IDEA.
  User: zpf
  Date: 2018/3/30
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Demo</title>
</head>
<body>
<table cellpadding=0 cellspacing=0 border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.userName}</td>
        <td>${user.age}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

