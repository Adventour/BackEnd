package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDto;

public interface AttractionService {
	public List<AttractionDto> serviceList(int sido, int gugun, int contentType);
}
