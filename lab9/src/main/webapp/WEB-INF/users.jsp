<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class =" container">
            <div class="row">
                <div class="col" >
                    <h1><center>User Management System</center></h1>
                          <h3>List of Users</h3>
                    <table class="table">
            <thead>
                <tr>
                    <th>E-mail</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Active</th>
                   
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.active ? "Y" : "N"}</td>
                        <td><form action="user" method="post">
                                <input type="hidden" name="email" id="email" value=${user.email}>     
                                <button type="submit" name="delete">Delete</button>
                            </form>
                    </tr>   
                </c:forEach>
            </tbody>
        </table>
                               
            <h3> Add a User</h3>
            <form action="user" method="post">
                <p>Email: <input type="text" name="email" id="email"></p>
                <p>First Name: <input type="text" name="firstName" id="firstName"></p>
                <p>Last Name: <input type="text" name="lastName" id="lastName"></p>
                <p>Password: <input type="password" name="password" id="password"></p>
                <p>Role: <input type="text" name="role" id="role" ></p>                
            <button type="submit" name="add">Add</button>
            </form>
                          
            <br><h3>Update existing User</h3>
            <p>Note: Email address can not be updated.</p>
              <form action="user" method="post">  
                <p>Email: <input type="text" name="email" id="email"></p>  
                <p>First Name: <input type="text" name="firstName" id="firstName"></p>
                <p>Last Name: <input type="text" name="lastName" id="lastName"></p>
                <p>Password: <input type="password" name="password" id="password"></p>
                <p>Role: <input type="text" name="role" id="role" ></p>                
            <button type="submit" name="update">Update</button>
        </form>             
                         
          </div>
        </div>
      </div>           
        
    </body>
</html>
