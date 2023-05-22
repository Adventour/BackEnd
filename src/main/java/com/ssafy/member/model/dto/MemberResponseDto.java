package com.ssafy.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String id;
    private String name;
    private String email;
    private String domain;

    public static MemberResponseDto of(MemberDto memberDto) {
        return MemberResponseDto.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .domain(memberDto.getDomain())
                .build();
    }
}
