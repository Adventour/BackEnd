package com.ssafy.member.model.service;

import com.ssafy.member.model.dto.MemberDto;

public interface MemberService {
	int registerMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(MemberDto memberDto) throws Exception;
	void modifyMember(MemberDto memberDto) throws Exception;
	public String getUserSalt(MemberDto memberDto) throws Exception;
	void followMember(String followerId, String followingId) throws Exception;
	void unFollowMember(String followerId, String followingId) throws Exception;
}
