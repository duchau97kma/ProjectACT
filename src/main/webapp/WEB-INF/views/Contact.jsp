<%--
  Created by IntelliJ IDEA.
  User: winter
  Date: 24/09/2019
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Travalers Winter</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,700,900|Display+Playfair:200,300,400,700">
    <link rel="stylesheet" href="AdminTemplate/fonts/icomoon/style.css">

    <link rel="stylesheet" href="AdminTemplate/css/bootstrap.min.css">
    <link rel="stylesheet" href="AdminTemplate/css/magnific-popup.css">
    <link rel="stylesheet" href="AdminTemplate/css/jquery-ui.css">
    <link rel="stylesheet" href="AdminTemplate/css/owl.carousel.min.css">
    <link rel="stylesheet" href="AdminTemplate/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="AdminTemplate/css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="AdminTemplate/fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>-->
    <link rel="stylesheet" href="AdminTemplate/css/aos.css">

    <link rel="stylesheet" href="AdminTemplate/css/style.css">

</head>
<body>

<div class="site-wrap">

    <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div>

    <header class="site-navbar py-1" role="banner">

        <div class="container">
            <div class="row align-items-center">

                <div class="col-6 col-xl-2">
                    <h1 class="mb-0"><a href="/" class="text-black h2 mb-0">Travelers</a></h1>
                </div>
                <div class="col-10 col-md-8 d-none d-xl-block ">
                    <nav class="site-navigation position-relative text-right text-lg-center" role="navigation">

                        <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">
                            <li class="active">
                                <a href="/">Trang chủ</a>
                            </li>
                            &nbsp;
                            <li class="has-children">
                                <a href="">Danh mục</a>
                                <ul class="dropdown">
                                    <c:forEach var="items" items="${cate}">
                                        <li><a href="category?id=${items.id_cate}">${items.nameCate}</a></li>
                                    </c:forEach>
                                </ul>

                            </li>
                            &nbsp;
                            <li><a href="/AllTour">Tour</a></li>
                            &nbsp;
                            <li><a href="/AllPlace">Địa điểm</a></li>
                            &nbsp;
                            <li><a href="/contact">Liên hệ</a></li>
                            &emsp;  &emsp;  &emsp;
                            <c:set var = "mem" scope = "session" value = "${account}"/>
                            <c:if test = "${mem != null}">
                                <li><i class="fa fa-user-circle-o" aria-hidden="true"></i></li>
                                <li class="has-children">
                                    <a href=""> Hello, ${account}</a>
                                    <ul class="dropdown">
                                        <li><a href="/HistoryOrder">Lịch sử đặt Tour</a></li>
                                        <li><a href="/logoutUser">Đăng xuất</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test = "${mem == null}">
                                <li><a href="/loginUser">Login</a>/<a href="/register"> Register</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>

                <div class="col-6 col-xl-2 text-right">
                    <div class="d-none d-xl-inline-block">
                        <ul class="site-menu js-clone-nav ml-auto list-unstyled d-flex text-right mb-0" data-class="social">
                            <li>
                                <a href="/cart" class="pl-0 pr-3 text-black"><span class="icon-cart-plus"></span></a>
                            </li>
                            <li>
                                <a href="#" class="pl-3 pr-3 text-black"><span class="icon-twitter"></span></a>
                            </li>
                            <li>
                                <a href="#" class="pl-3 pr-3 text-black"><span class="icon-facebook"></span></a>
                            </li>
                            <li>
                                <a href="#" class="pl-3 pr-3 text-black"><span class="icon-instagram"></span></a>
                            </li>

                        </ul>
                    </div>

                    <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

                </div>

            </div>
        </div>

    </header>
</div>
</div>

</header>


<div class="site-blocks-cover inner-page-cover" style="background-image: url(AdminTemplate/images/contact.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row align-items-center justify-content-center text-center">

            <div class="col-md-8" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white font-weight-light">Liên hệ với chúng tôi</h1>
                <div><a href="/">Home</a> <span class="mx-2 text-white">&bullet;</span> <span class="text-white">Contact</span></div>

            </div>
        </div>
    </div>
</div>



