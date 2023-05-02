package com.ssafy.hotplace.model.service;

import java.util.List;

import com.ssafy.hotplace.model.dto.HotPlaceDto;

public interface HotplaceService {

	
	void addHotPlace(HotPlaceDto hotPlaceDto) throws Exception;

	void deleteHotPlace(HotPlaceDto hotPlaceDto);

	void modifyHotPlace(HotPlaceDto hotPlaceDto);

	List<HotPlaceDto> listHotPlace();

	List<HotPlaceDto> searchHotPlace(HotPlaceDto hotPlaceDto);
}
