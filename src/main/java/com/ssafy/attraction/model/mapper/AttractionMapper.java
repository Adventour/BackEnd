package com.ssafy.attraction.model.mapper;

import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDto;

public interface AttractionMapper {
	public List<AttractionDto> searchList(AttractionDto attractionDto);
}