<div class="site-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-7 mb-5">


                <form action="/saveContact" class="p-5 bg-white">

                    <div class="row form-group">
                        <p style="color: blue">${ok}</p>
                        <div class="col-md-12">
                            <label class="text-black" for="message">Nội dung liên hệ</label>
                            <textarea name="content" id="message" cols="30" rows="7" class="form-control" placeholder="Vui lòng nhập nội dung vào đây!"></textarea>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Send Message" class="btn btn-primary py-2 px-4 text-white">
                        </div>
                    </div>


                </form>
            </div>
            <div class="col-md-5">

                <div class="p-4 mb-3 bg-white">
                    <p class="mb-0 font-weight-bold">Địa chỉ</p>
                    <p class="mb-4">104 Chiến Thắng, Tân Triều, Thanh Trì, Hà Nội</p>

                    <p class="mb-0 font-weight-bold">Phone</p>
                    <p class="mb-4"><a href="#">+8433 6242 559</a></p>

                    <p class="mb-0 font-weight-bold">Email</p>
                    <p class="mb-0"><a href="#">winter@gmail.com</a></p>

                </div>

                <div class="p-4 mb-3 bg-white">
                    <div class="fb-page" data-href="https://www.facebook.com/vntravel/" data-tabs="timeline" data-width="400" data-height="320" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/vntravel/" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/vntravel/">Vietnam Travel</a></blockquote></div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="site-section bg-light">
    <div class="container">
        <div class="row justify-content-center mb-5">
            <div class="col-md-7 text-center">
                <h2 class="font-weight-light text-black">Dịch vụ của chúng tôi</h2>
                <p class="color-black-opacity-5">Luôn mang đến trải nhiệm tốt nhất cho mọi người</p>
            </div>
        </div>
        <div class="row align-items-stretch">
            <div class="col-md-6 col-lg-4 mb-4 mb-lg-4">
                <div class="unit-4 d-flex">
                    <div class="unit-4-icon mr-4"><span class="text-primary flaticon-airplane"></span></div>
                    <div>
                        <h3>Vé máy bay</h3>
                        <p>Vé máy bay luôn có mức giá rẻ nhất và kèm theo đầy đủ các dịch vụ trên các chuyến bay</p>
                        <p><a href="#">Learn More</a></p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 mb-4 mb-lg-4">
                <div class="unit-4 d-flex">
                    <div class="unit-4-icon mr-4"><span class="text-primary flaticon-hotel"></span></div>
                    <div>
                        <h3>Khách sạn</h3>
                        <p>Chúng tôi luôn cung cấp các dịch vụ nghỉ dưỡng giá tốt nhất thị trường mang đến cho khách hàng lựa chọn thoải mái, dễ chịu nhất</p>
                        <p><a href="#">Learn More</a></p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 mb-4 mb-lg-4">
                <div class="unit-4 d-flex">
                    <div class="unit-4-icon mr-4"><span class="text-primary flaticon-route"></span></div>
                    <div>
                        <h3>Địa điểm đẹp</h3>
                        <p>Tham quan khám phá những nơi tuyệt đẹp trong nước và quốc tế với những địa điểm nổi tiếng</p>
                        <p><a href="#">Learn More</a></p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</div>

<script src="AdminTemplate/js/jquery-3.3.1.min.js"></script>
<script src="AdminTemplate/js/jquery-migrate-3.0.1.min.js"></script>
<script src="AdminTemplate/js/jquery-ui.js"></script>
<script src="AdminTemplate/js/popper.min.js"></script>
<script src="AdminTemplate/js/bootstrap.min.js"></script>
<script src="AdminTemplate/js/owl.carousel.min.js"></script>
<script src="AdminTemplate/js/jquery.stellar.min.js"></script>
<script src="AdminTemplate/js/jquery.countdown.min.js"></script>
<script src="AdminTemplate/js/jquery.magnific-popup.min.js"></script>
<script src="AdminTemplate/js/bootstrap-datepicker.min.js"></script>
<script src="AdminTemplate/js/aos.js"></script>

<script src="AdminTemplate/js/main.js"></script>

</body>
</html>

