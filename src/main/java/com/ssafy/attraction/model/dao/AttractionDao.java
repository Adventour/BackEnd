package com.ssafy.attraction.model.dao;

import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDto;

public interface AttractionDao {
	public List<AttractionDto> doList(int sido, int gugun, int contentType);
}
