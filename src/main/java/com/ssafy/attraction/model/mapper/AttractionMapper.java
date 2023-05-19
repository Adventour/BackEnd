package com.ssafy.attraction.model.mapper;

import java.util.List;

import com.ssafy.attraction.model.dto.GugunDto;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.dto.AttractionDto;

@Mapper
public interface AttractionMapper {
	public List<AttractionDto> searchList(AttractionDto attractionDto);

    public List<GugunDto> getGugun(int sidoCode);

    String getOverview(String contentId);
}
