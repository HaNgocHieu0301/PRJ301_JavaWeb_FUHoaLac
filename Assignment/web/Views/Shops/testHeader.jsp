<%-- 
    Document   : testHeader
    Created on : Jul 4, 2022, 9:08:08 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700"/>
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="../css/bootstrap.min.2.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="../css/templatemo-style.css">
    </head>
    <body>
        <div class="" id="home">
            <nav class="navbar navbar-expand-xl">
                <div class="container h-100">
                    <a class="navbar-brand" href="index.html">
                        <h1 class="tm-site-title mb-0">Product Management</h1>
                    </a>
                    <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-bars tm-nav-icon"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mx-auto h-100">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    <i class="fas fa-tachometer-alt"></i> Dashboard
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item dropdown">

                                <a 
                                    class="nav-link dropdown-toggle" 
                                    href="#" id="navbarDropdown" 
                                    role="button" 
                                    data-toggle="dropdown" 
                                    aria-haspopup="true" 
                                    aria-expanded="false">
                                    <i class="far fa-file-alt"></i>
                                    <span>
                                        Reports <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Daily Report</a>
                                    <a class="dropdown-item" href="#">Weekly Report</a>
                                    <a class="dropdown-item" href="#">Yearly Report</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="products.html">
                                    <i class="fas fa-shopping-cart"></i> Products
                                </a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" href="accounts.html">
                                    <i class="far fa-user"></i> Accounts
                                </a>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link d-block" href="login.html">
                                    Admin, <b>Logout</b>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <script src="/Assignment/Views/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="/Assignment/Views/js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="/Assignment/Views/js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="/Assignment/Views/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
