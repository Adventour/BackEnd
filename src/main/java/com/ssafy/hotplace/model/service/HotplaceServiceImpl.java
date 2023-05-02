package com.ssafy.hotplace.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.hotplace.model.dto.HotPlaceDto;
import com.ssafy.hotplace.model.mapper.HotPlaceMapper;

@Service
public class HotplaceServiceImpl implements HotplaceService {
	private HotPlaceMapper hotPlaceMapper;

	public HotplaceServiceImpl(HotPlaceMapper hotPlaceMapper) {
		this.hotPlaceMapper = hotPlaceMapper;
	}

	@Override
	public void addHotPlace(HotPlaceDto hotPlaceDto) throws Exception {
		hotPlaceMapper.addHotPlace(hotPlaceDto);
		
	}
	
	
}
