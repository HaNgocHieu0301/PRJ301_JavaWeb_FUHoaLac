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
        <title>Product Admin - Dashboard HTML Template</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="../css/bootstrap.min.2.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="../css/templatemo-style.css">
        <link rel="stylesheet" href="/Assignment/Views/css/myStyle.css">
    </head>

    <body id="reportsPage">
        <jsp:include page="../ManagerHeader.jsp" flush="true" />
        <div class="" id="home">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="text-black mt-5 mb-5">Welcome back, <b>Admin</b></p>
                    </div>
                </div>
                <!-- row -->
                <div class="row tm-content-row">
                    <div class="col-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                            <h2 class="tm-block-title">Orders List</h2>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ORDER NO.</th>
                                        <th scope="col">CUSTOMER NAME</th>
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
                                            <c:set var="total" value="${total + OrderItem.realPrice()}"/>
                                            <tr> 
                                                <td><a href="OrderDetail?order_id=${entry.key}" style="color: white">#<b>${entry.key}</b></a></td>
                                                <td><b>${OrderItem.order.username}</b></td>
                                                <td><b>${OrderItem.order.delivery_address}</b></td>
                                                <td><b>${OrderItem.order.delivery_transport}</b></td>
                                                <td><b>${OrderItem.order.order_note}</b></td>
                                                <td><b>${total}</b></td>
                                                <td>
                                                    <c:if test="${OrderItem.order.order_status == 'Processing'}">
                                                        <form method="POST" action="Payment">
                                                            <input hidden name="order_id" value="${entry.key}">
                                                            <button class="border-0" name="action" type="submit" value="Complete"><i class="fa-solid fa-check"></i></button>
                                                            <button class="border-0" name="action" type="submit" value="Cancel"><i class="fa-solid fa-xmark"></i></button>
                                                        </form>
                                                        <!--<a href="#" class="text-white button"><i class="fa-solid fa-check"></i></a>-->
                                                        <!--<a href="#" class="text-white button"><i class="fa-solid fa-xmark"></i></a>-->
                                                    </c:if>
                                                    <c:if test="${OrderItem.order.order_status == 'Complete'}">
                                                        <b>Complete</b>

                                                    </c:if>
                                                    <c:if test="${OrderItem.order.order_status == 'Cancel'}">
                                                        <b>Cancel</b>

                                                    </c:if>
                                                </td>
                                            </tr>       
                                        </c:forEach>                                            
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4 tm-block-col">
                        <div class="circle" style="text-align: center">
                            <h2 class="">Tỉ lệ hoàn thành</h2>
                            <h4>(đơn hoàn thành/tổng số đơn)</h4>
                            <h2 class="">${Complete}/${All}</h2>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4 tm-block-col">
                        <div class="circle" style="text-align: center">
                            <h2 class="">Tong Doanh Thu</h2>
                            <p class="">${totalAll} vnđ</p>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4 tm-block-col">
                        <div class="circle" style="text-align: center">
                            <h2 class="">Tỉ lệ hủy</h2>
                            <h4>(đơn hoàn thành/tổng số đơn)</h4>
                            <h2 class="">${Cancel}/${All}</h2>
                        </div>
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
        <script src="../js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="../js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="../js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="../js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="js/tooplate-scripts.js"></script>
        <script>
        </script>
    </body>

</html>
