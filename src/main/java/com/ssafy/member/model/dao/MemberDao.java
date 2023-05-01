package com.ssafy.member.model.dao;

import com.ssafy.member.model.dto.MemberDto;

public interface MemberDao {
	int registerMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(MemberDto memberDto) throws Exception;
	void modifyMember(MemberDto memberDto) throws Exception;
	String getUserSalt(MemberDto memberDto) throws Exception;
}
