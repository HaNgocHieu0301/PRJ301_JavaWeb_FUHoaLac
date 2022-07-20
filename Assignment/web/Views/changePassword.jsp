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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="/Assignment/Views/css/signup.css">
    </head>
    <body>
        <div class="main">
            <div class="container">
                <div class="sign-up-content">
                    <h1>Change Password</h1>
                    <form 
                        class="signup-form"
                        id="signup-form"
                        method="POST"
                        action="<%=request.getContextPath()%>/ChangePassword">
                        <span class="alert-info" style="color: red" id="error">${message}</span>
                        <c:if test="${empty forgetPassword}">
                            <div class="form-textbox">
                                <label for="oldPassword">Old Password</label>
                                <input 
                                    type="password" 
                                    name="oldPassword" 
                                    id="oldPassword" 
                                    title="Password must be at least 1 number, 1 special character, 1 upper, 1 normal"
                                    required/>
                            </div>
                        </c:if>
                        <div class="form-textbox">
                            <label for="newPassword">New Password</label>
                            <input 
                                type="password" 
                                name="newPassword" 
                                id="newPassword" 
                                minlength="6"
                                pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.* ).{6,32}$"
                                title="Password must be at least 1 number, 1 special character, 1 upper, 1 normal"
                                required/>
                        </div>

                        <div class="form-textbox">
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
                            <input type="submit" class="submit" value="Change Password" onclick="return checkValid()"/>
                        </div>                        
                    </form>
                </div>
            </div>
        </div>
        <script>
            function checkValid() {
                var pass = document.getElementById('newPassword').value;
                var repass = document.getElementById('re-password').value;
                if (pass !== repass) {
                    document.getElementById('error').innerHTML = "Mật khẩu phải giống nhau!";
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>
