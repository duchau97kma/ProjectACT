<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>-->
    <link rel="stylesheet" href="AdminTemplate/css/aos.css">
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v4.0"></script>
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



    <div class="site-section bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-7 mb-5">

                    <p style="color: red ">${error}</p>
                    <form action="loggingUser" method="post" class="p-5 bg-white" modelAttribute="loginForm">
                        <div class="row form-group" >
                            <div class="col-md-6 mb-3 mb-md-0">
                                <label class="text-black" for="fname">Account</label>
                                <input type="text" name="account"  id="fname" class="form-control" placeholder="Account">
                            </div>
                            <div class="col-md-6">
                                <label class="text-black" for="lname">Password</label>
                                <input type="password" name="password" id="lname" class="form-control" placeholder="Password">
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col-md-6">
                                <input type="submit" value="Login" class="btn btn-primary py-2 px-4 text-white">
                                <input type="reset" value="Reset" class="btn btn-primary py-2 px-4 text-white">
                            </div>
                        </div>


                    </form>
                </div>
                <div class="col-md-5">



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