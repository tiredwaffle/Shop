<%--
  Created by IntelliJ IDEA.
  User: yulyz
  Date: 3/3/2021
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rest</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=login" method="post">
    <label for="surname">Surname: </label>
    <input type="text" name="surname" id="surname" required>
    <br>
    <input type="submit" name="login" value="LogIn">
</form>
</body>
</html>
