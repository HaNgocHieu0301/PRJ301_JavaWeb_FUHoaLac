<%-- 
    Document   : Cart
    Created on : Jun 28, 2022, 10:53:29 AM
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="/Assignment/Views/css/cart.css">
    </head>
    <body>
        <div class="card cart">

            <div class="title">
                <div class="back-to-shop"><a href="/Assignment/User"><i class="fa-solid fa-arrow-left-long"></i> <span class="text-muted">Back to shop</span></a></div>
                <div class="col"><h4 class="title-header">Shopping Cart</h4></div>
                <c:if test="${empty orderItemHM}"> 
                    <h3 style="color: red">Gio Hang Trong</h3>
                </c:if>
            </div> 

            <c:forEach var="entry" items="${orderItemHM}">
                <div class="row">
                    <div class="col-md-8">
                        <div class="title">
                            <div class="row">
                                <div class="col"><h4><b>Shop: ${entry.key}</b></h4></div>
                                <div class="col align-self-center text-right text-muted">${fn:length(entry.value)} items</div>
                            </div>
                        </div> 
                        <c:set var="total" value="${0}"/>
                        <c:set var="itemQuantity" value="${0}"/>

                        <c:forEach var="OrderItem" items="${entry.value}">
                            <c:set var="total" value="${total + OrderItem.realPrice()}"/>
                            <c:set var="itemQuantity" value="${itemQuantity + OrderItem.quantity}"/>
                            <div class="row border-top border-bottom">
                                <div class="row main align-items-center">
                                    <div class="col-2"><img class="img-fluid" src="${OrderItem.item.item_img}"></div>
                                    <div class="col">
                                        <div class="row text-muted">${OrderItem.item.tag_name}</div>
                                        <div class="row">${OrderItem.item.item_name}</div>
                                    </div>
                                    <div class="col">
                                        <form action="" method="GET" onchange="this.submit()">
                                            <input name="order_id" value="${OrderItem.order.order_id}" hidden="">
                                            <input name="item_id" value="${OrderItem.item.item_id}" hidden="">

                                            <button class="changeQty border-0 bg-transparent" onclick="this.parentNode.numberInput.value--">
                                                <i class="fa-solid fa-minus"></i>
                                            </button>

                                            <input type="number" name="qty" class="changeQtyx" value="${OrderItem.quantity}" id="numberInput">

                                            <button class="changeQty border-0 bg-transparent" onclick="this.parentNode.numberInput.value++">
                                                <i class="fa-solid fa-plus"></i>
                                            </button>
                                        </form>
                                    </div>
                                    <div class="col">$ ${OrderItem.realPrice()} 
                                        <a href="Cart?action=del&order_id=${OrderItem.order.order_id}&item_id=${OrderItem.item.item_id}" class="close">&#10005;</a>
                                    </div> 
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-md-4 summary">
                        <form action="Payment" method="GET">
                            <div><h5><b>Summary</b></h5></div>
                            <hr>
                            <div class="row">
                                <div class="col" style="padding-left:8px;">ITEMS </div>
                                <div class="col text-right">${itemQuantity}</div>
                            </div>
                            <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                                <div class="col">TOTAL PRICE</div>
                                <div class="col text-right">&euro; ${total}</div>
                            </div>
                            <input type="text" name="shopName" value="${entry.key}" hidden>
                            <button class="btn" type="submit">CHECKOUT</button>
                        </form>
                    </div>
                </div>
                <br>
            </c:forEach>
        </div>
        <script>
            var x = document.getElementById("changeQty");
            x.addEventListener("change", function () {
                
            })
        </script>
    </body>
</html>
