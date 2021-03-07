<%--
  Created by IntelliJ IDEA.
  User: nisko
  Date: 05.03.2021
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${isActive == false}">
    <h1>ЧЕК ЗАКРЫТ!</h1>
    <hr/>
</c:if>
<h2>Добавить продукт в чек</h2>
<form action="controller?command=submit_checkitem" method="post">
    <label for="name_id">Введите имя или айди товара</label>
    <input type="text" name="name_id" id="name_id" required>
    <br>
    <br>
    <label for="name_id">Введите вес или количество товара</label>
    <input type="number" name="weight" id="weight" placeholder="Вес">
    <input type="number" name="amount" id="amount" placeholder="Количество">
    <br>
    <input type="submit" name="add" value="Добавить">
</form>
<hr/>
<c:if test="${isSenior == true}">
    <h2>Удалить продукт из чека</h2>
    <form action="controller?command=delete_checkitem" method="post">
        <label for="delete_item">Введите имя или айди товара</label>
        <input type="text" name="delete_item" id="delete_item" required>
        <br>
        <input type="submit" name="delete" value="Удалить">
    </form><br><br>

    <form action="controller?command=delete_check" method="post">
        <input type="submit" name="close_check" value="Закрыть чек">
    </form>
    <hr/>
</c:if>
<a href="controller?command=catalogue">Открыть каталог</a>

<h2>Check id ${check_id}</h2>
<%--<h3>Total price: ${total_price}</h3>--%>
<table style="width:50%">
    <tr>
        <td>Item ID</td>
        <td>Amount</td>
        <td>Weight</td>
        <td>Price</td>
<%--        <td>Amount Available</td>--%>
    </tr>
    <c:forEach items="${list_items}" var="curr_item">
        <tr>
            <td>${curr_item.itemId}</td>
            <td>${curr_item.itemAmount}</td>
            <td>${curr_item.itemWeight}</td>
            <td>${curr_item.itemPrice}</td>
<%--            <td>${curr_item.amountAvailable}</td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
