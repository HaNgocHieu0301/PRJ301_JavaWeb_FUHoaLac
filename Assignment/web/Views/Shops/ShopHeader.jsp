<%-- 
    Document   : ShopHeader
    Created on : Jun 22, 2022, 9:32:39 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700"/>
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="./Views/css/bootstrap.min.2.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="./Views/css/templatemo-style.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100 fixed-top">
                <a class="navbar-brand" href="index.html">
                    <h1 class="tm-site-title mb-0">Product Management</h1>
                </a>
                <button
                    class="navbar-toggler ml-auto mr-0"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <i class="fas fa-bars tm-nav-icon"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">
                                <i class="fas fa-tachometer-alt"></i> Dashboard
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span> Reports <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Daily Report</a>
                                <a class="dropdown-item" href="#">Weekly Report</a>
                                <a class="dropdown-item" href="#">Yearly Report</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="LoadItems">
                                <i class="fas fa-shopping-cart"></i> Products
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ModifyInfo">
                                <i class="far fa-user"></i> Accounts
                            </a>
                        </li>
                    </ul>

                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link d-block" href="Logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <script src="../js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="../js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
            $(function () {
                $(".tm-product-name").on("click", function () {
                    window.location.href = "edit-product.html";
                });
            });
        </script>
    </body>
</html>
