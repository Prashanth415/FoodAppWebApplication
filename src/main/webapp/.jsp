<%@ page language="java" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("UserLogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Items</title>
</head>
<body>
    <h2>Welcome, <%= username %>! Browse your order items below.</h2>
    <!-- Add your item cards here -->
</body>
</html>
