<%-- 
    Document   : Payment
    Created on : Jul 5, 2022, 10:03:34 PM
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="/Assignment/Views/css/cart.css">
    </head>
    <body>
        <div class="card cart">
            <div class="title">
                <div class="back-to-shop"><a href="<%=request.getContextPath()%>/Cart">&leftarrow; <span class="text-muted">Back to shop</span></a></div>
                <c:if test="${empty orderItemList}"> 
                    <h3>Gio Hang Trong</h3>
                </c:if>
                <div><h4 class="title-header">Payment</h4></div>
            </div> 
            <div class="row">
                <div class="col-md-12"> 
                    <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2"><span>Image</span></div>
                            <div class="col">
                                <div class="row"><span>Name</span></div>
                            </div>
                            <div class="col">
                                <span>Quantity</span>
                            </div>
                            <div class="col">Price</div> 
                        </div>
                    </div>
                    <c:forEach var="OrderItem" items="${orderItemList}">
                        <c:set var="total" value="${total + OrderItem.item.item_price / 100 * (100-OrderItem.item.discount)}"/>
                        <c:set var="itemQuantity" value="${itemQuantity + OrderItem.quantity}"/>
                        <div class="row border-top border-bottom">
                            <div class="row main align-items-center">
                                <div class="col-2"><img class="img-fluid" src="${OrderItem.item.item_img}"></div>
                                <div class="col">
                                    <div class="row">${OrderItem.item.item_name}</div>
                                    <div class="row text-muted">${OrderItem.item.tag_name}</div>
                                </div>
                                <div class="col">
                                    <span>${OrderItem.quantity}</span>
                                </div>
                                <div class="col">$ ${OrderItem.realPrice()}</div> 
                            </div>
                        </div>
                        <c:set var="order_id" value="${OrderItem.order.order_id}"/>
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 summary">
                    <form action="<%=request.getContextPath()%>/Payment" method="POST">
                        <p>Ten khach hang: <i style="font-size: 16px;">${userinfo.name}</i></p>
                        <input name="order_id" value="${order_id}" hidden>
                        <p>Phuong thuc van chuyen</p>
                        <select name="shipping">
                            <option class="text-muted" value="Tu den lay">Tu den lay</option>
                            <option class="text-muted" value="Ship tan noi">Ship tan noi</option>
                        </select>
                        <p>Phuong thuc thanh toan</p>
                        <select name="payment">
                            <c:forEach items="${paymentList}" var="payment">
                                <option class="text-muted" value="${payment.payment_id}">${payment.payment_name}</option>
                            </c:forEach>
                        </select>
                        <c:forEach items="${paymentList}" var="payment">
                            <c:if test="${payment.payment_id == 1}">
                                <p>Banking: ${payment.payment_note}</p>
                            </c:if>
                        </c:forEach>
                        <p>Address</p>
                        <input type="text" name="address" placeholder="Enter your address" required="">
                        <p>Note</p>
                        <textarea rows="5" name="note" style="width: 100%"></textarea>
                        <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                            <div class="col">TOTAL PRICE</div>
                            <div class="col text-right">$ ${total}</div>
                        </div>
                        <button class="btn" type="submit">Payment</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
