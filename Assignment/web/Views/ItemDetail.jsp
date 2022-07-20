<%-- 
    Document   : ItemDetail
    Created on : Jun 28, 2022, 10:00:33 AM
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
        <!-- CSS only -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/animate.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/owl.carousel.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/magnific-popup.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/mainStyle.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/myStyle.css">
    </head>
    <body style="background-color: #ddd">
        <jsp:include page="./Users/UserHeader_NotSlider.jsp" flush="true" />
        <div class="container">
            <div class="row item-detail">
                <div class="col-md-6 tm-gallery-item">
                    <img 
                        src="${item.item_img}" 
                        class="img-responsive img-rounded" 
                        alt=""
                        width="100%">
                </div>        
                <div class="col-md-6 tm-gallery-item">
                    <div class="menu-item">
                        <h2>THÔNG TIN CHI TIẾT</h2>
                        <div class="menu-item-info">
                            <h3>${item.item_name}</h3>
                            <!-- <p><span class="item-tag">Đồ ăn vặt</span></p> -->
                            <p>${item.tag_name}</p>
                            <h3>${item.item_price}$</h3>
                            <p style="word-wrap: break-word">${item.item_description}</p>
                        </div>
                    </div> 
                    <form method="GET" action="Cart">
                        <input type="text" name="item_id" value="${item.item_id}" hidden>
                        <!--                        <div class="menu-buy">
                                                    <button type="submit" class="section-btn btn btn-default smoothScroll">Thêm vào giỏ hàng</button>
                                                </div>-->
                        <c:choose>
                            <c:when test="${acc.type_id == 2 || item.username != acc.username}">
                                <div class="menu-buy">
                                    <button type="submit" class="section-btn btn btn-default smoothScroll">Thêm vào giỏ hàng</button>
                                </div>                                                    
                            </c:when>
                            <c:otherwise>
                                <div class="menu-buy">
                                    <a href="ModifyItem?type=0&item_id=${item.item_id}" class="section-btn btn btn-default smoothScroll">Edit san pham</a>
                                </div> 
                            </c:otherwise>
                        </c:choose>
                    </form>
                </div>
            </div>
            <div class="row shop">
                <img 
                    src="<%=request.getContextPath()%>/Views/images/avatar/3.jpg" 
                    alt="avatar"
                    class="col-md-2 img-responsive img-circle avatar"/>
                <div class="col-md-9">
                    <div class="shop-intro fit-content">
                        <span class="shop_name"><b>${item.username}</b></span> 
                        <div class="shop_detail">
                            <button type="submit" class="btn btn-default">Xem Shop</button>
                            <button type="submit" class="btn btn-default">Nhan Tin</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row review">
                <h2 class="review-title">Đánh giá sản phẩm</h2>
                <h4>Bình luận:</h4>
                <form method="POST" action="ModifyCmt" class="">
                    <div class="row new-cmt">
                        <img 
                            src="${userinfo.avatar}" 
                            alt=""
                            class="col-xs-1 img-responsive img-circle avatar-cmt"/>
                        <textarea class="" name="content">${updatedCmt_content}</textarea>
                        <input name="item_id" value="${item.item_id}" hidden>
                        <input name="cmt_id" value="${updatedCmt_id}" hidden>
                        <button type="submit" name="action" value="insert" class="send"><i class="fa-solid fa-paper-plane"></i></button>   
                    </div>
                </form>
                <c:if test="${fn:length(cmt_list) > 0}">
                    <c:forEach items="${cmt_list}" var="cmt"
                               begin="${CP.begin}" end="${CP.end}">
                        <hr/>
                        <div class="row comment">
                            <img 
                                src="${cmt.username.avatar}" 
                                alt=""
                                class="col-xs-1 img-responsive img-circle avatar-cmt"/>  
                            <div class="cmt-info col-xs-9">
                                <div class="cmt-info-detail">
                                    <p class="cmt-info-username">${cmt.username.name}</p>
                                    <div class="cmt-datetime">
                                        <span class="datetime">${cmt.comment_date}</span>&nbsp;&nbsp;<span class="datetime">${cmt.comment_time}</span>
                                    </div>
                                </div>
                                <p class="cmt-content" >${cmt.comment_content}</p>
                            </div>
                            <c:if test="${acc.userinfo_id == cmt.username.userinfo_id or acc.type_id == 0}">
                                <div class="cmt-btn col-xs-1">
                                    <form action="ModifyCmt" method="POST">
                                        <button type="submit" class="" name="action" value="update" onclick="changeCmt()"><i class="fa-solid fa-pen-to-square"></i></button>
                                        <button type="submit" class="" name="action" value="delete" onclick="changeCmt()"><i class="fa-solid fa-trash-can"></i></button>
                                        <input type="hidden" name="content" value="${cmt.comment_content}">
                                        <input type="hidden" name="cmt_id" value="${cmt.comment_id}">
                                        <input name="item_id" value="${item.item_id}" hidden>
                                    </form>
                                    <!--<button type="submit" class="" name="action" value="delete"><i class="fa-solid fa-trash-can"></i></button>-->
<!--                                    <a href="ModifyCmt?action=0&id=${item.item_id}&cmt_id=${cmt.comment_id}"><i class="fa-solid fa-pen-to-square"></i></a>
                                    &nbsp;&nbsp;
                                    <a href="ModifyCmt?action=1&id=${item.item_id}&cmt_id=${cmt.comment_id}"><i class="fa-solid fa-trash-can"></i></a>-->
                                </div>    
                            </c:if>
                        </div>
                    </c:forEach>

                    <form action="ItemDetail" method="post" class="pagging">
                        <c:if test="${CP.cp != 0}">
                            <span><input type="submit" name='home' value='Home'></span>
                            <span><input type="submit" name='pre' value='Pre'></span>

                        </c:if>

                        <c:forEach begin="${0}" end="${CP.tp-1}" var="i">
                            <span><input type="submit" name="btn${i}" value="${i+1}"></span>

                        </c:forEach>
                        <input type='text' hidden name='cp' value='${CP.cp}'>
                        <c:if test="${CP.cp != CP.tp - 1}">
                            <span><input type="submit" name="next" value="Next"></span>
                            <span><input type="submit" name="end" value="End"></span>

                        </c:if>
                    </form>  
                </c:if>
            </div>
        </div>
        <script>
            function changeCmt() {
                var content = document.getElementById("${cmt}")
            }
        </script>
    </body>
</html>
