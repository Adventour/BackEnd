package com.ssafy.auth.jwt;

import com.ssafy.auth.dto.TokenResponseDto;
import com.ssafy.auth.error.ErrorCode;
import com.ssafy.auth.error.exception.UnauthorizedException;
import com.ssafy.auth.redis.RedisService;
import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/** JWT Token 생성 클래스 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final RedisService redisService;
//    @Value()
    private String JWT_SECRET = "SSAFY@Super#Secret!Key";

    private static final long JWT_EXPIRATION_MS = 1000L * 60 * 30 * 20; //30분
    private static final long REFRESH_TOKEN_EXPIRATION_MS = 1000L * 60 * 60 * 24 * 7; //7일
    private static final String AUTHORITIES_KEY = "role"; //권한 정보 컬럼명

    public String generateAccessToken(JwtDto jwtDto) {

        final String encodeKey = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());
        final Date now = new Date();
        final Date accessTokenExpiresIn = new Date(now.getTime() + JWT_EXPIRATION_MS);

        final String accessToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("msr")
                .setIssuedAt(now)
                .setSubject(jwtDto.getUserId())
                .claim(AUTHORITIES_KEY, jwtDto.getAuthorities())
                .setExpiration(accessTokenExpiresIn)
                .signWith(SignatureAlgorithm.HS512, encodeKey)
                .compact();

        return accessToken;
    }

    public String generateRefreshToken(JwtDto jwtDto) {
        final String encodeKey = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());
        final Date now = new Date();
        final Date refreshTokenExpiresIn = new Date(now.getTime() + REFRESH_TOKEN_EXPIRATION_MS);
        final String refreshToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("msr")
                .setExpiration(refreshTokenExpiresIn)
                .signWith(SignatureAlgorithm.HS512, encodeKey)
                .compact();
        redisService.setValues(
                jwtDto.getUserId(),
                refreshToken,
                Duration.ofMillis(REFRESH_TOKEN_EXPIRATION_MS)
        );

        return refreshToken;
    }

    public TokenResponseDto generateToken(JwtDto jwtDto) throws HttpServerErrorException {
        log.debug("!");
        final String accessToken = generateAccessToken(jwtDto);
        log.debug("accessToken " + accessToken);
        final String refreshToken = generateRefreshToken(jwtDto);
        System.out.println("refreshToken " + refreshToken);

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // TODO
    //  Authentication 사용할 건지 생각

    /**
     * JWT 유효성 검사
     * @param token 검사 대상 JWT
     * @return boolean
     * @throws SignatureException 서명이 다를때
     * @throws MalformedJwtException JWT 구조가 아닐때
     * @throws ExpiredJwtException 만료기간이 지났을때
     * @throws UnsupportedJwtException 지원 불가
     * @throws IllegalArgumentException 매개변수 전달 오류
     */
    public boolean validateToken(String token) {
        final String encodedKey = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());
        try {
            Jwts.parser().setSigningKey(encodedKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException ex) {
            log.error("잘못된 JWT 서명입니다");
        } catch (ExpiredJwtException ex) {
            log.error("만료된 JWT 토큰입니다");
        } catch (UnsupportedJwtException ex) {
            log.error("지원하지 않는 JWT 토큰입니다");
        } catch (IllegalArgumentException ex) {
            log.error("JWT 토큰이 비어있습니다");
        }
        return false;
    }

    // TODO
    //  Exception throw로 변경할 지 생각
    public boolean validateRefreshToken(String userId, String refreshToken) {
        String redisRt = redisService.getValues(userId);
        return refreshToken.equals(redisRt);
    }


    public Claims parseClaims(String accessToken) {
        final String encodedKey = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());

        try {
            return Jwts.parser()
                    .setSigningKey(encodedKey)
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new UnauthorizedException(ErrorCode.INVALID_AUTH_TOKEN);
        }

        //권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        //Authentication 리턴
        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

}
