<%--
  Created by IntelliJ IDEA.
  User: yulyz
  Date: 05.03.2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form" action="controller?command=submit_selectedcheck" method="post">
    <label>Выберите чек</label>
    <select name="check_id">
        <c:forEach items="${checks}" var="check">
            <option value="${check.id}">${check.id} ${!check.active ? "- closed" : ""}</option>
        </c:forEach>
    </select>
    <button class="form_button" type="submit" name="form_submit">Выбрать</button>
</form>
<hr>
<form class="form" action="controller?command=create_check" method="post">
    <button class="form_button" type="submit" name="form_submit">Создать чек</button>
</form>
</body>
</html>
