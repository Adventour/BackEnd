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


@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/regist")
	public ResponseEntity<?> regist(@RequestBody MemberDto memberDto) throws Exception {
//		memberService.registerMember(memberDto);
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDto memberDto, HttpSession session) throws Exception {
		MemberDto loginMember = memberService.loginMember(memberDto);
		session.setAttribute("userinfo", loginMember);
		return new ResponseEntity<MemberDto>(loginMember, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) throws Exception {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/modify")
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
