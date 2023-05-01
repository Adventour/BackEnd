package com.ssafy.member.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private String userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String userDomain;
//	private int userSido=3;
//	private int userGugun=3;
	private String salt;

}
