package com.ssafy.follow.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {

	void followMember(String followerId, String followingId) throws Exception;
	void unFollowMember(String followerId, String followingId) throws Exception;
	
}
