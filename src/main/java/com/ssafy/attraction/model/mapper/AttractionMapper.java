package com.ssafy.attraction.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.dto.AttractionDto;

@Mapper
public interface AttractionMapper {
	public List<AttractionDto> searchList(AttractionDto attractionDto);
}
