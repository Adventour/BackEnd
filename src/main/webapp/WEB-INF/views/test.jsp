<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<button id="test">버튼입니다</button>
</head>
<body>

</body>
</html>
<script>


	document.getElementById("test").addEventListener("click", function () {
		  const cities = [{id: 0, x : 3, y : 4}, {id: 1, x : 7, y : 5}, {id: 2, x : 10, y : 100}, {id:3, x:1, y:10}, {id:4, x:1, y:1}]
		  console.log("!" + cities.length)
		  
		  // 도시 간 거리 구하기
		  var distances = [];
		  for (let i = 0; i < cities.length; i++) {
		      var row = [];
		      for (let j = 0; j < cities.length; j++) {
		          const dx = cities[i].x - cities[j].x;
		          const dy = cities[i].y - cities[j].y;
		          row.push(Math.sqrt(dx * dx + dy * dy));
		      }
		      distances.push(row);
		  }

		  // 출발 도시 설정
		  const start = cities[0];

		  // 방문한 도시 표시
		  var visited = [start];

		  // 아직 방문하지 않은 도시
		  var unvisited = cities.slice(1);

		  // 최단 경로 계산
		  let totalDistance = 0;
		  while (unvisited.length) {
		      let nearestIndex = 0;
		      let nearestDistance = Infinity;
		      for (let i = 0; i < unvisited.length; i++) {
		          var distance = distances[visited.slice(-1)[0].id][unvisited[i].id];
		          if (distance < nearestDistance) {
		              nearestIndex = i;
		              nearestDistance = distance;
		          }
		      }
		      console.log(unvisited[nearestIndex].id)
		      visited.push(unvisited[nearestIndex]);
		      unvisited.splice(nearestIndex, 1);
		      totalDistance += nearestDistance;
		  }

		  // 마지막에 출발 도시로 돌아가는 거리 추가
		  totalDistance += distances[visited.slice(-1)[0].id][start.id];

		  console.log(visited)
		  console.log(totalDistance)
		  // 결과 반환
		  return { path: visited, distance: totalDistance };
	}
	);
</script>
	