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
        <link rel="stylesheet" href="/Assignment/Views/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="/Assignment/Views/css/animate.css">
        <link rel="stylesheet" href="/Assignment/Views/css/owl.carousel.css">
        <link rel="stylesheet" href="/Assignment/Views/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="/Assignment/Views/css/magnific-popup.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="/Assignment/Views/css/testcss.css">
    </head>

    <body>
        <!-- MENU -->
        <section class="navbar navbar-fixed-top custom-navbar" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a href="User" class="navbar-brand">FU - Hòa Lạc</a>
                </div>

                <!-- MENU LINKS -->
                <!--                <div class="collapse navbar-collapse justify-content-end">
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
                                                <a class="dropdown-item" href="User?type=Food">FOOD</a>
                                                <a class="dropdown-item" href="User?type=Drink">DRINK</a>
                                                <a class="dropdown-item" href="User?type=Others">OTHERS</a>
                                            </div>
                                        </li>
                                        <li><a href="#" class="smoothScroll">Bài đăng</a></li>
                                    </ul>
                                    Search
                                    <form class="navbar-form navbar-left" action="User" method="GET">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search" name="search">
                                        </div>
                                        <button type="submit" class="btn btn-default"><i class="fa-solid fa-cart-shopping"></i></button>
                                    </form>
                
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="Cart" class="smoothScroll"><i class="fa-solid fa-cart-shopping"></i></a></li>
                                        <li class="nav-item dropdown" aria-labelledby="navbarDropdown">
                                            <a
                                                class="nav-link dropdown-toggle"
                                                href="#"
                                                id="navbarDropdown"
                                                role="button"
                                                data-toggle="dropdown"
                                                aria-haspopup="true"
                                                aria-expanded="false">
                                                <span class="username"><b></b></span>
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                                <a class="dropdown-item" href="UpdateAccount">ACCOUNT</a>
                                                <a class="dropdown-item" href="<%=request.getContextPath()%>/OrderManagement">Order</a>
                                                <a class="dropdown-item" href="Logout">LOGOUT</a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </section>-->
                <!-- MENU LINKS -->
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-nav-first">
                        <li><a href="#home" class="smoothScroll">Home</a></li>
                        <li><a href="#about" class="smoothScroll">About</a></li>
                        <li><a href="#team" class="smoothScroll">Chef</a></li>
                        <li><a href="#menu" class="smoothScroll">Menu</a></li>
                        <li><a href="#contact" class="smoothScroll">Contact</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Call Now! <i class="fa fa-phone"></i> 010 020 0340</a></li>
                        <a href="#footer" class="section-btn">Reserve a table</a>
                    </ul>
                </div>

            </div>
        </section>

        <!-- MAIN TOPIC -->
        <section class="event">
            <img src="/Assignment/Views/images/seagame.jpg" alt="" class="event-img">
            <div class="caption">
                <a href="#" class="section-btn btn btn-default smoothScroll">Chi tiết</a>
            </div>
            <div class="arrow-down">
                <a href="#menu"><i class="fa-solid fa-chevron-down"></i></a>
            </div>
        </section>

        <script src="../Views/js/jquery.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="../Views/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="../Views/js/jquery.stellar.min.js"></script>
        <script src="../Views/js/wow.min.js"></script>
        <script src="../Views/js/owl.carousel.min.js"></script>
        <script src="../Views/js/jquery.magnific-popup.min.js"></script>
        <script src="../Views/js/smoothscroll.js"></script>
        <script src="../Views/js/custom.js"></script>
    </body>
</html>
