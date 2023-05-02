package com.ssafy.hotplace.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hotplace.model.dto.HotPlaceDto;
import com.ssafy.hotplace.model.service.HotplaceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hotplace")
@Api(tags = "핫플레이스")
public class HotplaceController{
       
	private HotplaceService hotplaceService;

	public HotplaceController(HotplaceService hotplaceService) {
		this.hotplaceService = hotplaceService;
	}

	@GetMapping("/")
	@ApiOperation(value = "핫플레이스 조회", notes = "핫플레이스 조회 요청 API입니다.")
	public ResponseEntity<?> listHotPlace() throws Exception {
		List<HotPlaceDto> list = hotplaceService.listHotPlace();
		return new ResponseEntity<List<HotPlaceDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "핫플레이스 등록", notes = "핫플레이스 등록 요청 API입니다.")
	public ResponseEntity<?> addHotPlace(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		hotplaceService.addHotPlace(hotPlaceDto);
		return new ResponseEntity<HotPlaceDto>(hotPlaceDto, HttpStatus.OK);
	}
	
	@PutMapping("/")
	@ApiOperation(value = "핫플레이스 수정", notes = "핫플레이스 수정 요청 API입니다.")
	public ResponseEntity<?> modifyHotPlace(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		hotplaceService.modifyHotPlace(hotPlaceDto);
		return new ResponseEntity<HotPlaceDto>(hotPlaceDto, HttpStatus.OK);
	}

	@DeleteMapping("/")
	@ApiOperation(value = "핫플레이스 삭제", notes = "핫플레이스 삭제 요청 API 입니다.")
	public ResponseEntity<?> deleteHotPlace(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		hotplaceService.deleteHotPlace(hotPlaceDto);
		return new ResponseEntity<HotPlaceDto>(hotPlaceDto, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	@ApiOperation(value = "핫플레이스 검색", notes = "핫플레이스 검색 요청 API 입니다.")
	public ResponseEntity<?> searchHotPlace(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		List<HotPlaceDto> list = hotplaceService.searchHotPlace(hotPlaceDto);
		return new ResponseEntity<List<HotPlaceDto>>(list, HttpStatus.OK);
	}
}
