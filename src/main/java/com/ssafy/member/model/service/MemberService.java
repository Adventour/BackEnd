package com.ssafy.member.model.service;

import com.ssafy.auth.dto.TokenResponseDto;
import com.ssafy.member.model.dto.MemberDto;

public interface MemberService {
	int registerMember(MemberDto memberDto) throws Exception;
	TokenResponseDto loginMember(MemberDto memberDto) throws Exception;
	void modifyMember(MemberDto memberDto) throws Exception;
	public String getUserSalt(MemberDto memberDto) throws Exception;

}
