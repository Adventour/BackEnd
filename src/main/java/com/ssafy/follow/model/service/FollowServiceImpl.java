package com.ssafy.follow.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.follow.model.mapper.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService {

	private FollowMapper followMapper;
	
	public FollowServiceImpl(FollowMapper followMapper) {
		this.followMapper = followMapper;
	}

	@Override
	public void followMember(String followerId, String followingId) throws Exception {
		followMapper.followMember(followerId, followingId);
	}

	@Override
	public void unFollowMember(String followerId, String followingId) throws Exception {
		followMapper.unFollowMember(followerId, followingId);
	}
}
