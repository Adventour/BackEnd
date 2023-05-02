package com.ssafy.follow.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.follow.model.service.FollowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/follow")
@Api(tags = "팔로우")
public class FollowController {

	private FollowService followService;
	
	public FollowController(FollowService followService) {
		this.followService = followService;
	}

	@PostMapping("/")
	@ApiOperation(value = "팔로우", notes = "팔로우 요청 API 입니다.")
	public ResponseEntity<?> follow(@RequestBody String followingId, HttpSession session) throws Exception {
//		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
//		String followerId = memberDto.getUserId();
		String followerId = "test";
		System.out.println(followingId);
		followService.followMember(followerId, followingId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	@ApiOperation(value = "언팔로우", notes = "언팔로우 요청 API 입니다.")
	public ResponseEntity<?> unFollow(@RequestBody String followingId, HttpSession session) throws Exception{
//		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
//		String followerId = memberDto.getUserId();
		String followerId = "test";
		System.out.println(followingId);
		followService.unFollowMember(followerId, followingId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// TODO
	// followList 불러오기

}
