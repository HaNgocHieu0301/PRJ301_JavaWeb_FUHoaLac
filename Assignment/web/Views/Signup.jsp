<%-- 
    Document   : Signup
    Created on : Jun 8, 2022, 8:37:19 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/Assignment/Views/css/signup.css">
    </head>
    <body>
        <div class="main">
            <div class="container">
                <div class="sign-up-content">
                    <h1>Đăng kí: </h1>
                    <form 
                        class="signup-form"
                        id="signup-form"
                        method="POST"
                        action="CreateAccount">
                        <span class="alert-info" style="color: red" id="error">${message}</span>
                        <div class="form-textbox ">
                            <label for="name">Username</label>
                            <input 
                                type="text" 
                                name="username" 
                                id="username" 
                                required
                                minlength="6"/>
                        </div>

                        <div class="form-textbox">
                            <label for="email">Email</label>
                            <input 
                                type="email" 
                                name="email" 
                                id="email" 
                                required/>
                        </div>

                        <div class="form-textbox">
                            <label for="password">Password</label>
                            <input 
                                type="password" 
                                name="password" 
                                id="password" 
                                minlength="6"
                                pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.* ).{6,32}$"
                                title="Password must be at least 1 number, 1 special character, 1 upper, 1 normal"
                                required/>
                        </div>

                        <div class="form-textbox validate">
                            <label for="re-password">Re-Password</label>
                            <input 
                                type="password" 
                                name="re_password" 
                                id="re-password"
                                minlength="6"
                                pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.* ).{6,32}$"
                                required/>
                        </div>
                        <div class="form-textbox">
                            <label for="re-password">Loại tài khoản bạn đăng kí ?</label>
                            <input type="radio" name="type_id" value="2" id="user" checked="checked" />
                            <label for="user">Người dùng</label>
                            <input type="radio" name="type_id" value="1" id="shop" />
                            <label for="shop">Người bán</label>
                        </div>
                        <p class="checkValidation" id="checkValidation"></p>
                        <div class="form-group">
                            <input 
                                type="checkbox" 
                                name="agree-term" 
                                id="agree-term" 
                                class="agree-term" 
                                required/>
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-textbox">
                            <input type="submit" class="submit" value="Create account" onclick="return checkValid()"/>
                        </div>                        
                    </form>

                    <p class="loginhere">
                        Đã có tài khoản ?<a href="../Login" class="loginhere-link"> Đăng nhập</a>
                    </p>
                </div>
            </div>
        </div>

        <!-- JS -->
        <!--        
        <script src="vendor/jquery/jquery.min.js"></script>
                <script src="js/main.js"></script>
        -->
        <script src="../Views/js/validator.js"></script>
        <script>
            function checkValid() {
                var pass = document.getElementById('password').value;
                var repass = document.getElementById('re-password').value;
                if (pass !== repass) {
                    document.getElementById('error').innerHTML = "Please check again!";
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>
