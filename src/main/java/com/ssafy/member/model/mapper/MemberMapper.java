package com.ssafy.member.model.mapper;

import com.ssafy.member.model.dto.MemberDto;

public interface MemberMapper {
	int registerMember(MemberDto memberDto) throws Exception;

	MemberDto loginMember(MemberDto memberDto) throws Exception;

	void modifyMember(MemberDto memberDto) throws Exception;

	String getUserSalt(MemberDto memberDto) throws Exception;
}
