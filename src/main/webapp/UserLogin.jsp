<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
        }

        .login-box {
            width: 400px;
            margin: 100px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #00b894;
            border: none;
            color: white;
            border-radius: 5px;
            font-size: 16px;
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>User Login</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null && request.getMethod().equalsIgnoreCase("POST")) {
%>
    <p style="color: red;"><%= error %></p>
<%
    }
%>


<form action="LoginServlet" method="post">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form><br>
<a href="UserRegister.html">Don't have an account? Register here.</a>
</div>
</body>
</html>
