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
  
  <style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
</head>

<body class=" h-100 text-center text-bg-white">

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
		  <%@ include file="/modify.jsp" %>
          <li>
            <a class="nav-link" href="${root}/member?action=logout">로그아웃</a>   
          </li>
         </c:if>
        </ul>
      </nav><!-- .navbar -->
    </div>
  </header><!-- End Header -->

  <main id="main" style="margin:100px">
   <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    
<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">	
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="이태원 맛집" id="keyword" size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
    
    <!-- 계획 리스트 -->
              <div class="row">
                <table id="table_myplan" class="table table-striped" style="display: none">
                  <thead>
                    <tr>
                      <th>관광지명</th>
                      <th>주소</th>
                      <th>수정</th>
                    </tr>
                  </thead>
                  <tbody id="plan-list"></tbody>
                </table>
                <button id="btn-findpath" class="btn btn-success">경로 찾기</button>
              </div>
    
</div>
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
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
    
    addPlanListener();
}

//검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
            '   <h5 style="display: inline;">' + places.place_name + '</h5>' +
            '<button type="button" class="btn btn-success btn_add_plan" style="padding-left: 2px; padding-right: 2px; margin-left: 5px" value="추가">추가</button>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
    itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}
 
var num = 0;
function addPlanListener() {
    // 계획에 추가하는 버튼에 리스너 달기
    var btnList = document.getElementsByClassName("btn_add_plan");
    for (let i = 0; i < btnList.length; i++) {
        btnList[i].addEventListener("click", () => {
            document.querySelector("#table_myplan").setAttribute("style", "display: ;");

            let title = btnList[i].previousElementSibling.innerHTML;
            let addr = btnList[i].nextElementSibling.innerHTML;

            let plan = `
                        <tr id="list_${num}" class="plan_list">
                            <td class="place_name">` + title + `</td>
                            <td class="place_addr">` + addr + `</td>
                            <td>
                                <button class="btn btn-sm btn-danger btn-remove-plan" onclick="removeList('list_${num}');">삭제</button>
                            </td>
                        </tr>
                    `;
            num++;
            document.getElementById("plan-list").innerHTML += plan;
        });
    }
}

function moveListUp(id) {
    let present = document.getElementById(id);
    if (present.previousElementSibling != null) {   
        let previous = present.previousElementSibling;
        
        let tmpHTML = previous.innerHTML;
        let tmpId = previous.id;
        
        previous.innerHTML = present.innerHTML;
        present.innerHTML = tmpHTML;
        
        previous.id = id;
        present.id = tmpId;
    }
}

function moveListDown(id) {
    let present = document.getElementById(id);
    if (present.nextElementSibling != null) {
        let next = present.nextElementSibling;
        
        let tmpHTML = next.innerHTML;
        let tmpId = next.id;
        
        next.innerHTML = present.innerHTML;
        present.innerHTML = tmpHTML;
        
        next.id = id;
        present.id = tmpId;
    }
}

function removeList(id) {
    document.getElementById(id).remove();
}

function haversine(lat1, lon1, lat2, lon2) {
  const R = 6371; // 지구 반지름 (km)
  const dLat = (lat2 - lat1) * Math.PI / 180; // 위도 차이 (라디안)
  const dLon = (lon2 - lon1) * Math.PI / 180; // 경도 차이 (라디안)
  const a = Math.sin(dLat/2) * Math.sin(dLat/2) +
            Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
            Math.sin(dLon/2) * Math.sin(dLon/2);
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  const d = R * c; // 두 지점 간의 거리 (km)
  return d;
}

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();   
var names = []; 
var geoList = [];
document.getElementById("btn-findpath").addEventListener("click", function() {
	tmp = document.getElementsByClassName("place_addr");
	
	Array.from(document.getElementsByClassName("place_name")).forEach((el) => {
		names.push(el.innerHTML);
	});
	
	Array.from(tmp).forEach((el) => {
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(el.innerHTML, function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		        geoList.push([result[0].y, result[0].x]);
		    } 
		}); 
	});
	
	 setTimeout(() => {
	      // 작업 완료 후 호출
	   	tsp(geoList);	    
	}, 100);
});

function tsp(cities) {
	// 모든 가능한 경로를 생성합니다.
	const permutations = permute(cities.map((_, i) => i));

	// 모든 가능한 경로를 평가하여 가장 짧은 경로를 찾습니다.
	let shortestDistance = Infinity;
	let shortestPath = [];
	permutations.forEach((path) => {
	  let totalDistance = 0;
	  for (let i = 0; i < path.length - 1; i++) {
	    let city1 = cities[path[i]];
	    let city2 = cities[path[i + 1]];
	    totalDistance += distance(city1, city2);
	  }
	  totalDistance += distance(cities[path[path.length - 1]], cities[path[0]]);
	  if (totalDistance < shortestDistance) {
	    shortestDistance = totalDistance;
	    shortestPath = path;
	  }
	});

	// 최단 경로를 출력합니다.
	 setTimeout(() => {
	      // 작업 완료 후 호출
		 let pathString = "";

		 for (let i = 0; i < shortestPath.length; i++) {
			 pathString += names[shortestPath[i]];
			 pathString += " -> ";
		 }
		 pathString += names[shortestPath[0]];
		 
		alert("최단 경로는 " + pathString + "이며, 전체 이동 거리는 " + shortestDistance + "km 입니다.");  
	}, 100);
	
}

//모든 가능한 경로를 생성하는 함수를 정의합니다.
function permute(permutation) {
let length = permutation.length,
   result = [permutation.slice()],
   c = new Array(length).fill(0),
   i = 1, k, p;
while (i < length) {
 if (c[i] < i) {
   k = i % 2 && c[i];
   p = permutation[i];
   permutation[i] = permutation[k];
   permutation[k] = p;
   ++c[i];
   i = 1;
   result.push(permutation.slice());
 } else {
   c[i] = 0;
   ++i;
 }
}
return result;
}

//두 도시 사이의 거리를 계산하는 함수를 정의합니다.
function distance(city1, city2) {
return haversine(city1[0], city1[1], city2[0], city2[1]);
}

</script>
</body>

</html>