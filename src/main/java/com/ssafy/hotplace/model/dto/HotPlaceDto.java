package com.ssafy.hotplace.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 내가 직접 작성하고 올리는 여행지
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotPlaceDto {
	private int hotPlaceId;
	private String userId;
	private String hotPlaceName;
	private String hotPlaceAddr;
	private String hotPlaceImage;
	private double longitude;
	private double latitude;
	private String descript;
}
