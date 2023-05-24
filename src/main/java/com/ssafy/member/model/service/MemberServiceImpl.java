package com.ssafy.member.model.service;

import com.ssafy.auth.dto.TokenResponseDto;
import com.ssafy.auth.jwt.JwtDto;
import com.ssafy.auth.jwt.JwtProvider;
import com.ssafy.member.model.MemberRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

	private final PasswordEncoder passwordEncoder;
	private final MemberMapper memberMapper;
	private final JwtProvider jwtProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public int registerMember(MemberDto memberDto) throws Exception {
		memberDto.setPwd(passwordEncoder.encode(memberDto.getPwd()));
		memberDto.setRole(MemberRole.ROLE_USER);
		memberMapper.registerMember(memberDto);
		return 0;
	}

	/** @return accessToken, refreshToken
	 * */
	@Override
	public TokenResponseDto loginMember(MemberDto memberDto) throws Exception {
		// 현재 관리자 권한 없기 때문에 임시 처리
		memberDto.setRole(MemberRole.ROLE_USER);

		// 검증 부분
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(memberDto.getId(), memberDto.getPassword());
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		JwtDto jwtDto = JwtDto.builder()
				.userId(memberDto.getId())
				.authorities(memberDto.getRole().toString())
				.build();

		TokenResponseDto tokenResponseDto = jwtProvider.generateToken(jwtDto);
		return tokenResponseDto;
	}
	
	@Override
	public void modifyMember(MemberDto memberDto) throws Exception {
		if (memberDto.getPwd() != null)
			memberDto.setPwd(passwordEncoder.encode(memberDto.getPwd()));

		memberMapper.modifyMember(memberDto);
	}

	@Override
	public MemberDto findByUserId(String userId) throws Exception {
		return memberMapper.findByUserId(userId);
	}

}
