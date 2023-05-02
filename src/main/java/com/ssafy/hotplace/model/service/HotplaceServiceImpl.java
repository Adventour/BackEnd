package com.ssafy.hotplace.model.service;

import java.util.List;

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

	@Override
	public void deleteHotPlace(HotPlaceDto hotPlaceDto) {
		hotPlaceMapper.deleteHotPlace(hotPlaceDto);
		
	}

	@Override
	public void modifyHotPlace(HotPlaceDto hotPlaceDto) {
		hotPlaceMapper.modifyHotPlace(hotPlaceDto);
	}

	@Override
	public List<HotPlaceDto> listHotPlace() {
		return hotPlaceMapper.listHotPlace();
	}

	@Override
	public List<HotPlaceDto> searchHotPlace(HotPlaceDto hotPlaceDto) {
		hotPlaceDto.setHotPlaceName("%"+hotPlaceDto.getHotPlaceName()+"%");
		return hotPlaceMapper.searchHotPlace(hotPlaceDto);
	}
	
	
}
