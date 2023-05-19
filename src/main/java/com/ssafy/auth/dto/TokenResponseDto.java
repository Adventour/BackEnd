package com.ssafy.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
}
