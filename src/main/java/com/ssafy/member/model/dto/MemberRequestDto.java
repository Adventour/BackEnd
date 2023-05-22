package com.ssafy.member.model.dto;

import com.ssafy.member.model.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Valid;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    @Valid
    private String userId;
    @Valid
    private String userPwd;

    public MemberDto toUser(PasswordEncoder passwordEncoder) {
        return MemberDto.builder()
                .id(userId)
                .pwd(passwordEncoder.encode(userPwd))
                .role(MemberRole.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userId, userPwd);
    }
}
