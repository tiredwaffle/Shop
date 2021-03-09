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
<div class="form-style-6">
<h1>Add item</h1>
<form action="controller?command=submit_item" method="post">
    <label for="item_name">Enter name</label>
    <input type="text" name="item_name" id="item_name" required>
    <br><br>
    <label for="item_amount">Enter amount available</label>
    <input type="number" name="item_amount" id="item_amount" required>
    <br><br>
    <label for="item_weight">Enter weight</label>
    <input type="number" name="item_weight" id="item_weight" required>
    <br><br>
    <label for="item_price">Enter price</label>
    <input type="number" name="item_price" id="item_price" required>
    <br><br>
    <input type="submit" name="add_item" value="Add item">
</form></div>
<hr/><br><br>
<div class="form-style-6">
<h1>Удалить товар</h1>
<form action="controller?command=delete_item" method="post">
    <label for="item_name">Enter ID</label>
    <input type="number" name="item_id" id="item_id" required>
    <br><br>
    <input type="submit" name="delete_item" value="Delete item">
</form></div>
<hr/><br><br>

<h2>Items:</h2>
<table style="width:100%" class="styled-table" >
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
