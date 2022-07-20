<%-- 
    Document   : EditAccount
    Created on : Jun 23, 2022, 8:17:56 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Accounts - Product Admin Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/bootstrap.min.2.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/templatemo-style.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/myStyle.css">
    </head>

    <body id="reportsPage">
        <div class="" id="home">

            <form 
                action="<%=request.getContextPath()%>/UpdateAccount" 
                method="POST"
                class="tm-signup-form row" 
                >

                <div class="container mt-5">
                    <c:if test="${acc.type_id == 2}">
                        <h3><a href="<%=request.getContextPath()%>/User" style="margin: 16px;"><i class="fa-solid fa-arrow-left-long"></i> Return Home </a></h3>
                    </c:if>
                    <c:if test="${acc.type_id == 1}">
                        <h3><a href="<%=request.getContextPath()%>/LoadItems" style="margin: 16px;"><i class="fa-solid fa-arrow-left-long"></i> Return Home </a></h3>
                    </c:if>
                    <c:if test="${acc.type_id == 0}">
                        <h3><a href="<%=request.getContextPath()%>/Views/Admins/AdminHome.jsp" style="margin: 16px;"><i class="fa-solid fa-arrow-left-long"></i> Return Home </a></h3>
                    </c:if>
                    <!-- row -->
                    <!--<h1 style="text-align: center">Change Password</h1>-->  
                    <div class="row tm-content-row">
                        <div class="tm-block-col tm-col-avatar">
                            <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                                <h2 class="tm-block-title">Change Avatar</h2>
                                <div class="tm-avatar-container">
                                    <img
                                        src="${userinfo.avatar}"
                                        alt="Avatar"
                                        class="tm-avatar img-fluid mb-4"
                                        id="avatar"
                                        />
                                </div>
                                <div class="form-group col-lg-12">
                                    <!--<label for="name">Upload New Photo</label>-->
                                    <input 
                                        type="file" 
                                        class="btn btn-primary btn-block text-uppercase file-upload"
                                        data-img="avatar" 
                                        data-max-size="5242880" 
                                        data-error-max-size="File không quá 5MB" 
                                        data-max-width="256" 
                                        data-max-height="256"
                                        >   
                                    <input type="hidden" name="avatar" value="">
                                </div>
                            </div>
                        </div>
                        <div class="tm-block-col tm-col-account-settings">
                            <div class="tm-bg-primary-dark tm-block tm-block-settings">
                                <h2 class="tm-block-title">Account Settings</h2>
                                <div class="form-group col-md-12">
                                    <label class="tm-hide-sm">&nbsp;</label>
                                    <a
                                        href="/Assignment/Views/changePassword.jsp"
                                        class="btn btn-primary btn-block text-uppercase"
                                        style="color: #fff"
                                        >
                                        Change password
                                    </a>
                                </div>
                                <div class="form-group col-lg-12" style="color: black;">
                                    <label for="name">Username</label>
                                    <input
                                        name="username"
                                        type="text"
                                        class="form-control validate"
                                        value="${acc.username}"
                                        style="color:#000;"
                                        disabled
                                        />
                                </div>
                                <div class="form-group col-lg-12">
                                    <label for="email">Email</label>
                                    <input
                                        name="email"
                                        type="email"
                                        class="form-control validate"
                                        value="${acc.email}"
                                        style="color:#000;"
                                        disabled
                                        />
                                </div>
                                <div class="form-group col-lg-12">
                                    <label for="phone">Full name</label>
                                    <input
                                        name="fullname"
                                        type="tex"
                                        class="form-control validate"
                                        value="${userinfo.name}"
                                        />
                                </div>
                                <div class="form-group col-lg-12">
                                    <label for="phone">DOB</label>
                                    <input
                                        name="dob"
                                        type="date"
                                        class="form-control validate"
                                        value="${userinfo.dob}"
                                        />
                                </div>
                                <div class="form-group col-lg-12">
                                    <label for="">Gender</label>
                                    <br/>
                                    <c:choose>
                                        <c:when test="${userinfo.gender == 'Male'}">
                                            <span class="genderName">Male</span> 
                                            <input name="gender" type="radio" value="Male" checked/>
                                            <span class="genderName">Female</span>
                                            <input name="gender" type="radio" value="Female"/>
                                        </c:when>
                                        <c:when test="${userinfo.gender == 'Female'}">
                                            <span class="genderName">Male</span> 
                                            <input name="gender" type="radio" value="Male"/>
                                            <span class="genderName">Female</span>
                                            <input name="gender" type="radio" value="Female" checked/>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="genderName">Male</span> 
                                            <input name="gender" type="radio" value="Male"/>
                                            <span class="genderName">Female</span>
                                            <input name="gender" type="radio" value="Female"/>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <div class="form-group col-lg-12">
                                    <label for="phone">Address</label>
                                    <input
                                        name="address"
                                        type="tel"
                                        class="form-control validate"
                                        value="${userinfo.address}"
                                        />
                                </div>
                                <div class="form-group col-lg-12">
                                    <label for="phone">Phone</label>
                                    <input
                                        name="phone"
                                        type="tel"
                                        class="form-control validate"
                                        value="${userinfo.phoneNumber}"
                                        required=""
                                        />
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="tm-hide-sm">&nbsp;</label>
                                    <button
                                        type="submit"
                                        class="btn btn-primary btn-block text-uppercase"
                                        >
                                        Update Your Profile
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>                        
            <jsp:include page="ManagerFooter.jsp" flush="true" />
        </div>

        <script src="<%=request.getContextPath()%>/Views/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="<%=request.getContextPath()%>/Views/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="<%=request.getContextPath()%>/Views/js/FileUpLoad.js"></script>
    </body>
</html>
