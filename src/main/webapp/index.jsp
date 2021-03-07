<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rest</title>
</head>
<body>
<h1><%= "Welcome!" %></h1>
<br/>
<%
    Boolean status = (Boolean)session.getAttribute("login");
    if (status == null){
        session.setAttribute("login", Boolean.FALSE);
    }
    else if (status == Boolean.TRUE) {
        response.sendRedirect("home.jsp");
    }
%>

<a href="login.jsp">Log in</a>
<br>
<a href="${pageContext.request.contextPath}/controller?command=catalogue">Catalogue</a>
</body>
</html>