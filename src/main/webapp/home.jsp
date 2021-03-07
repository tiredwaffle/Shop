<%@ page import="com.edu.entities.Employee" %><%--
  Created by IntelliJ IDEA.
  User: yulyz
  Date: 3/3/2021
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rest</title>
    <script>
        function getEmployees(){
            const response = fetch("controller?action=insert&command=employees", {
                method: 'POST',
                header:{'Content-Type': 'application/json'},
                body: ''
            })
        }

        function logout() {
            const response = fetch("controller?action=insert&command=logout", {
                method: 'POST',
                header: {'Content-Type': 'application/json'},
                body: ''
            })
            localStorage.clear();
        }
    </script>
</head>
<body>
<a href="catalogue.jsp">Catalogue</a>
<br>
<a href="index.jsp" onclick="logout()">Log Out</a>
<%
    Employee employee = (Employee) request.getSession().getAttribute("user");
    if (employee.getLevel() > 0) {
%>
Yaahy
<%}%>
</body>
</html>
