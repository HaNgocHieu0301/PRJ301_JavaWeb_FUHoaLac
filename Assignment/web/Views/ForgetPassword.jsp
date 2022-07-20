<%-- 
    Document   : ForgetPassword
    Created on : Jul 7, 2022, 3:34:29 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>FU-Hoa Lac</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/signup.css">
    </head>
    <body>
        <div class="main">     
            <div class="container">
                <div class="sign-up-content"> 
                    <h1>Forget Password</h1>
                    <form method="POST" action="ChangePassword" class="signup-form">
                        <div class="form-textbox">
                            <label for="email">Please enter your email</label>
                            <input 
                                type="email" 
                                name="email" 
                                required/>
                        </div>
                        <span style="color: red">${message}</span>
                        <div class="form-textbox">
                            <input type="submit" name="verify" class="submit" value="Submit" />
                        </div> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
