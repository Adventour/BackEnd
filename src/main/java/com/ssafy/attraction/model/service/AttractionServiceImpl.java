package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.dao.AttractionDao;
import com.ssafy.attraction.model.dao.AttractionDaoImpl;
import com.ssafy.attraction.model.dto.AttractionDto;

public class AttractionServiceImpl implements AttractionService{
	private static AttractionServiceImpl instance= new AttractionServiceImpl();
	private AttractionDao attractionDao= AttractionDaoImpl.getInstance();
	private AttractionServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static AttractionServiceImpl getInstance() {
		return instance;
	}
	@Override
	public List<AttractionDto> serviceList(int sido, int gugun, int contentType) {
		// TODO Auto-generated method stub
		return attractionDao.doList(sido, gugun, contentType);
	}
	
}
