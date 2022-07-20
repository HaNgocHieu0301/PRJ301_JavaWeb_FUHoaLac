<%-- 
    Document   : ProductDetail
    Created on : Jul 8, 2022, 12:28:15 AM
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
                <div class="back-to-shop"><a href="OrderManagement"><i class="fa-solid fa-arrow-left-long"></i> <span class="text-muted">Back to shop</span></a></div>
                <div class="col"><h4 class="title-header">Order detail</h4></div>
            </div> 
            <table>
                <thead>
                    <tr>
                        <th scope="col">Product Name</th>
                        <th scope="col">Tag</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="total" value="${0}"/>
                    <c:set var="itemQuantity" value="${0}"/>
                    <c:forEach var="OrderItem" items="${orderItemList}">
                        <c:set var="customerName" value="${OrderItem.order.username}"/>
                        <c:set var="address" value="${OrderItem.order.delivery_address}"/>
                        <c:set var="shipping" value="${OrderItem.order.delivery_transport}"/>
                        <c:set var="note" value="${OrderItem.order.order_note}"/>
                        <c:set var="total" value="${total + OrderItem.quantity * OrderItem.item.item_price}"/>
                        <c:set var="itemQuantity" value="${itemQuantity + OrderItem.quantity}"/>
                        <tr>
                            <td>${OrderItem.item.item_name}</td>
                            <td>${OrderItem.item.tag_name}</td>
                            <td>${OrderItem.quantity}</td> 
                            <td>${OrderItem.item.item_price}</td>
                            <td>${OrderItem.item.item_price * OrderItem.quantity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <hr>
            <p>Customer Name: ${customerName}</p>
            <p>Address: ${address}</p>
            <p>Shipping: ${shipping}</p>
            <p>Note: ${note}</p>
            <p>Total: ${total}$</p>
        </div>
    </body>
</html>