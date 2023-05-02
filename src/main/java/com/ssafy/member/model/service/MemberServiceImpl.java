package com.ssafy.member.model.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;
import com.ssafy.member.model.service.MemberServiceImpl;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper MemberMapper;
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		MemberMapper = memberMapper;
	}

	@Override
	public int registerMember(MemberDto memberDto) throws Exception {
		System.out.println("meow Minseok");
		String pwd = memberDto.getUserPwd();
		String salt = salt();
		pwd = encrypt(pwd + salt);
		memberDto.setSalt(salt);
		memberDto.setUserPwd(pwd);
		MemberMapper.registerMember(memberDto);
		return 0;
	}
	
	@Override
	public MemberDto loginMember(MemberDto memberDto) throws Exception {
		String pwd = memberDto.getUserPwd();
		String salt = pwd + getUserSalt(memberDto);
		pwd = encrypt(salt);
		memberDto.setUserPwd(pwd);
		return MemberMapper.loginMember(memberDto);
	}
	
	@Override
	public void modifyMember(MemberDto memberDto) throws Exception {

		// TODO salt로 암호화 하는 과정 추가
		MemberMapper.modifyMember(memberDto);
		
	}
	
	public String getUserSalt(MemberDto memberDto) throws Exception {
		return MemberMapper.getUserSalt(memberDto);

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
