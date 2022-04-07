<%-- 
    Document   : login
    Created on : Apr. 5, 2022, 3:32:06 p.m.
    Author     : Saksham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User management app</h1>
        <h2>Login</h2>
        <form action="login" method="post">
            email: <input type="text" name="email"><br>
            password: <input type="password" name="password"><br>
            <input type="submit" value="Sign in">
        </form>
        <a href="http://localhost:8080/lab6/forgot">Forgot Password?</a>
    </body>
</html>
