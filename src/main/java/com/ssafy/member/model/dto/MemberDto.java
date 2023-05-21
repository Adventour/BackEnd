package com.ssafy.member.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userDomain;
    private int userSido;
    private int userGugun;
    private String salt;

}
