<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <title>FU - Hòa Lạc</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- CSS only -->
        <link rel="stylesheet" href="/Assignment/Views/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="/Assignment/Views/css/animate.css">
        <link rel="stylesheet" href="/Assignment/Views/css/owl.carousel.css">
        <link rel="stylesheet" href="/Assignment/Views/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="/Assignment/Views/css/magnific-popup.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="/Assignment/Views/css/mainStyle.css">

    </head>

    <body>
        <jsp:include page="UserHeader.jsp" flush="true" />

        <!-- MENU-->
        <section id="menu" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                            <h2>Buying</h2>
                            <h4>Bán mọi thứ bán cần</h4>
                        </div>
                    </div>

                    <!-- Gallery -->
                    <div class="tm-gallery">
                        <!-- gallery page 1 -->
                        <div id="tm-gallery-page-food" class="tm-gallery-page ">
                            <c:if test="${fn:length(item_list) == 0}">
                                <h3>Empty</h3>
                            </c:if>
                            <c:if test="${fn:length(item_list) > 0}">
                                <c:forEach items="${item_list}" var="item" 
                                           begin="${CP.begin}" end="${CP.end}">
                                    <form action="Cart" method="GET">
                                        <article class="col-md-4 col-sm-6 tm-gallery-item">
                                            <div class="menu-thumb">
                                                <!--display infor about item-->
                                                <a href="ItemDetail?id=${item.item_id}" class="menu-info">
                                                    <img src="${item.item_img}" class="img-responsive" alt="">     
                                                    <div class="menu-item">
                                                        <h3>${item.item_name}</h3>
                                                        <h5>${item.tag_name}</h5>
                                                        <c:if test="${item.discount > 0}">
                                                            <span><del>${item.item_price}$</del></span>
                                                            <h3>${item.item_price / 100 * (100-item.discount)}$</h3>
                                                        </c:if>
                                                        <c:if test="${item.discount <= 0}">
                                                            <h3>&nbsp;</h3>
                                                            <h3>${item.item_price}$</h3>
                                                        </c:if>
                                                    </div> 
                                                </a>

                                                <!--get data to Cart servlet-->
                                                <input type="text" name="item_id" value="${item.item_id}" hidden >

                                                <!--submit form-->
                                                <div class="menu-buy">
                                                    <button type="submit" class="section-btn btn btn-default smoothScroll">Thêm vào giỏ hàng</button>
                                                </div>                                                    
                                            </div>
                                        </article>  
                                    </form>                                
                                </c:forEach>                                                                  
                            </c:if>
                        </div>
                        <!-- gallery page 1 -->
                    </div>
                    <!-- Gallery -->
                </div>
                <!--row-->
            </div>
            <!--container-->

            <form action="User" method="post">
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
        </div>
    </div>
</section>
<!-- FOOTER -->
<jsp:include page="../ManagerFooter.jsp" flush="true" />
<!-- SCRIPTS -->
<script src="/Assignment/js/jquery.js"></script>
<script src="/Assignment/js/bootstrap.min.js"></script>
<script src="/Assignment/js/jquery.stellar.min.js"></script>
<script src="/Assignment/js/wow.min.js"></script>
<script src="/Assignment/js/owl.carousel.min.js"></script>
<script src="/Assignment/js/jquery.magnific-popup.min.js"></script>
<script src="/Assignment/js/smoothscroll.js"></script>
<script src="/Assignment/js/custom.js"></script>
<script>
    $(document).ready(function () {
        // Handle click on paging links
        $('.tm-paging-link').click(function (e) {
            e.preventDefault();

            var page = $(this).text().toLowerCase();
            $('.tm-gallery-page').addClass('hidden');
            $('#tm-gallery-page-' + page).removeClass('hidden');
            $('.tm-paging-link').removeClass('active');
            $(this).addClass("active");
        });
    });

    $(document).ready(function () {
        // Handle click on paging links
        $('.section-btn').hover(function (e) {
            e.preventDefault();
        });
    });
</script>
</body>

</html>
