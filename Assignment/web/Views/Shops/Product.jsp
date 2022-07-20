<%-- 
    Document   : Items
    Created on : Jun 22, 2022, 9:30:58 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Product Page</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="./css/bootstrap.min.2.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="./css/templatemo-style.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Views/css/myStyle.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
    </head>

    <body id="reportsPage">
        <jsp:include page="../ManagerHeader.jsp" flush="true" />
        <% 
            HashMap<Integer, String> tag_hs = (HashMap<Integer, String>) request.getAttribute("tag_list");
        %>

        <div class="container mt-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>
                                    <tr>
                                        <th scope="col">PRODUCT NAME</th>
                                        <th scope="col">PRICE</th>
                                        <th scope="col">IN STOCK</th>
                                        <th scope="col">DESC</th>
                                        <th scope="col">TAG</th>
                                        <th scope="col">DISCOUNT</th>
                                        <th scope="col" colspan="2" style="text-align: center">MODIFY</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${item_list}" var="item">
                                        <c:if test="${item.item_id == updatedItem_id}">
                                            <c:set var="updatedItem" scope="session" value="${item}"/>
                                        <p>${updatedItem.item_id}</p>
                                    </c:if>
                                    <tr>
                                        <td class="tm-product-name">${item.item_name}</td>
                                        <td>${item.item_price}</td>
                                        <td>${item.item_quantity}</td>
                                        <td>${item.item_description}</td>
                                        <td>${item.tag_name}</td>
                                        <td>${item.discount}</td>
                                        <td>
                                            <a href="ModifyItem?type=1&item_id=${item.item_id}" class="tm-product-delete-link">
                                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="ModifyItem?type=0&item_id=${item.item_id}" class="tm-product-delete-link">
                                                <i class="fa-solid fa-pen-to-square tm-product-delete-icon"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>           
                                </tbody>
                            </table>
                        </div>
                        <h2 style="text-align: center; color: yellow">${mess}</h2>  
                        <!-- table container -->
                        <a 
                            href="ModifyItem"
                            class="btn btn-primary btn-block text-uppercase mb-3">
                            Add new product
                        </a>
                    </div>
                </div>

                <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                        <h2 class="tm-block-title">Payment Categories</h2>
                        <form method="POST" action="ModifyPayment">
                            <div class="tm-product-table-container">
                                <table class="table tm-table-small tm-product-table">
                                    <c:forEach items="${paymentList}" var="payment">
                                        <tr>
                                            <td class="tm-product-name">${payment.payment_name}<br/>${payment.payment_note}</td>
                                            <td class="text-center">
<!--                                                <button name="action" value="update" class="tm-product-delete-link border-0">
                                                    <i class="fa-solid fa-pen-to-square tm-product-delete-icon"></i>
                                                </button>-->
                                            </td>
                                        </tr>
                                        <input name="payment_id" value="${payment.payment_id}" hidden>
                                        <input name="payment_username" value="${payment.username}" hidden>
                                        <input name="payment_username" value="${payment.payment_note}" hidden>
                                    </c:forEach>    
                                </table>                 
                            </div>
                        </form >
<!--                        <form method="POST" action="ModifyPayment">
                             table container 
                            <div class="form-group mb-3">
                                <label for="category">Edit Payment</label>
                                <input
                                    id="payment"
                                    name="_name"
                                    type="text"
                                    class="form-control validate"
                                    value="${payment_content}"
                                    />
                            </div>
                            <button name="action" value="finishUpdate" class="btn btn-primary btn-block text-uppercase mb-3">
                                Sumbit
                            </button>
                        </form>-->
                    </div>  
                </div>
            </div>
        </div>
        <footer id="footer" data-stellar-background-ratio="0.5">
            <div class="row">

                <div class="col-md-6 col-sm-8">
                    <div class="wow fadeInUp col-md-6 col-sm-12" data-wow-delay="0.4s">

                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.478772423653!2d105.52368956411134!3d21.01352079367613!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345bc25f79bf41%3A0x9f6dfcc546fdecfe!2zS20yOSDEkMaw4budbmcgQ2FvIFThu5FjIDA4LCBUaOG6oWNoIEhvw6AsIFRo4bqhY2ggVGjhuqV0LCBIw6AgTuG7mWkgMTAwMDAsIFZpZXRuYW0!5e0!3m2!1sen!2sth!4v1657434905395!5m2!1sen!2sth" width="350px" height="200px"style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>  
                </div>

                <div class="col-md-4 col-sm-8">
                    <div class="footer-info footer-open-hour">
                        <div class="section-title">
                            <h3 class="" data-wow-delay="0.2s">Thông Tin Dự Án</h3>
                        </div>
                        <div class="section-content" data-wow-delay="0.4s">
                            <div>
                                <h4>Trường ĐH FPT Hà Nội</h4>
                                <h4>Môn học PRJ301</h4>
                            </div>
                            <div>
                                <p>Địa chỉ: KM29 Đường Cao Tốc, Thạch Hòa, thạch Thất, Hà Nội, Việt Nam</p>
                                <p>SÐT: 0123456789</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-2 col-sm-4">
                    <ul class="social-icon">
                        <li><a href="https:www.facebook.com"><i class="fa-brands fa-facebook"></i></a></li>
                        <li><a href="https:www.facebook.com"><i class="fa-brands fa-facebook"></i></a></li>
                        <li><a href="https:www.facebook.com"><i class="fa-brands fa-facebook"></i></a></li>
                    </ul>

                    <div class="copyright-text" data-wow-delay="0.8s"> 
                        <p><br>Copyright &copy; 2022 <br>
                            Design: HieuHN0301</p>
                    </div>
                </div>

            </div>
        </footer> 
        <script src="/Assignment/Views/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="/Assignment/Views/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <!--        <script>
                    $(function () {
                        $(".tm-product-name").on("click", function () {
                            window.location.href = "edit-product.html";
                        });
                    });
                </script>-->
    </body>
</html>
