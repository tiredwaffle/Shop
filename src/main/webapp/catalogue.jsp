
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
<a href="login.jsp">Log in</a>
<h2>Items:</h2>
<table style="width:100%" class="styled-table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Weight</td>
        <td>Price</td>
        <td>Amount Available</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list_items}" var="curr_item">
        <tr>
            <td>${curr_item.id}</td>
            <td>${curr_item.name}</td>
            <td>${curr_item.weight}</td>
            <td>${curr_item.price}</td>
            <td>${curr_item.amountAvailable}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
<style>
.styled-table {
border-collapse: collapse;
margin: 25px 0;
font-size: 0.9em;
font-family: sans-serif;
min-width: 400px;
box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}

.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}

</style>
</html>
