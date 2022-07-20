<%-- 
    Document   : Login
    Created on : Jun 8, 2022, 9:53:48 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/signup.css">
    </head>
    <body>
        <div class="main">
            <div class="container">                    
                <form class="sign-up-content" method="POST" action="Login">
                    <h2>Login</h2>
                    <div class="form-textbox ">
                        <i class="fa-solid fa-user"></i>
                        <label for="name">Username</label>
                        <input 
                            type="text" 
                            name="username" 
                            id="username" 
                            value="${cookie.user.value}"/>
                    </div>

                    <div class="form-textbox ">
                        <i class="fa-solid fa-lock"></i>
                        <label for="name">Password</label>
                        <input 
                            type="password" 
                            name="password" 
                            id="password" 
                            value="${cookie.pass.value}"/>
                    </div>
                    <p style="color:red;">${message}</p>
                    <div class="form-group">
                        <input 
                            type="checkbox" 
                            name="remember" 
                            id="remember" 
                            class="remember" 
                            />
                        <label for="agree-term" class="label-agree-term">Ghi nhớ tên đăng nhập và mật khẩu</label>
                    </div>
                    <div class="text-right">
                        <a href="ChangePassword">Quên mật khẩu?</a>
                    </div>

                    <div class="form-textbox">
                        <input type="submit" name="login" class="submit" value="Login" />
                    </div>
                </form>

                <p class="loginhere">
                    <a href="CreateAccount" class="loginhere-link"> Đăng kí?</a>
                    hoặc đăng nhập với
                </p>

                <div class="center login_logo">
                    <a href="#" class="">
                        <i class="fa-brands fa-facebook"></i>
                    </a>

                    <a href="#" class="">
                        <i class="fa-brands fa-google"></i>
                    </a>
                </div>

            </div>
        </div>
    </body>
</html>
