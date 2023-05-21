package com.ssafy.auth.jwt;

import com.ssafy.member.model.dto.MemberDto;
import lombok.*;

@Getter
@Setter
@Builder
//@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class JwtDto {

    private String userId;
    private String authorities;

//    public JwtDto(MemberDto memberDto) {
//        this.userId = memberDto.getUserId();
//        this.authorities = memberDto.getAuthorities().toString();
//    }
}
