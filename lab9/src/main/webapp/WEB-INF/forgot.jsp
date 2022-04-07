<%-- 
    Document   : forgot
    Created on : Apr. 5, 2022, 4:57:00 p.m.
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
       <h1>Forgot Password</h1>
        <p>Please enter your email address and we will send your credentials to your email.</p>
         <form action="forgot" method="post">
             Email: <input type="text" name="email"><br><br>
           <button type="submit" name="submit">submit</button>
        </form>
        ${message}
    </body>
</html>
