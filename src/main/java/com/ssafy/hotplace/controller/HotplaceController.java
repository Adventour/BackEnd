package com.ssafy.hotplace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.hotplace.model.service.HotplaceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/hotplace")
@Api(tags = "핫플레이스")
public class HotplaceController{
       
	private HotplaceService hotplaceService;

	public HotplaceController(HotplaceService hotplaceService) {
		this.hotplaceService = hotplaceService;
	}

	@PostMapping("/")
	public ResponseEntity<?> addHotPlace() {
		// 어쩐담
		
		return null;
	}

	
}
