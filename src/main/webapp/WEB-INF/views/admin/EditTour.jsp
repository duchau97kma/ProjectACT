<%--
  Created by IntelliJ IDEA.
  User: winter
  Date: 15/09/2019
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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


    <script src="AdminTemplate/assets/js/html5shiv.min.js"></script>
    <script src="AdminTemplate/assets/js/respond.min.js"></script>
<%--    <script src="AdminTemplate/assets/js/ckeditor_4.12.1_standard/ckeditor/ckeditor.js"></script>--%>
    <script src="https://cdn.ckeditor.com/4.12.1/full/ckeditor.js"></script>
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
                <%--                <div class="modal-footer no-margin-top">--%>
                <%--                    <a href="#">--%>
                <%--                        <button class="btn btn-sm btn-active pull-left" data-dismiss="modal">--%>
                <%--                            <i class="ace-icon fa fa-plus"></i>--%>
                <%--                            Add new--%>
                <%--                        </button>--%>
                <%--                    </a>--%>
                <%--                    --%>
                <%--                </div>--%>

                <div class="row">
                    <div class="col-xs-12">
                        <h3 class="header smaller lighter blue">EDIT TOUR</h3>
                        <spring:form class="form-horizontal" role="form" action="updateTour" method="POST" modelAttribute="tour">
                            <input type="hidden" name="id_tour" value="${tour.id_tour}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Name </label>
                                <div class="col-sm-9">
                                    <input type="text" id="form-field-1" value="${tour.nameTour}" name="nameTour" class="col-xs-10 col-sm-5" />

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Total Member </label>

                                <div class="col-sm-9">
                                    <input type="text" id="form-field-1" placeholder="Total Member" name="totalMember" value="${tour.totalMember}" class="col-xs-10 col-sm-5" />

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Place </label>
                                <div class="col-sm-9">

                                    <select name="id_place">
                                        <c:forEach var="items" items="${place}">
                                            <option value="${items.id_place}">${items.namePlace}</option>
                                            <%--                                        <option value="2">2-User</option>--%>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Category </label>
                                <div class="col-sm-9">

                                    <select name="id_cate">
                                        <c:forEach var="items" items="${cate}">
                                            <option value="${items.id_cate}">${items.nameCate}</option>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Select Images </label>

                                <div class="col-sm-9">

                                    <a href="#my-modal" role="button" class="bigger-125 bg-primary white" data-toggle="modal">
                                        &nbsp; Choose Images
                                    </a>
                                    <div id="my-modal" class="modal fade" tabindex="-1" style="display: none;">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                    <h3 class="smaller lighter blue no-margin">Images</h3> <br>
                                                    <input type="text" id="images" placeholder="Select Name" name="id_img" value="${tour.images.nameImages}" class="col-xs-3 col-sm-5" />
                                                </div>

                                                <div class="modal-body">
                                                    <c:forEach var="img" items="${img}">

                                                        <img class="${img.id_img}" id="${img.id_img}" style ="width:150px; height: 150px;" alt="150x150" src="/uploadImg/${img.nameImages}" />

                                                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"> </script>
                                                        <script  type="text/javascript">
                                                            $(document).ready(function(){
                                                                $(".${img.id_img}").click(function(){
                                                                    let a = $(".${img.id_img}").attr("id");
                                                                    $("#images").val(a);
                                                                });
                                                            });

                                                        </script>
                                                    </c:forEach>
                                                    <!-- PAGE CONTENT ENDS -->

                                                </div>

                                                <div class="modal-footer">
                                                    <button class="btn btn-sm btn-danger pull-right" data-dismiss="modal">
                                                        <i class="ace-icon fa fa-times"></i>
                                                        Close
                                                    </button>
                                                    &nbsp;  &nbsp;
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
                                            </div><!-- /.modal-content -->

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Price </label>

                                <div class="col-sm-9">
                                    <input type="text" id="form-field-1" value="${tour.price}" name="price" class="col-xs-10 col-sm-5" />

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Discount </label>

                                <div class="col-sm-9">
                                    <input type="text" id="form-field-1" value="${tour.discount}" name="discount" class="col-xs-10 col-sm-5" />

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Departure Date </label>

                                <div class="col-sm-9">
                                    <input type="text" id="form-field-1" value="${tour.departureDate}" name="departureDate" class="col-xs-10 col-sm-5" />

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Summary </label>

                                <div class="col-sm-9">
                                    <textarea rows="10" cols="119" name="summaryTour">${tour.summaryTour}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Content </label>
                                <div class="col-sm-9">
                                    <textarea id="editor" name="content"> ${tour.content}</textarea>
                                </div>
                            </div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-5 col-md-9">
                                    <button class="btn btn-info" type="submit">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Submit
                                    </button>
                                    &nbsp; &nbsp; &nbsp;
                                    <button class="btn" type="reset">
                                        <i class="ace-icon fa fa-undo bigger-110"></i>
                                        Reset
                                    </button>
                                </div>
                            </div>
                        </spring:form>

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

<!-- ace scripts -->
<script src="AdminTemplate/assets/js/ace-elements.min.js"></script>
<script src="AdminTemplate/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script>
    CKEDITOR.replace('editor',{
        height:600,
        width:1000,
        filebrowserUploadUrl: "uploadFile",
        filebrowserImageBrowseUrl : "upload",
    });

</script>
</body>
</html>
