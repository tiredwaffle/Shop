<%--
  Created by IntelliJ IDEA.
  User: yulyz
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
<div class="form-style-6">
<h1>Добавить продукт в чек</h1>
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
</div>
<c:if test="${isSenior == true}">
    <div class="form-style-6">
    <h1>Удалить продукт из чека</h1>
    <form action="controller?command=delete_checkitem" method="post">
        <label for="delete_item">Введите имя или айди товара</label>
        <input type="text" name="delete_item" id="delete_item" required>
        <br>
        <input type="submit" name="delete" value="Удалить">
    </form><br><br>

    <form action="controller?command=delete_check" method="post">
        <input type="submit" name="close_check" value="Закрыть чек">
    </form>
    </div>
    <hr/>
</c:if>
<a href="controller?command=catalogue">Открыть каталог</a>

<h2>Check id ${check_id}</h2>
<table style="width:50%" class="styled-table">
    <thead>
    <tr>
        <td>Item ID</td>
        <td>Amount</td>
        <td>Weight</td>
        <td>Price</td>
<%--        <td>Amount Available</td>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list_items}" var="curr_item">
        <tr>
            <td>${curr_item.itemId}</td>
            <td>${curr_item.itemAmount}</td>
            <td>${curr_item.itemWeight}</td>
            <td>${curr_item.itemPrice}</td>
<%--            <td>${curr_item.amountAvailable}</td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="login.jsp">Change user</a>
</body>
<style>
    .form-style-6{
        font: 95% Arial, Helvetica, sans-serif;
        max-width: 400px;
        margin: 10px auto;
        padding: 16px;
        background: #F7F7F7;
    }
    .form-style-6 h1{
        background: #43D1AF;
        padding: 20px 0;
        font-size: 140%;
        font-weight: 300;
        text-align: center;
        color: #fff;
        margin: -16px -16px 16px -16px;
    }
    .form-style-6 input[type="text"],
    .form-style-6 input[type="date"],
    .form-style-6 input[type="datetime"],
    .form-style-6 input[type="email"],
    .form-style-6 input[type="number"],
    .form-style-6 input[type="search"],
    .form-style-6 input[type="time"],
    .form-style-6 input[type="url"],
    .form-style-6 textarea,
    .form-style-6 select
    {
        -webkit-transition: all 0.30s ease-in-out;
        -moz-transition: all 0.30s ease-in-out;
        -ms-transition: all 0.30s ease-in-out;
        -o-transition: all 0.30s ease-in-out;
        outline: none;
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        width: 100%;
        background: #fff;
        margin-bottom: 4%;
        border: 1px solid #ccc;
        padding: 3%;
        color: #555;
        font: 95% Arial, Helvetica, sans-serif;
    }
    .form-style-6 input[type="text"]:focus,
    .form-style-6 input[type="date"]:focus,
    .form-style-6 input[type="datetime"]:focus,
    .form-style-6 input[type="email"]:focus,
    .form-style-6 input[type="number"]:focus,
    .form-style-6 input[type="search"]:focus,
    .form-style-6 input[type="time"]:focus,
    .form-style-6 input[type="url"]:focus,
    .form-style-6 textarea:focus,
    .form-style-6 select:focus
    {
        box-shadow: 0 0 5px #43D1AF;
        padding: 3%;
        border: 1px solid #43D1AF;
    }

    .form-style-6 input[type="submit"],
    .form-style-6 input[type="button"]{
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        width: 100%;
        padding: 3%;
        background: #43D1AF;
        border-bottom: 2px solid #30C29E;
        border-top-style: none;
        border-right-style: none;
        border-left-style: none;
        color: #fff;
    }
    .form-style-6 input[type="submit"]:hover,
    .form-style-6 input[type="button"]:hover{
        background: #2EBC99;
    }

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
