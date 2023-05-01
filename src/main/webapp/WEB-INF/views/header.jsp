<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
  <head>

  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>enjoyTRIP</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <link
    rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
  />
  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
    rel="stylesheet">
  
  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
  <script src="assets/js/key.js"></script>
  </head>
  <body>  
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="index.jsp">enjoyTRIP</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0 ">
        <ul>
          <!-- <li><a class="active" href="index.html">Home</a></li> -->
          <li><a href="${root}/location">지역별여행지</a></li>
          <li><a href="${root }/plan?action=mvplan">나의여행계획</a></li>
          <li><a href="${root}/hotplace?action=mvhotplace">핫플레이스</a></li>
          <li><a href="${root}/board?action=list">게시판</a></li>
          <li><a href="shareinfo.jsp">여행정보공유</a></li>
       	<c:if test="${empty userinfo}">
          <li>
            <!-- <a class="nav-link" href="#" data-toggle="modal" data-target="#login">로그인</a>  -->
            <a class="nav-link" href="${root}/member?action=mvlogin">로그인</a>
          </li>
		  <%@ include file="login.jsp" %>
          <li>
            <a class="nav-link" href="#" data-toggle="modal" data-target="#register">회원가입</a>   
          </li>

         </c:if>
         <c:if test="${not empty userinfo}">
         	<li class="navbar-brand">
         		<strong>${userinfo.userName}님</strong>
         	</li>
           <li>
            <a class="nav-link" href="#" data-toggle="modal" data-target="#modify"> 정보수정 </a>
          </li>
		  <%@ include file="modify.jsp" %>
          <li>
            <a class="nav-link" href="${root}/member?action=logout">로그아웃</a>   
          </li>
         </c:if>
        </ul>
      </nav><!-- .navbar -->
    </div>

