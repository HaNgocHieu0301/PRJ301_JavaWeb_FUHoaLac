<%-- 
    Document   : Signup_Shop
    Created on : Jun 8, 2022, 9:53:40 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/Assignment/Views/css/signup.css">
    </head>
    <body>
        <div class="main">     
            <div class="container">
                <div class="sign-up-content">
                    <h1>Xác thực email</h1>
                    <form method="GET" action="/Assignment/UpdateAccount" class="signup-form">
                        <div class="form-textbox">
                            <label for="email">Nhập mã xác thực được gửi đến email của bạn!</label>
                            <input 
                                type="text" 
                                name="receivedCode" 
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
