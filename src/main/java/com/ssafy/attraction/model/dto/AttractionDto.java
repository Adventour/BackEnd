package com.ssafy.attraction.model.dto;

public class AttractionDto implements Comparable<AttractionDto>{
	private int contentId; //얘가 pk라 얘로 찾으면 될듯
	private int content_type_id;
	private String title;
	private String addr;
	private String image;
	private double latitude;
	private double longitude;
	private int distance;
	
	
	public AttractionDto() {
		// TODO Auto-generated constructor stub
	}

	public int getContent_id() { return contentId; }
	
	public void setContent_id(int content_id) { this.contentId = content_id; }
	
	public int getContent_type_id() { return content_type_id; }
	
	public void setContent_type_id(int content_type_id) { this.content_type_id = content_type_id; }
	
	public String getTitle() { return title; }
	
	public void setTitle(String title) { this.title = title; }
	
	public double getLatitude() { return latitude; }
	
	public void setLatitude(double latitude) { this.latitude = latitude; }
	
	public double getLongitude() { return longitude; }
	
	public void setLongitude(double longitude) { this.longitude = longitude; }
	
	public void setDistance() {
		double nowLatitude = 37.5012743;
		double nowLongitude = 127.039585;
		this.distance = distanceByHaversine(longitude, latitude, nowLongitude, nowLatitude);
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	@Override
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
		
		double squareRoot = Math.sqrt(
				sinDeltaLat * sinDeltaLat + Math.cos(x1 * toRadian) * Math.cos(x2 * toRadian)
				* sinDeltaLng *  sinDeltaLng
		);
		distance = 2 * (int)(1000 * radius * Math.asin(squareRoot));
		return distance;
	}
}
