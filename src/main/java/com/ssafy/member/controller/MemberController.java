package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/member")
@Api(tags = "유저")
public class MemberController {
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/regist")
	@ApiOperation(value = "회원가입", notes = "회원가입 요청 API 입니다.")
	public ResponseEntity<?> regist(@RequestBody MemberDto memberDto) throws Exception {
//		memberService.registerMember(memberDto);
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "로그인 요청 API 입니다.")
	public ResponseEntity<?> login(@RequestBody MemberDto memberDto, HttpSession session) throws Exception {
		MemberDto loginMember = memberService.loginMember(memberDto);
		session.setAttribute("userinfo", loginMember);
		return new ResponseEntity<MemberDto>(loginMember, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃", notes = "로그아웃 요청 API 입니다.")
	public ResponseEntity<?> logout(HttpSession session) throws Exception {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	@ApiOperation(value = "정보 수정", notes = "회원 정보 수정 요청 API 입니다.")
	public ResponseEntity<?> modify(@RequestBody MemberDto modifyDto, HttpSession session) throws Exception {
		MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
		memberDto.setUserId(modifyDto.getUserId());
		memberDto.setUserName(modifyDto.getUserName());
		memberDto.setUserPwd(modifyDto.getUserPwd());
		memberService.modifyMember(memberDto);
		session.setAttribute("userinfo", memberDto);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
