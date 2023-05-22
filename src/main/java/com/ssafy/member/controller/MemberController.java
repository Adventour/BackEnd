package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import com.ssafy.auth.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Slf4j
@RestController
@RequestMapping("/member")
@Api(tags = "유저")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/regist")
	@ApiOperation(value = "회원가입", notes = "회원가입 요청 API 입니다.")
	public ResponseEntity<?> regist(@RequestBody MemberDto memberDto) throws Exception {
		System.out.println(memberDto);
		try {
			memberService.registerMember(memberDto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(memberDto, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(memberDto, HttpStatus.OK);
	}

	@GetMapping("/test")
	public ResponseEntity<?> test(Authentication auth) {
		log.debug("로그인 된 사용자 id : " + auth.getName());
		return new ResponseEntity<>(auth.getName(), HttpStatus.OK);
	}

	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "로그인 요청 API 입니다.")
	public ResponseEntity<?> login(@RequestBody MemberDto memberDto) throws Exception {
		TokenResponseDto tokenResponseDto = null;
//		log.debug("로그인한 사용자 이름: " +auth.getName());
		try {
			tokenResponseDto = memberService.loginMember(memberDto);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.valueOf("로그인 실패"));
		}
		return new ResponseEntity<TokenResponseDto>(tokenResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃", notes = "로그아웃 요청 API 입니다.")
	public ResponseEntity<?> logout(HttpSession session) throws Exception {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	@ApiOperation(value = "정보 수정", notes = "회원 정보 수정 요청 API 입니다.")
	public ResponseEntity<?> modify(@RequestBody MemberDto modifyDto, HttpSession session) throws Exception {
		MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
		memberDto.setId(modifyDto.getId());
		memberDto.setName(modifyDto.getName());
		memberDto.setPwd(modifyDto.getPwd());
		memberService.modifyMember(memberDto);
		session.setAttribute("userinfo", memberDto);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
