package com.ssafy.attraction.controller;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.attraction.model.dto.GugunDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.service.AttractionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/attraction")
@Api(tags = "관광지")
@RequiredArgsConstructor
public class AttractionController {

    private final AttractionService attractionService;


    @GetMapping("/search")
    @ApiOperation(value = "관광지 검색", notes = "관광지 검색 요청 API 입니다.")
    public ResponseEntity<?> search(@ModelAttribute AttractionDto attractionDto) {
        System.out.println(attractionDto.getTitle());
        List<AttractionDto> list = new ArrayList<AttractionDto>();
        list = attractionService.searchList(attractionDto);

        return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
    }

    @GetMapping("/hit")
    @ApiOperation(value = "검색한 관광지 TOP3 검색", notes = "검색한 관광지 TOP3 요청 API 입니다.")
    public ResponseEntity<List<AttractionDto>> top3() {
        List<AttractionDto> list = new ArrayList<AttractionDto>();
        list = attractionService.getTop3();
        return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
    }

    @PutMapping("/hit/{contentId}")
    @ApiOperation(value = "조회한 관광지 조회수 증가", notes = "조회한 관광지 조회수 증가 요청 API 입니다.")
    public ResponseEntity<Void> updateHit(@PathVariable int contentId) {
        attractionService.updateHit(contentId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/gugun")
    @ApiOperation(value = "구군 검색", notes = "구군 검색 요청 API 입니다.")
    public ResponseEntity<List<GugunDto>> gugun(@RequestParam("sido") int sidoCode) {
        List<GugunDto> list = new ArrayList<GugunDto>();
        list = attractionService.getGugun(sidoCode);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/overview")
    @ApiOperation(value = "상세정보", notes="관광지 상세 정보 요청 API 입니다.")
    public ResponseEntity<String> overview(@RequestParam String contentId) {
        return new ResponseEntity<String>(attractionService.getOverview(contentId), HttpStatus.OK);
    }
}






