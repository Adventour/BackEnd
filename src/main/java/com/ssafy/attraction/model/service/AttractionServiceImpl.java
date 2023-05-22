package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.dto.GugunDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService{

	private final AttractionMapper attractionMapper;

	@Override
	public AttractionDto findAttractionById(int contentId) {
		return attractionMapper.findAttractionById(contentId);
	}

	@Override
	public List<AttractionDto> searchList(AttractionDto attractionDto) {
		return attractionMapper.searchList(attractionDto);
	}

	@Override
	public List<GugunDto> getGugun(int sidoCode) {
		return attractionMapper.getGugun(sidoCode);
	}

	@Override
	public String getOverview(String contentId) {
		return attractionMapper.getOverview(contentId);
	}

}
