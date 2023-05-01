<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">  
    <link href="/css/board.css" rel="stylesheet"/>
    <link href="./css/styles.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color:cornflowerblue">

  <div style="text-align: center; margin-top: 60px">
    <h1 id="hotplace" class="fw-bold" style="color:cornflowerblue; background-color:antiquewhite; border-radius:10px; cursor:pointer; display: inline-block; padding: 2% 10%; text-align: center; margin: 5% 0 -1% 0; font-weight: 600px">
      핫플레이스
    </h1>
    <h1 id="freeboard" class="freeboard text-white fw-bold" style="cursor: pointer; display: inline-block; padding: 0 10%; text-align: center; margin: 5% 0 0 0; font-weight: 600px">
      자유게시판
    </h1>
  </div>


  <section id = "sec_hotplace" style="margin-top: 0px; background-color: antiquewhite; height: 1000px">
    <div class="container text-center">
      <div class="row">
        <div class="col">
          <div id="map" style="width: 300px; height: 300px;display: inline-block;"></div>
        </div>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a8d802b2b12a09c61b245184fb79fb74"></script>
        <div class="col" id="inputs-hotplace">
          <form style="display: inline-block;">
            <span class="fs-3 fw-bold">장소 등록 위치(지도에서 위치를 눌러주세요)</span><br/>
            <span>위도:</span><span id="location1"></span><br/>
            <span >경도:</span><span id="location2"></span><br/>
            <span class="fs-3 fw-bold">사진</span>
            <input onchange="PreviewImage();" type="file" id="imgSrc">
            <span class="fs-3 fw-bold">핫플 이름</span>
            <input type="text" id="placeName">
            <span class="fs-3 fw-bold">다녀온날짜</span>
            <input type="date" id="date">
            <span class="fs-3 fw-bold">장소유형</span>
            <select id="category" style="display: block; width: 100%">
              <option value="0" selected>관광지 유형</option>
              <option value="12">관광지</option>
              <option value="14">문화시설</option>
              <option value="15">축제공연행사</option>
              <option value="25">여행코스</option>
              <option value="28">레포츠</option>
              <option value="32">숙박</option>
              <option value="38">쇼핑</option>
              <option value="39">음식점</option>
            </select>
            <span class="fs-3 fw-bold">핫플 상세설명</span>
            <input type="text" id="detail">
            <button id="submit_hotplace" class="fw-bolder fs-3">등록</button>
          </form>
        </div>

      </div>
    </div>
    

  </section>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="./assets/js/hotplace.js"></script>
</body>
</html>
