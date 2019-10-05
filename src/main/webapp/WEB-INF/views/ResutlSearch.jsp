<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: winter
  Date: 28/09/2019
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
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

    <div class="container bg-light">
        <div class="row justify-content-center mb-3">
            <div class="col-md-7 text-center">
                <h3 class="font-weight-light text-black">Tìm kiếm</h3>
                <p class="color-black-opacity-5">Tìm kiếm những Tour du lịch mong muốn</p>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="col-md-12 mb-5">
                    <form action="Search" method="post" class="p-5 bg-white">
                        <div class="row form-group">
                            <div class="col-md-6 mb-3 mb-md-0">
                                <label class="text-black" >Tên tour:</label>
                                <input type="text" class="form-control" name="nameTour" required="required" placeholder="Keyword here">
                            </div>
                            <div class="col-md-6">
                                <label class="text-black"for="date" >Ngày khởi hành:</label>
                                <input type="text" id="date"  name="date" class="form-control datepicker px-2" placeholder="Date of visit">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-12">
                                <input type="submit" value="Search" class="btn btn-primary py-2 px-4 text-white">
                            </div>
                        </div>


                    </form>
                </div>
                <%--                    <div class="find_form_container">--%>
                <%--                        <form action="Search" method="post" class="find_form d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-md-between justify-content-start flex-wrap">--%>
                <%--                            <div class="form-group">--%>
                <%--                                <label class="text-black">Tên tour:</label>--%>
                <%--                                <input type="text" class="form-control" name="nameTour" required="required" placeholder="Keyword here">--%>
                <%--                            </div>--%>
                <%--                            <div class="form-group">--%>
                <%--                                    <label class="text-black" for="date">Ngày khởi hành:</label>--%>
                <%--                                    <input type="text" id="date"  name="date" class="form-control datepicker px-2" placeholder="Date of visit">--%>

                <%--                                &lt;%&ndash;                            <input type="text" class="form-control"  required="required" placeholder="Keyword here">&ndash;%&gt;--%>
                <%--                            </div>--%>
                <%--                            <button type="submit" value="Search" class="btn btn-primary py-2 px-4 text-white">Search</button>--%>
                <%--                        </form>--%>
                <%--                    </div>--%>
            </div>
        </div>

    </div>

<div class="site-section">

    <div class="container">

        <div class="row">
            <h3 style="color: blue">${err}</h3>
            <c:forEach var="items" items="${result}">
                <div class="col-md-6 col-lg-4 mb-4 mb-lg-4">
                    <a href="TourDetails?id=${items.id_tour}" class="unit-1 text-center">
                        <img width="700" height="799" src="../../../uploadImg/${items.images.nameImages}" alt="Image" class="img-fluid">
                        <div class="unit-1-text">
                            <span></span>
                            <h3>${items.nameTour}</h3>
                            <span>${items.departureDate}</span> <br>
                            <span class="price">$ ${items.price}</span> <br>
                            <span class="price">Số người: ${items.totalMember}</span>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
<%--        <div class="row">--%>
<%--            <div class="col-12 text-center mt-5 mb-5">--%>
<%--                <button class="btn btn-outline-primary border-2 py-3 px-5" id="loadmore">Load More</button>--%>
<%--            </div>--%>
<%--        </div>--%>
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
<script>
    $(document).ready(function () {
        function createCard(items) {
            let id= items.id_tour;
            let image = items.images.nameImages;
            let nameTour = items.nameTour;
            let date = items.departureDate;
            let priceTour = items.price;
            return ' <div class="col-md-6 col-lg-4 mb-4 mb-lg-4">\n' +
                '                    <a href="TourDetails?id='+id+'" class="unit-1 text-center">\n' +
                '                        <img width="700" height="799" src="../../../uploadImg/'+image+'" alt="Image" class="img-fluid">\n' +
                '                        <div class="unit-1-text">\n' +
                '                            <span></span>\n' +
                '                            <h3>'+nameTour+'</h3>\n' +
                '                            <span>'+date+'</span> <br>\n' +
                '                            <span class="price">$'+ priceTour +'</span>\n' +
                '                        </div>\n' +
                '                    </a>\n' +
                '                </div>';
        }
        let page = 2;
        let total= 0;
        $.get('/getAllTourVN/total',function (count) {
            total=count;
        })
        $('#loadmore').click(function () {

            $.get('/getAllTourVN?page='+page,function (data) {
                if((page-1)==total)
                    $('#loadmore').hide();
                const content =  $('.row')[2];
                for(let i=0;i<data.length;i++){
                    $(content).append(createCard(data[i]));
                }

            });
            page++;
        })
    })
</script>
</body>
</html>

