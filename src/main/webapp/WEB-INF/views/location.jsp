<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>location</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <style>
    .wrap {
      position: absolute;
      left: 0;
      bottom: 40px;
      width: 288px;
      height: 132px;
      margin-left: -144px;
      text-align: left;
      overflow: hidden;
      font-size: 12px;
      font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
      line-height: 1.5;
    }
  
    .wrap * {
      padding: 0;
      margin: 0;
    }
  
    .wrap .info {
      width: 286px;
      height: 120px;
      border-radius: 5px;
      border-bottom: 2px solid #ccc;
      border-right: 1px solid #ccc;
      overflow: hidden;
      background: #fff;
    }
  
    .wrap .info:nth-child(1) {
      border: 0;
      box-shadow: 0px 1px 2px #888;
    }
  
    .info .title {
      padding: 5px 0 0 10px;
      height: 30px;
      background: #eee;
      border-bottom: 1px solid #ddd;
      font-size: 18px;
      font-weight: bold;
    }
  
    .info .close {
      position: absolute;
      top: 10px;
      right: 10px;
      color: #888;
      width: 17px;
      height: 17px;
      background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
    }
  
    .info .close:hover {
      cursor: pointer;
    }
  
    .info .body {
      position: relative;
      overflow: hidden;
    }
  
    .info .desc {
      position: relative;
      margin: 13px 0 0 90px;
      height: 75px;
    }
  
    .desc .ellipsis {
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  
    .desc .jibun {
      font-size: 11px;
      color: #888;
      margin-top: -2px;
    }
  
    .info .img {
      position: absolute;
      top: 6px;
      left: 5px;
      width: 73px;
      height: 71px;
      border: 1px solid #ddd;
      color: #888;
      overflow: hidden;
    }
  
    .info:after {
      content: '';
      position: absolute;
      margin-left: -12px;
      left: 50%;
      bottom: 0;
      width: 22px;
      height: 12px;
      background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
    }
  
    .info .link {
      color: #5085BB;
    }
  </style>
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
  <!-- =======================================================
  * Template Name: Mentor
  * Updated: Mar 10 2023 with Bootstrap v5.2.3
  * Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="index.jsp">enjoyTRIP</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0 ">
        <ul>
          <!-- <li><a class="active" href="index.html">Home</a></li> -->
          <li><a href="location.jsp">지역별여행지</a></li>
          <li><a href="myplan.jsp">나의여행계획</a></li>
          <li><a href="hotplace.jsp">핫플자랑하기</a></li>
          <li><a href="shareinfo.jsp">여행정보공유</a></li>
       	<c:if test="${empty userinfo}">
          <li>
            <a class="nav-link" href="${root}/member?action=mvlogin">로그인</a>
		  </li>
		  <%@ include file="login.jsp" %>
          <li>
            <a class="nav-link" href="#" data-toggle="modal" data-target="#register">회원가입</a>   


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
  </header><!-- End Header -->

  <!-- ======= 관광정보 타이틀 ======= -->
  <div class="container mt-5"><br> </div>
  <div class="container mt-5"> </div>


  <main id="main">
    <!-- 타이틀 -->
    <div class="d-flex justify-content-center">
      <h1>지역별 관광정보</h1>
    </div>
    <div class="container mt-5"></div>
    <!-- 타이틀 끝 -->

    <!-- 선택창 시작 -->
    <div class="mx-auto" style="width: 700px;">
      <!-- 관광지 검색 start -->
      <form class="d-flex mt-3 justify-content-center" role="search" action="attraction" method="post">
      	<input type="hidden" name="seven" value="list">
        <select id="search-area" class="form-select" aria-label="Default select example" name="sido_code" >
          <option value="0" selected>검색 할 시,도 선택</option>
        </select>
        <select id="search-location" class="form-select" aria-label="Default select example" name="gugun_code">
          <option value="0" selected>검색 할 구,군 선택</option>
        </select>
        <select id="search-content-id" class="form-select" aria-label="Default select example" name="content_type_id">
          <option value="0" selected>관광지 유형</option>
          <option value="12">관광지</option>
          <option value="14">문화시설</option>
          <option value="15">행사/공연/축제</option>
          <option value="25">여행코스</option>
          <option value="28">레포츠</option>
          <option value="32">숙박</option>
          <option value="38">쇼핑</option>
          <option value="39">음식점</option>
        </select>
        <button id="btn-search" class="btn btn-outline-success" type="submit">검색</button>
      </form>
      <div class="d-flex justify-content-center mt-5" id="kakaomap">
        <!-- 매장 위치 정보 kakaomap start -->
        <div id="map" class="d-flex justify-content-center" style="width: 800px; height: 400px"></div>
        <!-- 매장 위치 정보 kakaomap end -->
      </div>
      <div class="row d-flex justify-content-center">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>대표이미지</th>
              <th>관광지명</th>
              <th>주소</th>
              <th>거리</th>
            </tr>
          </thead>
          <tbody id="trip-list">
          <!-- 관광지 리스트 즉시 출력 -->
          <c:if test="${! empty attList}">
	          <c:forEach var="att" items="${attList}" begin="1" end="20">
	          	<tr>
	              <th><image src="${att.image}" width="100px"></th>
	              <th>${att.title}</th>
	              <th>${att.addr}</th>
	              <th>${att.distance}m</th>
	            </tr>
	          </c:forEach>
	            <script>
	            	console.log("in");
	            </script>
          </c:if>
          </tbody>
        </table>
      </div>
      <!-- 관광지 검색 end -->
      <!-- 선택창 끝 -->
    </div>


  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>

  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>


  <!-- 카카오맵 관련  스크립트-->
  <script type="text/javascript"
    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72f9f6a1a2fc730340d9885c4c1e4828&libraries=services,clusterer,drawing"></script>

  <script>
    // index page 로딩 후 전국의 시도 설정.
    let areaUrl =
      "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
      serviceKey +
      "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

    var marker, infowindow;
    var container = document.getElementById("map");
    var myLatLng = new kakao.maps.LatLng(37.5012743, 127.039585);
    var options = {
      center: myLatLng,
      level: 3,
    };

    // fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
    fetch(areaUrl, { method: "GET" })
      .then((response) => response.json())
      .then((data) => makeOption(data));

    function makeOption(data) {
      let areas = data.response.body.items.item;
      let sel = document.getElementById("search-area");
      areas.forEach((area) => {
        let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.appendChild(document.createTextNode(area.name));
        sel.appendChild(opt);
      });
    }
    document.getElementById("search-area").addEventListener("change",(e)=>{
      let getAreaCode=e.target.value;
      let sigunguUrl=`https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=\${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=\${getAreaCode}&_type=json`;
      fetch(sigunguUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption2(data));
  
      function makeOption2(data) {
        let sigungus = data.response.body.items.item;
        let selloc = document.getElementById("search-location");
        selloc.length=0;
        sigungus.forEach((sigungu) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", sigungu.code);
          opt.appendChild(document.createTextNode(sigungu.name));
          selloc.appendChild(opt);
          
        
        });
      }
    });

    
    
    
    
    // 여기부터 건드리면 됩니다!
    // 여기부터 건드리면 됩니다!
    // 여기부터 건드리면 됩니다!
    // 여기부터 건드리면 됩니다!
    // 여기부터 건드리면 됩니다!
    // 여기부터 건드리면 됩니다!
    // 카카오지도
    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
      mapOption = {
        center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
        level: 5, // 지도의 확대 레벨
      };

    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);
    
    
    var contentTypeId = document.getElementById("search-content-id").value;
    document.getElementById("btn-search").addEventListener("submit", makeList2());

    var positions; // marker 배열.
    function makeList2() {
       	console.log("makeListin");
       	positions =[];
       	<c:if test="${! empty attList}">
       	<c:forEach var="att" items="${attList}" begin="1" end="20">
       		var getmarkerInfo = {
                title: "${att.title}",
                latlng: new kakao.maps.LatLng(${att.latitude}, ${att.longitude}),
                ct: ${att.content_type_id},
                image: "${att.image}",
                addr: "${att.addr}"
              };
       		positions.push(getmarkerInfo);
      	</c:forEach>
      	for (var i = 0; i < positions.length; i++) {
      	    console.log(positions[i]['title']);
      	}
      	displayMarker();
      	</c:if>
      }
    

    
 

    function displayMarker() {
      console.log("displayin");
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/category.png";
      var bounds = new kakao.maps.LatLngBounds();
      console.log("bound");
      //바운드
      if (map!=null) {
        map= null;
      }
      map = new kakao.maps.Map(mapContainer, mapOption);
     	
      console.log("mapcreate");
      positions.forEach((pos) => {
    	  var imageSize = new kakao.maps.Size(24, 24);
          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage("./assets/img/camera.png", imageSize);
          // 마커를 생성합니다
          console.log(pos.ct);
          if (pos.ct ==12) {//관광지면 관광지마크
            markerImage = new kakao.maps.MarkerImage('./assets/img/camera.png', imageSize);
          }else if (pos.ct == 14) {//문화시설
          	console.log("art");
            markerImage = new kakao.maps.MarkerImage('./assets/img/museum.png', imageSize);
          }else if (pos.ct == 15) {//행사
            markerImage = new kakao.maps.MarkerImage('./assets/img/parade.png', imageSize);
          }else if (pos.ct == 25) {//여행
            markerImage = new kakao.maps.MarkerImage('./assets/img/vacation.png', imageSize);
          }else if (pos.ct == 28) {//레포츠
            markerImage = new kakao.maps.MarkerImage('./assets/img/sports.png', imageSize);
          }else if (pos.ct == 32) {//숙박
            markerImage = new kakao.maps.MarkerImage('./assets/img/bed.png', imageSize);
          }else if (pos.ct == 38) {//쇼핑
            markerImage = new kakao.maps.MarkerImage('./assets/img/shopping.png', imageSize);
          }else if (pos.ct == 39) {//음식점
            markerImage = new kakao.maps.MarkerImage('./assets/img/restaurant.png', imageSize);
          }
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: pos.latlng, // 마커를 표시할 위치
            title: pos.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            markct: pos.ct,
            image: markerImage, // 마커 이미지
            clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
          });
          var content = `<div class="wrap">` +
          `    <div class="info">` +
          `       <div class="title">` +
          `            \${pos.title}` +
          `        </div>` +
          `        <div class="body">` +
          `            <div class="img">` +
          `                <img src="\${pos.image}" width="73" height="70">` +
          `           </div>` +
          `            <div class="desc">` +
          `                <div class="ellipsis">\${pos.addr}</div>` +
          `                <div class="jibun ellipsis">\${pos.addr2}</div>` +
          `                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">눌러서 자세히보기</a></div>` +
          `            </div>` +
          `        </div>` +
          `    </div>` +
          `</div>`;
        	// 마커 위에 커스텀오버레이를 표시합니다
        	// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
        	/* var overlay = new kakao.maps.CustomOverlay({
         	 content: content,	
        	  map: map,
        	  position: pos.latlng
        	});
	        // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
	        
	        function closeOverlay() {
	          overlay.setMap(null);
	        }
	       	closeOverlay(); */
          	kakao.maps.event.addListener(marker, 'click', function () {
          		console.log(pos.latlng);
          		map.setCenter(pos.latlng);
	          	let overlay = new kakao.maps.CustomOverlay({
	            	 content: content,	
	           	  map: map,
	           	  position: pos.latlng
	           	});
          	});
          	kakao.maps.event.addListener(marker, 'mouseout', function () {
          		overlay.setMap(null);
          	});
          bounds.extend(pos.latlng);
    });//	eof
            // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
      map.setCenter(positions[0].latlng);
      var content2 = `<div class="wrap">` +
      `    <div class="info">` +
      `       <div class="title">` +
      `            \${positions[0].title}` +
      `        </div>` +
      `        <div class="body">` +
      `            <div class="img">` +
      `                <img src="\${positions[0].image}" width="73" height="70">` +
      `           </div>` +
      `            <div class="desc">` +
      `                <div class="ellipsis">\${positions[0].addr}</div>` +
      `                <div class="jibun ellipsis">\${positions[0].addr2}</div>` +
      `                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">눌러서 자세히보기</a></div>` +
      `            </div>` +
      `        </div>` +
      `    </div>` +
      `</div>`;
      let overlay = new kakao.maps.CustomOverlay({
     	 content: content2,	
    	  map: map,
    	  position: positions[0].latlng
    	});
      	
      	function moveCenter(lat, lng) {
          map.setCenter(new kakao.maps.LatLng(lat, lng));
        }
	    function setBounds() {
	        // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
	        // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
	        map.setBounds(bounds);
	    }
      setBounds();
    }//eof displaymarker
    
    
    
  </script>
</body>

</html>