<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Dashboard - Ace Admin</title>

    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="AdminTemplate/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="AdminTemplate/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="AdminTemplate/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="AdminTemplate/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="AdminTemplate/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="AdminTemplate/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="AdminTemplate/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="AdminTemplate/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="AdminTemplate/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="AdminTemplate/assets/js/html5shiv.min.js"></script>
    <script src="AdminTemplate/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="/report" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Ace Admin
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav" style="">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="AdminTemplate/assets/images/avatars/user.jpg" alt="Jason's Photo">
                        <span class="user-info">
									<small>Welcome,</small>
                                    ${account}
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                        <li>
                            <a href="/logoutad">
                                <i class="ace-icon fa fa-power-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

    </div><!-- /.navbar-container -->
</div>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>


        <ul class="nav nav-list">
            <li class="">
                <a href="/admin">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="/Member">
                    <i class="menu-icon fa fa-users"></i>
                    <span class="menu-text">
								Member
							</span>
                </a>

                <b class="arrow"></b>

            </li>
            <li class="active">
                <a href="/Tour">
                    <i class="menu-icon fa fa-plane"></i>
                    <span class="menu-text"> Tour </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="">
                <a href="/Place">
                    <i class="menu-icon fa fa-location-arrow"></i>
                    <span class="menu-text"> Place </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="">
                <a href="/Category">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> Category </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-cart-arrow-down"></i>
                    <span class="menu-text"> Order </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="/Order">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Order List
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="/OrderDetails">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Order Details
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="/upload">
                    <i class="menu-icon fa fa-picture-o"></i>
                    <span class="menu-text"> Gallery </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="">
                <a href="/ContactAdmin">
                    <i class="menu-icon fa fa-phone-square"></i>
                    <span class="menu-text"> Contact </span>
                </a>

                <b class="arrow"></b>
            </li>

        </ul><!-- /.nav-list -->

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="/admin">Home</a>
                    </li>
                    <li class="active">Tour</li>
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- /.nav-search -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>Tour Manager </h1>
                </div><!-- /.page-header -->
                <div class="modal-footer no-margin-top">
                    <a href="/AddTour">
                        <button class="btn btn-sm btn-active pull-left" data-dismiss="modal">
                            <i class="ace-icon fa fa-plus"></i>
                            Add new Tour
                        </button>
                    </a>
                    <ul class="pagination pull-right no-margin">
                        <li class="prev">
                            <a href="?page=${current - 1}">
                                <i class="ace-icon fa fa-angle-double-left"></i>
                            </a>
                        </li>
                    <c:forEach var="index" begin="1" end="${total}">
                        <c:choose>
                            <c:when test="${index==current}">
                        <li class="active">
                            <a href="?page=${index}">${index}</a>
                        </li>
                            </c:when>
                            <c:otherwise>
                        <li>
                            <a href="?page=${index}">${index}</a>
                        </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                        <li class="next">
                            <a href="?page=${current + 1}">
                                <i class="ace-icon fa fa-angle-double-right"></i>
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="row">

                    <div class="col-xs-8 col-md-offset-2">
                        <h3 class="header smaller lighter blue">ALL Tour</h3>
                        <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" />
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>ID</th>
                                <th>Name Tour</th>
                                <th>Departure Date</th>
                                <th>Price</th>
                                <th>Place</th>
                                <th>Category</th>
                                <th>Images</th>
                                <th>Action</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="items" items="${getTour}">
                                <tr>
                                    <td class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace" />
                                            <span class="lbl"></span>
                                        </label>
                                    </td>
                                    <td>${items.id_tour}</td>
                                    <td>${items.nameTour}</td>
                                    <td>${items.departureDate}</td>
                                    <td>${items.price}</td>
                                    <td>${items.place.namePlace}</td>
                                    <td>${items.category.nameCate}</td>
                                    <td><img width="150" height="150" alt="150x150" src="/uploadImg/${items.images.nameImages}" /><td>
                                    <div class="hidden-sm hidden-xs action-buttons">
                                        <a class="green" href="EditTour?id=${items.id_tour}">
                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                        </a>

                                        <a class="red" href="DeleteTour?id=${items.id_tour}" onclick="return confirm('Delete this item?')">
                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                        </a>
                                    </div>
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>

                    <!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <%@ include file="Footer.jsp" %>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="AdminTemplate/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="AdminTemplate/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="AdminTemplate/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="AdminTemplate/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="AdminTemplate/assets/js/jquery-ui.custom.min.js"></script>
<script src="AdminTemplate/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="AdminTemplate/assets/js/jquery.easypiechart.min.js"></script>
<script src="AdminTemplate/assets/js/jquery.sparkline.index.min.js"></script>
<script src="AdminTemplate/assets/js/jquery.flot.min.js"></script>
<script src="AdminTemplate/assets/js/jquery.flot.pie.min.js"></script>
<script src="AdminTemplate/assets/js/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="AdminTemplate/assets/js/ace-elements.min.js"></script>
<script src="AdminTemplate/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
</body>
</html>
