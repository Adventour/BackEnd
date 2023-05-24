package com.ssafy.attraction.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDto implements Comparable<AttractionDto> {
	private int contentId; // 얘가 pk라 얘로 찾으면 될듯
	private int contentTypeId;
	private String title;
	private String addr;
	private String image;
	private int sidoCode;
	private int gugunCode;
	private double latitude;
	private double longitude;
	private int distance;
	private int hit;

	public void setDistance() {
		double nowLatitude = 37.5012743;
		double nowLongitude = 127.039585;
		this.distance = distanceByHaversine(longitude, latitude, nowLongitude, nowLatitude);
	}

	public int compareTo(AttractionDto o) {
		return this.distance - o.distance;
	}

	private int distanceByHaversine(double y1, double x1, double y2, double x2) {
		int distance;
		int radius = 6317;
		double toRadian = Math.PI / 180;

		double deltaLatitude = Math.abs(x1 - x2) * toRadian;
		double deltaLongitude = Math.abs(y1 - y2) * toRadian;

		double sinDeltaLat = Math.sin(deltaLatitude / 2);
		double sinDeltaLng = Math.sin(deltaLongitude / 2);

		double squareRoot = Math.sqrt(sinDeltaLat * sinDeltaLat
				+ Math.cos(x1 * toRadian) * Math.cos(x2 * toRadian) * sinDeltaLng * sinDeltaLng);
		distance = 2 * (int) (1000 * radius * Math.asin(squareRoot));
		return distance;
	}
}
