<%-- 
    Document   : ShopHome
    Created on : Jun 16, 2022, 4:54:58 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title></title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.2.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/templatemo-style.css">
        <!--<link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/mainStyle.css">-->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/myStyle.css">
    </head>

    <body id="reportsPage">
        <jsp:include page="UserHeader_NotSlider.jsp" flush="true" />
        <div class="" id="home">
            <div class="container pushHeader">
                <!-- row -->
                <div class="row width-70">
                    <div class="col-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                            <h2 class="tm-block-title">Orders List</h2>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ORDER NO.</th>
                                        <!--<th scope="col">CUSTOMER NAME</th>-->
                                        <th scope="col">ADDRESS</th>
                                        <th scope="col">SHIPPING</th>
                                        <th scope="col">NOTE</th>
                                        <th scope="col">TOTAL</th>
                                        <th scope="col">STATUS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="entry" items="${orderitemHM}">
                                        <c:set var="total" value="${0}"/>
                                        <c:forEach var="OrderItem" items="${entry.value}">
                                            <c:set var="total" value="${total + OrderItem.quantity * OrderItem.item.item_price}"/>
                                            <tr> 
                                                <td><a href="OrderDetail?order_id=${entry.key}" style="color: white">#<b>${entry.key}</b></a></td>
                                                <!--<td><b>${OrderItem.order.username}</b></td>-->
                                                <td><b>${OrderItem.order.delivery_address}</b></td>
                                                <td><b>${OrderItem.order.delivery_transport}</b></td>
                                                <td><b>${OrderItem.order.order_note}</b></td>
                                                <td><b>${total}</b></td>
                                                <td><b>${OrderItem.order.order_status}</b></td>
                                            </tr>       
                                        </c:forEach>                                            
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../ManagerFooter.jsp" flush="true" />
        </div>

        <script src="../js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="../js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="../js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="../js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="js/tooplate-scripts.js"></script>
    </body>
</html>
