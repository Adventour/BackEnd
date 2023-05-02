package com.ssafy.hotplace.model.mapper;

import java.util.List;

import com.ssafy.hotplace.model.dto.HotPlaceDto;

public interface HotPlaceMapper {

	void addHotPlace(HotPlaceDto hotPlaceDto);

	void deleteHotPlace(HotPlaceDto hotPlaceDto);

	void modifyHotPlace(HotPlaceDto hotPlaceDto);

	List<HotPlaceDto> listHotPlace();

	List<HotPlaceDto> searchHotPlace(HotPlaceDto hotPlaceDto);

}
