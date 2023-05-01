// 핫플레이스 구현

const freebtn = document.querySelector("#freeboard");
const hotbtn = document.querySelector("#hotplace");
const freeContent = document.querySelector("#sec_freeboard");
const hotplaceContent = document.querySelector("#sec_hotplace");
const submitHotplace = document.querySelector("#submit_hotplace");


freebtn.addEventListener("click", ()=> {
    hotplaceContent.style.display = "none"
    freeContent.style.display = "block";
})

hotbtn.addEventListener("click", ()=>{
    freeContent.style.display = "none"
    hotplaceContent.style.display = "block";
})


// 핫플 카카오 지도
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//사용자 지정 위치 가져오기
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        

    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);

    var resultDiv = document.getElementById('location1'); 
    var resultDiv2 = document.getElementById('location2'); 

    resultDiv.innerHTML = latlng.getLat();
    resultDiv2.innerHTML = latlng.getLng();
});


//submit한다면 사용자 입력 내용으로 오버레이 생성
submitHotplace.addEventListener("click", (e) => {
    e.preventDefault();

    const imgSrc = document.querySelector("#imgSrc").value;
    const placeName = document.querySelector("#placeName").value;
    const date = document.querySelector("#date").value;
    const category = document.querySelector("#category").options[document.querySelector("#category").selectedIndex].innerText;
    const detail = document.querySelector("#detail").value;



    var mapContent = '<div class="overlaybox" style="background-color: black; opacity: 50%; border-radius: 10px; color: white">' +
    '    <div class="boxtitle"나의 핫플레이스!</div>' +
    '    <ul>' +
    '       <li>' +
    `            <img src=${imgSrc}</img>` +
    '        </li>' +
    '       <li>' +
    '            <span class="number">핫플이름: </span>' +
    `            <span>${placeName}</span>` +
    '        </li>' +
    '        <li>' +
    '            <span class="number">다녀온날짜</span>' +
    `            <span>${date}</span>` +
    '        </li>' +
    '        <li>' +
    '            <span class="number">장소유형</span>' +
    `            <span>${category}</span>` +
    '        </li>' +
    '        <li>' +
    '            <span class="number">핫플상세설명</span>' +
    `            <span>${detail}</span>` +
    '        </li>' +
    '    </ul>' +
    '</div>';

        // 지도를 클릭한 위치에 표출할 마커입니다
    var customOverlay = new kakao.maps.CustomOverlay({ 
        // 지도 중심좌표에 마커를 생성합니다 
        position: map.getCenter(),
        content: mapContent,
        // text: '장소: 옥암동',
        // image: markerImage,
    }); 
    // 지도에 마커를 표시합니다
    marker.setMap();
    customOverlay.setMap(map);

        // console.log(imgSrc);
        // console.log(placeName);
        // console.log(date);
        // console.log(category);
        // console.log(detail);
        
})
