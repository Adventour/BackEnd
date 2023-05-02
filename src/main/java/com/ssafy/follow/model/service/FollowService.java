package com.ssafy.follow.model.service;

public interface FollowService {
	void followMember(String followerId, String followingId) throws Exception;
	void unFollowMember(String followerId, String followingId) throws Exception;
}
