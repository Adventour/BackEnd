package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.dto.GugunDto;

public interface AttractionService {

    public AttractionDto findAttractionById(int contentId);
	public List<AttractionDto> searchList(AttractionDto attractionDto);

    public List<GugunDto> getGugun(int sidoCode);

    String getOverview(String contentId);

    List<AttractionDto> getTop3();

    void updateHit(int contentId);
}
