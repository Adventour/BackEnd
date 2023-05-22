package com.ssafy.member.model.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

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

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final PasswordEncoder passwordEncoder;
	private final MemberMapper memberMapper;
	private final JwtProvider jwtProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public int registerMember(MemberDto memberDto) throws Exception {
		String pwd = memberDto.getPwd();
//		String salt = salt();
//		pwd = encrypt(pwd + salt);
//		memberDto.setSalt(salt);
//		memberDto.setUserPwd(pwd);
		memberDto.setPwd(passwordEncoder.encode(pwd));
		memberDto.setRole(MemberRole.ROLE_USER);
//		memberDto.setUserId("doNotUserSalt");

		System.out.println(memberDto);
		// TODO 중복 아이디 경우 처리 필요
		memberMapper.registerMember(memberDto);

		return 0;
	}
	
	@Override
	public TokenResponseDto loginMember(MemberDto memberDto) throws Exception {
		try {
//			String pwd = passwordEncoder.encode(memberDto.getPwd());
//			String salt = pwd + getUserSalt(memberDto);
//			pwd = encrypt(salt);
//			memberDto.setPwd(pwd);
			memberDto.setRole(MemberRole.ROLE_USER);
			System.out.println(memberDto);
//			MemberDto loginMember = memberMapper.loginMember(memberDto);
//			if (loginMember == null) {
//				log.debug("로그인에서 문제 발생");
//				throw new Exception();
//			}
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(memberDto.getId(), memberDto.getPassword());
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

			JwtDto jwtDto = JwtDto.builder()
					.userId(memberDto.getId())
					.authorities(MemberRole.ROLE_USER.toString())
					.build();
//			JwtDto jwtDto = new JwtDto(memberDto);

			TokenResponseDto tokenResponseDto = jwtProvider.generateToken(jwtDto);
			System.out.println(tokenResponseDto);
			return tokenResponseDto;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void modifyMember(MemberDto memberDto) throws Exception {

		// TODO salt로 암호화 하는 과정 추가
		memberMapper.modifyMember(memberDto);
		
	}
	
	public String getUserSalt(MemberDto memberDto) throws Exception {
		return memberMapper.getUserSalt(memberDto);

	}

	@Override
	public MemberDto findByUserId(String userId) throws Exception {
		System.out.println("fffff" + userId);
		return memberMapper.findByUserId(userId);
	}

	public String salt() {
		String salt = "";
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			random.nextBytes(bytes);
			salt = new String(Base64.getEncoder().encode(bytes));
		} catch (Exception e) {
		}
		return salt;
	}
	
	public String encrypt(String salt) {
		String encryptedPwd = "";
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			random.nextBytes(bytes);

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(salt.getBytes());
			encryptedPwd = String.format("%128x", new BigInteger(1, messageDigest.digest()));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return encryptedPwd;
	}

}
