<%-- 
    Document   : AdminHome
    Created on : Jun 16, 2022, 4:54:46 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- CSS only -->
        <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">-->
        <!-- MAIN CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/mainStyle.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/myStyle.css">
    </head>
    <body>
        <jsp:include page="../Header.jsp" flush="true" />
        <div class="container item-detail">
            <div class="row mgl-16">
                <h2>Poster:</h2>
                <div>
                    <form action="<%=request.getContextPath()%>/ModifyPost" method="POST">
                        <img 
                            src="${post.post_img}" 
                            alt="" 
                            class="img-fluid d-block mx-auto"
                            id="post_img"/>
                        <input 
                            type="file" 
                            class="mx-auto file-upload"
                            data-img="post_img" 
                            data-max-size="5242880" 
                            data-error-max-size="File không quá 5MB" 
                            data-max-width="512" 
                            data-max-height="512"
                            value=""
                            />
                        <input type="hidden" name="post_img" value=""> 
                        <input type="submit" class="btn btn-default center">
                    </form>
                </div>
            </div>
            <div class="row mgl-16">
                <h2>Tìm kiếm tài khoản</h2>
                <form method="GET" action="<%=request.getContextPath()%>/AccountControl">
                    <div class="">
                        <input type="text" class="width-90" placeholder="Search" name="username">
                        <button type="submit" class="btn btn-default"><i class="fa-solid fa-magnifying-glass"></i></button>    
                    </div>  
                </form>
            </div>
            <div class="row mgl-16 mgr-16">
                <div class="col-xs-3">
                    Username
                </div>
                <div class="col-xs-3">
                    Email
                </div>
                <div class="col-xs-3">
                    Trang thai
                </div>
                <div class="col-xs-3">
                    Hanh Dong
                </div>
            </div>
            <hr/>
            <form action="AccountControl" method="POST">
                <div class="row mgl-16 mgr-16">
                    <div class="col-xs-12 text-danger">${mess}</div>
                    <c:if test="${not empty searchAcc}">
                        <!--<td>${searchAcc.username}</td>-->
                        <div class="col-xs-3">
                            ${searchAcc.username}
                        </div>
                        <div class="col-xs-3">
                            ${searchAcc.email}
                        </div>
                        <!--<td>${searchAcc.email}</td>-->
                        <c:if test="${searchAcc.status == true}">
                            <div class="col-xs-3">
                                Hoạt động
                            </div>
                        </c:if>
                        <c:if test="${searchAcc.status == false}">
                            <div class="col-xs-3">
                                Không Hoạt động
                            </div>
                        </c:if>
                        <div class="col-xs-3">
                            <button id="lock" name="action" value="lock">
                                <i class="fa-solid fa-lock"></i>
                            </button>
                            <button id="unlock" name="action" value="unlock">
                                <i class="fa-solid fa-unlock-keyhole"></i>
                            </button>
                        </div>
                    </c:if>
                    <input name="username" value="${searchAcc.username}" hidden="">
                </div>                        
            </form>
        </div>

        <c:if test="${not empty searchAcc}">
            <form method="POST" action="AccountControl" id="lockAccForm">
                <input name="username" value="${searchAcc.username}" type="hidden">
                <input name="username" value="" type="hidden">
            </form>
        </c:if>
        <form id="processAccount" action="AccountControl">
            <input name="id" value="" hidden="">
            <input name="action" value="" hidden="">
        </form>
        <jsp:include page="../ManagerFooter.jsp" flush="true" />
    </body>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/Views/js/FileUpLoad.js"></script>
</html>
