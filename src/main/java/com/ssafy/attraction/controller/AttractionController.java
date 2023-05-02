package com.ssafy.attraction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.service.AttractionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/attraction")
@Api(tags = "관광지")
public class AttractionController {
	
	private AttractionService attractionService;
	
	public AttractionController(AttractionService attractionService) {
		this.attractionService = attractionService;
	}
	
	@PostMapping("/search")
	@ApiOperation(value = "관광지 검색", notes = "관광지 검색 요청 API 입니다.")
	public ResponseEntity<?> search(@RequestBody AttractionDto attractionDto) {
		List<AttractionDto> list = new ArrayList<AttractionDto>();
		list = attractionService.searchList(attractionDto);
		
		return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
	}
	
}






