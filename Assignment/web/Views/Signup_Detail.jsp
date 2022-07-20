<%-- 
    Document   : Signup_Shop
    Created on : Jun 8, 2022, 9:53:40 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up For Shop</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="/Assignment/Views/css/signup.css">
    </head>
    <body>
        <div class="main">     
            <div class="container">
                <div class="sign-up-content">
                    <c:if test="${newAcc.type_id == 1}">
                        <h1>Đăng kí cho nhà bán</h1>
                    </c:if>
                    <c:if test="${newAcc.type_id == 2}">
                        <h1>Đăng kí cho người dùng bình thường</h1>
                    </c:if>
                    <form 
                        method="POST" 
                        class="signup-form" 
                        action="/Assignment/UpdateAccount">
                        <div class="form-textbox ">
                            <label for="fullname">Họ và tên: </label>
                            <input type="text" name="fullname" id="fullname" required/>
                        </div>
                        <div class="form-textbox ">
                            <label for="avatar">Avatar</label>
                            <!--<input type="file" name="avatar" id="avatar" required/>-->
                            <img
                                src=""
                                alt="Avatar"
                                class="tm-avatar img-fluid mb-4"
                                id="avatar"
                                />
                            <input 
                                type="file" 
                                class="btn btn-primary btn-block text-uppercase file-upload"
                                data-img="avatar" 
                                data-max-size="5242880" 
                                data-error-max-size="File không quá 5MB" 
                                data-max-width="256" 
                                data-max-height="256"
                                required
                                >   
                            <input type="hidden" name="avatar" value="">
                        </div>
                        <div class="form-textbox gender">
                            <label for="email">Giới tính: </label>
                            <input type="radio" name="gender" value="Female"/>
                            <label for="female">Nữ</label>
                            <input type="radio" name="gender" value="Male"/>
                            <label for="male">Nam</label>
                        </div>

                        <div class="form-textbox">
                            <label for="dob">Ngày tháng năm sinh: </label>
                            <input type="date" name="dob" id="dob" required/>
                        </div>

                        <div class="form-textbox ">
                            <label for="phonenumber">Số điện thoại: </label>
                            <input type="number" name="phoneNumber" id="phoneNumber" required/>
                        </div>
                        <c:if test="${newAcc.type_id == 1}">
                            <div class="form-textbox">
                                <label for="citizenId">Căn cước công dân:</label>
                                <input type="text" name="citizenID" id="citizenID" required/>
                            </div>
                            <div class="form-textbox">
                                <label for="citizenId">Tài khoan ngân hàng:</label>
                                <input type="number" name="credit" id="credit" required placeholder="Stk"/>
                                <input type="text" name="bank" required placeholder="Ngan hang"/>
                            </div>
                        </c:if>
                        <c:if test="${newAcc.type_id == 2}">
                            <div class="form-textbox">
                                <label for="job">Nghề nghiệp: </label>
                                <input type="text" name="job" id="job" required/>
                            </div>

                            <div class="form-textbox">
                                <label for="studentId">Mã số sinh viên: </label>
                                <input type="text" name="studentID" id="studentID" />
                            </div>
                        </c:if>
                        <div class="form-textbox">
                            <label for="address">Địa chỉ: </label>
                            <input type="text" name="address" id="address" required/>
                        </div>

                        <div class="form-textbox">
                            <input type="submit" name="submit" id="submit" class="submit" value="Create account" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="<%=request.getContextPath()%>/Views/js/FileUpLoad.js"></script>
    </body>
</html>
