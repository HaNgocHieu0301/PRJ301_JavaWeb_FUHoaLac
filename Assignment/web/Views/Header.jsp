<%-- 
    Document   : Header
    Created on : Jun 19, 2022, 3:37:09 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FU - Hòa Lạc</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- CSS only -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/animate.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/owl.carousel.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/magnific-popup.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="/Assignment/Views/css/mainStyle.css">
    </head>

    <body>

        <!-- PRE LOADER -->
        <!--        <section class="preloader">
                    <div class="spinner">
                        <span class="spinner-rotate"></span>
                    </div>
                </section>-->

        <!-- MENU -->
        <section class="navbar navbar-fixed-top custom-navbar" role="navigation">
            <div class="container">

                <div class="navbar-header">
                    <a href="#" class="navbar-brand">FU - Hòa Lạc</a>
                </div>

                <!-- MENU LINKS -->
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-nav-first">
                        <li><a href="#" class="smoothScroll">Sự kiện</a></li>
                        <li class="nav-item dropdown" aria-labelledby="navbarDropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <span> Am Thuc <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">FOOD</a>
                                <a class="dropdown-item" href="#">DRINK</a>
                                <a class="dropdown-item" href="#">OTHERS</a>
                            </div>
                        </li>
                        <li><a href="#" class="smoothScroll">Bài đăng</a></li>

                        <c:if test="${acc.type_id == 0}">
                            <li><a href="<%=request.getContextPath()%>/LoadItems" class="smoothScroll">Product Manager</a></li>
                            <li><a href="<%=request.getContextPath()%>/User" class="smoothScroll">User Home</a></li>
                            </c:if>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${sessionScope.acc == null}">
                            <a href="#" class="section-btn">Đăng nhập</a>
                            <a href="#" class="section-btn">Đăng ký</a>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <span class="username"><b>${acc.username},</b></span>
                            <a href="<%=request.getContextPath()%>/Logout" class="section-btn">Logout</a>
                        </c:if>
                    </ul>
                </div>

            </div>


        </section>

        <script src="./Views/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="./Views/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
