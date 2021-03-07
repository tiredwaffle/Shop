
<%--
  Created by IntelliJ IDEA.
  User: yulyz
  Date: 3/3/2021
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Catalogue</title>
</head>
<body>
<h2>Items:</h2>
<table style="width:100%">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Weight</td>
        <td>Price</td>
        <td>Amount Available</td>
    </tr>
    <c:forEach items="${list_items}" var="curr_item">
        <tr>
            <td>${curr_item.id}</td>
            <td>${curr_item.name}</td>
            <td>${curr_item.weight}</td>
            <td>${curr_item.price}</td>
            <td>${curr_item.amountAvailable}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
