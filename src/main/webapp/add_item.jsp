<%--
  Created by IntelliJ IDEA.
  User: yulyz
  Date: 06.03.2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<h2>Добавить товар</h2>
<form action="controller?command=submit_item" method="post">
    <label for="item_name">Введите имя товара</label>
    <input type="text" name="item_name" id="item_name" required>
    <br><br>
    <label for="item_amount">Введите количество товара</label>
    <input type="number" name="item_amount" id="item_amount" required>
    <br><br>
    <label for="item_weight">Введите вес товара</label>
    <input type="number" name="item_weight" id="item_weight" required>
    <br><br>
    <label for="item_price">Введите цену товара</label>
    <input type="number" name="item_price" id="item_price" required>
    <br><br>
    <input type="submit" name="add_item" value="Добавить товар">
</form><hr/><br><br>
<h2>Удалить товар</h2>
<form action="controller?command=delete_item" method="post">
    <label for="item_name">Введите ID товара</label>
    <input type="number" name="item_id" id="item_id" required>
    <br><br>
    <input type="submit" name="delete_item" value="Удалить товар">
</form><hr/><br><br>

<h2>Items:</h2>
<table style="width:100%" >
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
